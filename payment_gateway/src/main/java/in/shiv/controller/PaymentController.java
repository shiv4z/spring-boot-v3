package in.shiv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Value("${stripe.api.key}")
	private String stripeApiKey;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/create-payment-intent")
	public Map<String, String> createPaymentIntent(@RequestBody Map<String, Object> request) {
		Stripe.apiKey = stripeApiKey;

		// Get the amount as a string and parse it to an integer
		String amountString = (String) request.get("amount");
		int amount = Integer.parseInt(amountString);

		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount((long) amount)
				.setCurrency("usd").build();

		PaymentIntent paymentIntent;
		try {
			paymentIntent = PaymentIntent.create(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create payment intent");
		}

		Map<String, String> responseData = new HashMap<>();
		responseData.put("client_secret", paymentIntent.getClientSecret());
		return responseData;
	}
}
