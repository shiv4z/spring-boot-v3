package in.shiv.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="WELCOME-API")
public interface FeignClientInterface {
	@GetMapping("/welcome")
	public String invoke();

}
