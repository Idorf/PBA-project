package main.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//-----------------------------------------------------------CRUD-CONTROLLER-CUSTOMERSERVICE-------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@RestController
@RequestMapping("/CustomerService")
public class CustomerServiceController {

    @Autowired
    CustomerRepository customerRepository;

//                                                                                                                                           //
//--------------------------------------------------------------------CREATE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/create_customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/select_customer", method = RequestMethod.GET, params = {"customerID"})
    public ResponseEntity<Customer> selectCustomer(@RequestParam(value = "customerID") int customerID) {

        Customer customer = customerRepository.findOne(customerID);

        if (customer == null) {
            System.out.println("Unable to delete. User with id " + customerID + " not found");
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/update_customer/{customerID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updatedCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer updatedCustomerValues) {
        System.out.println("-------------------------------test");

        Customer customer = customerRepository.findOne(customerID);
        if (customer == null) {
            System.out.println("Unable to delete. User with id " + customerID + " not found");
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }

        //set new event information in the current customer object.
        customer.setCompany(updatedCustomerValues.getCompany());
        customer.setContactPerson(updatedCustomerValues.getContactPerson());

        //save to database
        customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/delete_customer/{customerID}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerID") int customerID) {

        System.out.println("Fetching & Deleting User with id " + customerID);

        Customer customer = customerRepository.findOne(customerID);
        if (customer == null) {
            System.out.println("Unable to delete. User with id " + customerID + " not found");
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }

        customerRepository.delete(customerID);

        return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);

    }
//                                                                                                                                         //
//--------------------------------------------------------------------TEST-----------------------------------------------------------------//
//                                                                                                                                         //

    @RequestMapping("/Test")
    public String getTestMessage() {

        return "Test message from customerservice ";
    }

}
