/**
 * 
 */
package com.techgeeknext.camel.routes;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a13400520
 *
 */
@RestController
@RequestMapping("/camel")
public class CamelRestController {

	@Autowired
	private ProducerTemplate camelTemplate;

	@Value(value = "${activemq.dummyQ}")
	public String DUMMY_Q;

	@PostMapping("/sendMessage")
	public ResponseEntity<String> sendMessage(@RequestBody String message) {
		try {
			/**
			 * Producing the data to DUMMY_Q 1 way direction
			 */
			camelTemplate.sendBodyAndHeader(DUMMY_Q, ExchangePattern.InOnly, message, "trial_count", 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("Success uploaded the data", HttpStatus.OK);
	}

}
