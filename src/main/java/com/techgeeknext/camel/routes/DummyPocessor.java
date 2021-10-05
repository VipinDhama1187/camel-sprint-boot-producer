/**
 * 
 */
package com.techgeeknext.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * @author a13400520
 *
 */
@Component
public class DummyPocessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String methodName="process:";
		String originalFileContent = (String) exchange.getIn().getBody(String.class);
        String upperCaseFileContent = originalFileContent.toUpperCase();
        System.out.println("Inside "+methodName+"-->"+upperCaseFileContent);
        exchange.getIn().setBody(upperCaseFileContent);
	}

}
