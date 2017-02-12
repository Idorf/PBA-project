
package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Idorf
 */
//@RestController //@RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.  -- https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
//@Controller annotation indicates that a particular class serves the role of a controller.
//@ResponseBody indicates that the return type should be written straight to the HTTP response body 
@RestController
@RequestMapping("/CustomerService/Customers")
@SpringBootApplication
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------CRUD-CONTROLLER-API------------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class APICustomerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    CustomerServiceInterface CustomerServiceInterface;

//                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return CustomerServiceInterface.createCustomer(customer);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"customerID"})
    public ResponseEntity<Customer> selectCustomer(@RequestParam int customerID) {
        return CustomerServiceInterface.selectCustomer(customerID);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{customerID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer updatedCustomerValues) {

        return CustomerServiceInterface.updateCustomer(customerID, updatedCustomerValues);
    }
//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{customerID}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerID") int customerID) {

        return CustomerServiceInterface.deleteCustomer(customerID);

    }

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping("/Test")
    public String getTestMessage() {

        return CustomerServiceInterface.getTestMessage();
    }

}
