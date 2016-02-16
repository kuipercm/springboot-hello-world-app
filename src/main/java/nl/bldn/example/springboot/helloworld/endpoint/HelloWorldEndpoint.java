package nl.bldn.example.springboot.helloworld.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A very basic "hello world!" endpoint.
 *
 * <p>
 *     This endpoint exposes the string "hello world!" on the path "/helloworld" to any GET request.
 * </p>
 * <p>
 *     This class is scanned and configured by the @ComponentScan annotation on the
 *     {@link nl.bldn.example.springboot.helloworld.HelloWorldApplication} class.
 * </p>
 */
@RestController
public class HelloWorldEndpoint {

    @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello world!";
    }

}
