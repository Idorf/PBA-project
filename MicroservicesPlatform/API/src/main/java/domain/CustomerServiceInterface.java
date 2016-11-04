/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/create_customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);

//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(method = RequestMethod.GET, value = "/CustomerService/select_customer", params = {"customerID"})
    ResponseEntity<Customer> selectCustomer(@RequestParam(value = "customerID") int customerID);

//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/update_customer/{customerID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    Customer updateCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer updatedCustomerValues);

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(method = RequestMethod.DELETE, value = "/CustomerService/delete_customer/{customerID}", params = {"customerID"})
    ResponseEntity<Customer> deleteCustomer(@RequestParam(value = "customerID") int customerID);

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping("/CustomerService/Test")
    public String getTestMessage();

}
