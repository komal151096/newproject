package com.tanmay.example2;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProducerAndConsumerExample {
	public static void main(String[] args) throws Exception {
		
		/*Producer is going to produce something which means its going to send something to the 
		endpoint, and consumer is going to receive something whatever the sent by the producer.*/
		
		CamelContext context =new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				
				/* Here, just simply wants to send message to the endpoint so the same message 
				 * will be sent to the another endpoint. So whatever message is sent to another endpoint, 
				 so we want to receive message from that endpoint*/
				
				from("direct:start")
				.to("seda:end"); //Both direct and seda are inbuilt component
			}
		});
		
		context.start();
		
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello Everyone");
		
		
		ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
		String message= consumerTemplate.receiveBody("seda:end", String.class);
		System.out.println(message);
	}
}


/* What we have done here is: 
 * Create Camel Context
 * Added the Router
 * Defined what the Router has to do 
 * Created the Producer Template, sending the message to 'direct' endpoint and we're consuming the message from 'seda' endpoint
 * That't what this Producer and Consumer Template does
 *  */
