package in.shiv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.model.User;

@RestController
public class XmlController {
	
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> processXml(@RequestBody User user) {
        try {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
