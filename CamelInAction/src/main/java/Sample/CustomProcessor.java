package Sample;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		String custom = exchange.getIn().getBody(String.class);
		String substr = custom.substring(0,5);
		String newBody = substr;
		
		exchange.getIn().setBody(newBody.concat("Header"));
		
		
	}

}
