/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Idorf
 */
//@RestController //@RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.  -- https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
//@Controller annotation indicates that a particular class serves the role of a controller.
//@ResponseBody indicates that the return type should be written straight to the HTTP response body 
@RestController
public class APIController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    CustomerService CustomerServiceInterface;
    
    @Autowired
    TechnicianService TechnicianServiceInterface;

    @RequestMapping("/CustomerService")
    public String getCustomer() {

        return CustomerServiceInterface.getCustomer();
    }

    @RequestMapping("/TechnicianService")
    public String getTechnician() {
        return TechnicianServiceInterface.getTechnician();
    }
}
