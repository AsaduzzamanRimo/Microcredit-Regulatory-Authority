package com.doer.mraims;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImsCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsCommonApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

//	@Bean
//	public Jaxb2Marshaller marshaller(){
//		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//		marshaller.setContextPath(JAXBContext.JAXB_CONTEXT_FACTORY);
//		marshaller.setMarshallerProperties(Map.of("com.sun.xml.bind.xmlHeaders","<?xml version=\"1.0\"?>", Marshaller.JAXB_FRAGMENT, false));
//		return marshaller;
//	}

}
