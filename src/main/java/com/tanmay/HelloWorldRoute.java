package com.tanmay;

import org.apache.camel.builder.RouteBuilder;

public class HelloWorldRoute extends RouteBuilder {

	/*RouteBulder class is an abstract class and it has one abstract method, 
	 so we have to override the abstract method */
	
	@Override
	public void configure() throws Exception {
		System.out.println("Hello World in Camel!!");
		
	}

}
