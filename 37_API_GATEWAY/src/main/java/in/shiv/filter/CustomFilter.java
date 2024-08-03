package in.shiv.filter;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		//HttpHeaders headers = request.getHeaders();
		//System.out.println(headers);
		
		HttpHeaders headers = request.getHeaders();
		Set<Entry<String, List<String>>> entrySet = headers.entrySet();
		for(Entry<String, List<String>> e : entrySet) {
			System.out.println( e +"  "+e.getValue());
		}
		return chain.filter(exchange);
	}

}

