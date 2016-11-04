package main.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import main.domain.Customer;
import main.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

   @Autowired
  CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

    @PostConstruct
    public void init() {
        List<Customer> list = new ArrayList<>();

        Customer customer = new Customer();
        customer.setCompany("KEA");
        customer.setContactPerson("Peter");
        list.add(customer);

        customer = new Customer();
        customer.setCompany("CBS");
        customer.setContactPerson("Hans");
        list.add(customer);

       customerRepository.save(list);
    }

}
