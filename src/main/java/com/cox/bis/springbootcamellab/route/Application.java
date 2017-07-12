/**
 * 
 */
package com.cox.bis.springbootcamellab.route;

/**
 * @author mkrishna
 *
 */
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cox.bis.springbootcamellab.api.model.SampleResponse;

@SpringBootApplication
@ComponentScan("com.cox.bis")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(),
				"/springbootcamellab/v1/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

	@Component
	class SampleRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {


		}
	}
}