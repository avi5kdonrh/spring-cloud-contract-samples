package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NewListener {

	@JmsListener(concurrency = "1",destination = "TEST")
	public void onMessage(String message) throws Exception {
		System.out.println(">>> "+message);
	    Thread.sleep(50000);

	}
}
