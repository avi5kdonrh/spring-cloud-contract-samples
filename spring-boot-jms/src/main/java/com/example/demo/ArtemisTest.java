package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class ArtemisTest {
	public static void main(String[] args) throws Exception{
		String url = "tcp://localhost:61616";
		String user = "admin";
		String password = "admin";
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(user,password,url);
		Connection connection = activeMQConnectionFactory.createConnection();
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(session.createQueue("TEST"));
		for(int i = 0; i < 1; i++) {
			Message message = session.createTextMessage(i+"");
			messageProducer.send(message);
		}

	}
}
