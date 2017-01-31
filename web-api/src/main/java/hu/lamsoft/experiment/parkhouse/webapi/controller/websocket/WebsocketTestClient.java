package hu.lamsoft.experiment.parkhouse.webapi.controller.websocket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Component
public class WebsocketTestClient {
	
	private static final String TEST_URL = "ws://echo.websocket.org";
	
	/*public static void init(){
		System.out.println("Start websocket client");
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new StringMessageConverter());
		//stompClient.setTaskScheduler(taskScheduler); // for heartbeats
		
		
		StompSessionHandler sessionHandler = new MyStompSessionHandler();
		stompClient.connect(TEST_URL, sessionHandler);
		
		
	}*/
	
	
	public static void init() {
		try{
			AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(ClientConfig.class);
			System.out.println("\n\n\nWhen ready, press any key to exit\n\n\n");
			System.in.read();
			cxt.close();
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		finally {
			System.exit(0);
		}
	}

	@Configuration
	static class ClientConfig {

		@Bean
		public WebSocketConnectionManager connectionManager() {
			WebSocketConnectionManager manager = new WebSocketConnectionManager(client(), handler(), TEST_URL);
			manager.setAutoStartup(true);
			return manager;
		}

		@Bean
		public StandardWebSocketClient client() {
			return new StandardWebSocketClient();
		}

		@Bean
		public SimpleClientWebSocketHandler handler() {
			return new SimpleClientWebSocketHandler(greetingService());
		}

		@Bean
		public GreetingService greetingService() {
			return new SimpleGreetingService();
		}
	}
	
}
