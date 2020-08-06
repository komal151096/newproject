package com.tanmay.example4;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ExchangeObject {
	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {


				from("direct:start")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						//System.out.println("I am the Processor");
						
						String message = exchange.getIn().getBody(String.class);// Here, we received the message
						message = message + " -By Tanmay Tripathi"; // Doing customization
						exchange.getOut().setBody(message); // Set the object back to the exchange object
						
						/*Before my consumer going to receive the message, I want to append something on top of the
						 * same message, so that message my consumer should receive*/
					}
				})
				.to("seda:end");
				
			}
		} );
		
		context.start();
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello EveryOne");
		
		ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
		String message= consumerTemplate.receiveBody("seda:end", String.class);
		System.out.println(message);
	}
	

}
