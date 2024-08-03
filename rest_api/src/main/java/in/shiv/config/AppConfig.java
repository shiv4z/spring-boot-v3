package in.shiv.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
            
	 @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        // Create XML converter
	        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
	        xmlConverter.setDefaultCharset(null);
	        xmlConverter.setSupportedMediaTypes(getSupportedXmlMediaTypes());

	        // Create JSON converter
	        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	        jsonConverter.setDefaultCharset(null);
	        jsonConverter.setSupportedMediaTypes(getSupportedJsonMediaTypes());

	        // Add both converters to the list of converters
	        converters.add(xmlConverter);
	        converters.add(jsonConverter);
	    }

	    private List<MediaType> getSupportedXmlMediaTypes() {
	        List<MediaType> mediaTypes = new ArrayList<>();
	        mediaTypes.add(MediaType.APPLICATION_XML);
	        mediaTypes.add(MediaType.APPLICATION_ATOM_XML);
	        mediaTypes.add(MediaType.APPLICATION_XHTML_XML);
	        return mediaTypes;
	    }

	    private List<MediaType> getSupportedJsonMediaTypes() {
	        List<MediaType> mediaTypes = new ArrayList<>();
	        mediaTypes.add(MediaType.APPLICATION_JSON);
	        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
	        return mediaTypes;
	    }


}