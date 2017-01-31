package hu.lamsoft.experiment.parkhouse.webapi.controller.websocket;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

public class MyStompSessionHandler implements StompSessionHandler {

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterConnected(StompSession session, StompHeaders headers) {
		System.out.println("send");
		session.send("/", "test");
		
		System.out.println("subscribe");
		session.subscribe("/", new StompFrameHandler() {
			
			@Override
			public void handleFrame(StompHeaders headers, Object payload) {
				System.out.println("Received: "+payload);
				
			}
			
			@Override
			public Type getPayloadType(StompHeaders headers) {
				return String.class;
			}
		});

	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] a, Throwable e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTransportError(StompSession session, Throwable e) {
		// TODO Auto-generated method stub

	}

}
