package hu.lamsoft.experiment.parkhouse.webapi.controller.websocket;

public class SimpleGreetingService implements GreetingService {

	@Override
	public String getGreeting() {
		return "Hello world!";
	}

}
