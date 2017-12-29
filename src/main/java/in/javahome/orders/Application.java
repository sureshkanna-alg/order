package in.javahome.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	String hostName = System.getenv("HOSTNAME");

	@RequestMapping("/")
	public String home() {
		return "<h1>Welcome to Orders App - Deployed in docker container</h1>";
	}

	@RequestMapping(path = "order/{id}", method = RequestMethod.GET)
	public String customer(@PathVariable("id") int custId) {
		StringBuffer response = new StringBuffer()
		.append("<h3>Container Host Name("+hostName+")</h3>")
		.append("Customer Id "+OrderService.getOrder(custId));
		return response.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
