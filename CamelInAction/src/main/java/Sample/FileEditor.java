package Sample;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileEditor {

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
            	from("file:C://inputFolder?noop=true").transform(body().regexReplaceAll("Hello", "Hii!!!"))
        		.to("file:C://outputFolder");

            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
