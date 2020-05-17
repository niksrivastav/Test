package test.camelrestdsl;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.annotations.Component;
import org.springframework.http.MediaType;

@Component
public class CamelRestDslRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		
		rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("Welcome Hello World"));
		
	}

}
