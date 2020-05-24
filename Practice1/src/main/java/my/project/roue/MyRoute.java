package my.project.roue;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder{

	@Override
    public void configure() throws Exception {

        restConfiguration()
                .bindingMode(RestBindingMode.auto)
                .component("servlet");

        rest()
                .path("/hello")

                .get("/")
                .route()
                .transform(simple("Good Morning"))
                .endRest()

                .post("/")
                .route()
                .to("log:mylogger?showAll=true")
                .transform(simple("Welcome: ${body[name]}"))
                .endRest();

    }

}
