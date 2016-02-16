package nl.bldn.example.springboot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * A basic hello world application in Spring Boot.
 *
 * <p>
 *     This class extends from {@link SpringBootServletInitializer}. This makes it possible to
 *     run the resulting war in a separate container and still use this as a starting point for
 *     the app. See also http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file.
 * </p>
 * <p>
 *     There are three annotations on this class: {@link Configuration}, {@link ComponentScan} and {@link EnableWebMvc}.
 *     The first (@Configuration) tells Spring that this class defines configuration beans, indicated by the @Bean annotation.
 *     The second (@ComponentScan) tells Spring to scan the current package and sub-packages
 *     for annotation processing (mostly {@link org.springframework.stereotype.Component} and friends).
 *     {@link EnableWebMvc} tells the Spring context to configure the current project for WebMVC.
 * </p>
 * <p>
 *     The class also defines a {@link Bean} of type {@link DispatcherServlet}. Every Spring WebMVC application needs
 *     such a servlet. When using one of the spring boot starter poms, this is usually taken care of by some default
 *     configuration, but in this case, it needs to be defined separately.
 * </p>
 * <p>
 *     Lastly, this class defines a {@link EmbeddedServletContainerFactory}. This is necessary to tell the application
 *     which embedded server to start when the application is started. In this case it has been chosen to use
 *     Tomcat as the embedded container, but it could just as easily have been Jetty. All that is required to
 *     change it, is to change the dependency in the pom and the servlet container factory defined here.
 * </p>
 * <p>
 *     The configuration items (the DispatcherServlet and the EmbeddedServletContainerFactory) are here
 *     because it was decided not to use one of the starter poms. The auto-magic configuration is therefore
 *     not used and it becomes necessary to define this configuration explicitly.
 * </p>
 *
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class HelloWorldApplication extends SpringBootServletInitializer {
    private static final int SERVER_PORT = 8765;

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @Bean
    @Autowired
    DispatcherServlet getDispatchServlet(WebApplicationContext webAppContext) {
        return new DispatcherServlet(webAppContext);
    }

    @Bean
    EmbeddedServletContainerFactory getTomcatEmbeddedServletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory(SERVER_PORT);
    }
}
