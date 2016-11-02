/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author Idorf
 */
@SpringBootApplication
@EnableEurekaClient
public class Run {
      public static void main(String[] args) {
    SpringApplication.run(Run.class, args);
  }

}
