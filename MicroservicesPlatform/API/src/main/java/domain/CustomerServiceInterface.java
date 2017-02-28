
package domain;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Idorf
 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------------------------------CRUD-FEIGN-INTERFACE-API-----------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@FeignClient("CustomerService")
public interface CustomerServiceInterface {

//                                                                                                                                           //
//---------------------------------------------------------------------Customers----------------------------------------------------------------//
//  
    
   
//                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/Customers/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);

//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(method = RequestMethod.GET, value = "/CustomerService/Customers/", params = {"customerID"})
    ResponseEntity<Customer> selectCustomer(@RequestParam(value = "customerID") int customerID);

//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/Customers/{customerID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> updateCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer updatedCustomerValues);

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(method = RequestMethod.DELETE, value = "/CustomerService/Customers/{customerID}", params = {"customerID"})
    ResponseEntity<Customer> deleteCustomer(@RequestParam(value = "customerID") int customerID);


//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//              
    
    
    @RequestMapping("/CustomerService/Customers/Test")
    public String getTestMessage();

        @RequestMapping("/CustomerService/Customers/Test2")
    public String getTestMessage2();

}


