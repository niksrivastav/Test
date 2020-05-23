package my.project.roue;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import my.project.model.ResponseObject;

@Component
public class MyRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
        restConfiguration()
          .component("servlet")
          .bindingMode(RestBindingMode.json);

        // REST DSL with a single GET /hello service
        rest()
          .get("/hello")
    	      .to("direct:hello");

        // route called from REST service that builds a response message
        from("direct:hello")
          .log("Hello World")
          .bean(this, "createResponse");
		
	}
	
	public ResponseObject createResponse() {
        ResponseObject response = new ResponseObject();
        response.setResponse("Hello World");
        response.setName("Nikkhil");
        return response;
    }

}
