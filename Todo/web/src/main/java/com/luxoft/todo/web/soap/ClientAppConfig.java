package com.luxoft.todo.web.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig{
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.luxoft.wsdl");
		return marshaller;
	}
	@Bean
	public TodoClient todoClient(Jaxb2Marshaller marshaller) {
		TodoClient client = new TodoClient();
		client.setDefaultUri("http://localhost:8080/soapws/todo.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
