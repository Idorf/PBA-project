/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

/**
 *
 * @author Idorf
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication  //Same as @Configuration @EnableAutoConfiguration @ComponentScan -- http://docs.spring.io/autorepo/docs/spring-boot/current/reference/html/using-boot-using-springbootapplication-annotation.html
@EnableEurekaClient     //Makes the app into both a Eureka "instance" (i.e. it registers itself) and a "client"  -- http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#spring-cloud-eureka-server
                            //@Configuration == Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
                            //@EnableAutoConfiguration == Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. 
                            //@Configures component scanning directives for use with @Configuration classes. 

//@RestController //@RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.  -- https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
                    //@Controller annotation indicates that a particular class serves the role of a controller.
                    //@ResponseBody indicates that the return type should be written straight to the HTTP response body 


//@EnableFeignClients
public class RunAPI {

  public static void main(String[] args) {
    SpringApplication.run(RunAPI.class, args);
  }

}
