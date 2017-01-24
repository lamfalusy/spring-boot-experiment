package hu.lamsoft.experiment.parkhouse.webapi.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello "+name;
	}

}
