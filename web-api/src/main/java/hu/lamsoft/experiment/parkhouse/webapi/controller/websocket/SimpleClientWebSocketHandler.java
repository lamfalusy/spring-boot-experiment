package hu.lamsoft.experiment.parkhouse.webapi.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleClientWebSocketHandler extends TextWebSocketHandler {
	
	private final GreetingService greetingService;


	@Autowired
	public SimpleClientWebSocketHandler(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		TextMessage message = new TextMessage(this.greetingService.getGreeting());
		session.sendMessage(message);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Received: " + message);
		session.close();
	}

}
