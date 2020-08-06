package com.tanmay.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
		
				from("file:input_box?noop=true") //file = component, input_box= endpoint (folder name), noop=true: Option
				.to("file:output_box");
				
				
				
			}
		});
		 while (true)
			 context.start();
		
	}
}
