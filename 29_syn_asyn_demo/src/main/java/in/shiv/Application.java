package in.shiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Api exceution start ::");
		WebClient webClient = WebClient.create();
		webClient.get()
		         .uri("http://localhost:8080/welcome")
		         .retrieve()
		         .bodyToMono(String.class)
				 .subscribe(Application::handleMethod);
		System.out.println("Api response :: ");
	}

	public static void handleMethod(String response) {
		System.out.println(response);
	}
}
