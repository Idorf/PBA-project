package main.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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
@RequestMapping("/CustomerService/Customers")
@SpringBootApplication
public class CustomerServiceController {

    @Autowired
    JdbcTemplate jdbcTemplate;

//                                                                                                                                           //
//--------------------------------------------------------------------CREATE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        System.out.println("-------------------------------create");

        jdbcTemplate.update(
                "CAll CreateCustomer(?,?,?,?,?,?,?,?)",
                customer.getCustomerType(), customer.getCustomerName(), customer.getCity(), customer.getAddressLine1StreetName(), customer.getAddressLine2StreetNo(), customer.getAddressLine3BuildingNo(), customer.getZipcode(), customer.getOtherAdressDetails());
       
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"customerID"})
    public ResponseEntity<Customer> selectCustomer(@RequestParam(value = "customerID") int customerID) {
        System.out.println("-------------------------------select");

        String sql = "CALL SelectCustomer(?)";

        Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{customerID}, new CustomerRowMapper());

        if (customer == null) {

            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
//

    @RequestMapping(value = "/{customerID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updatedCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer updatedCustomerValues) {
        System.out.println("-------------------------------Update");

        jdbcTemplate.update(
                "CAll UpdateCustomer(?,?,?,?,?,?,?,?,?)",
                customerID, updatedCustomerValues.getCustomerType(), updatedCustomerValues.getCustomerName(), updatedCustomerValues.getCity(), updatedCustomerValues.getAddressLine1StreetName(), updatedCustomerValues.getAddressLine2StreetNo(), updatedCustomerValues.getAddressLine3BuildingNo(), updatedCustomerValues.getZipcode(), updatedCustomerValues.getOtherAdressDetails());

        String sql = "CALL SelectCustomer(?)";

        updatedCustomerValues = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{customerID}, new CustomerRowMapper());

        if (updatedCustomerValues == null) {

            System.out.println("Unable to delete. User with id " + customerID + " not found");
            return new ResponseEntity<>(updatedCustomerValues, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedCustomerValues, HttpStatus.OK);
    }

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/{customerID}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerID") int customerID) {

        jdbcTemplate.update("CALL DeleteCustomer (?)", customerID);

        String sql = "CALL SelectCustomer(?)";
        Customer customer;
        try {
            customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{customerID}, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
        
        if (customer == null) {
            System.out.println(customerID + " DELETED");
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);

    }
//                                                                                                                                         //
//--------------------------------------------------------------------TEST-----------------------------------------------------------------//
//                                                                                                                                         //

    @RequestMapping("/Test")
    public String getTestMessage() {

        return "Test message from local customerservice  ";
    }

}
