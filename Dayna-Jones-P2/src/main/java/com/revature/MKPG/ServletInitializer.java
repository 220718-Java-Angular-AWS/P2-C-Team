package com.revature.MKPG;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    /*
    During servlet initialization this sets the class containing the main method.
    From https://www.baeldung.com/spring-boot-servlet-initializer:

    "This is an extension of WebApplicationInitializer which runs a SpringApplication from a traditional
    WAR archive deployed on a web container. This class binds Servlet, Filter and ServletContextInitializer
    beans from the application context to the server.

    Extending the SpringBootServletInitializer class also allows us to configure our application when it's
    run by the servlet container, by overriding the configure() method."
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(P2Application.class);
    }

}