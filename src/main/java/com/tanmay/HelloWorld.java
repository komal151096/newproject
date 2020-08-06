package com.tanmay;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {

	public static void main(String[] args) throws Exception {
		CamelContext context =new DefaultCamelContext();
		context.addRoutes(new HelloWorldRoute());
		/*Context.addRoutes method takes RouteBuilder as an argument. 
		So we have to create RouteBuilder instance and we have to inject that instance in this
		particular class */
	
		
		context.start();
	}
}
