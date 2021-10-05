
package com.techgeeknext.camel.routes;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

	@Autowired
	private Processor dummyProcessor;

	@Value(value = "${activemq.dummyQ}")
	public String DUMMY_Q;
	
	@Value(value = "${activemq.dummyQ_1}")
	public String DUMMY_Q_1;

	@Override
	public void configure() throws Exception {
		/**
		 * Configuring a route from DUMMY_Q with delay of 5 second then process the request via dummyProcessor and send the response to DUMMY_Q_1
		 */
		from(DUMMY_Q).delay(5000).process(dummyProcessor).to(DUMMY_Q_1);
	}
}
