package main.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@RequestMapping("/CustomerService/Users")
@SpringBootApplication
public class UserServiceController {

    @Autowired
    JdbcTemplate jdbcTemplate;

//                                                                                                                                           //
//--------------------------------------------------------------------CREATE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {

        jdbcTemplate.update(
                "CALL CreateUser (?,?,?,?,?,?)",
               user.getUserType(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getTelephoneNo(), user.getCustomerId());
               // customer.getContactPerson(), customer.getCompany());
               // "insert into user (role_id, first_name,last_name,email,telephone_no) values (?, ?, ?, ?, ?)",

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"userID"})
    public ResponseEntity<User> selectUser(@RequestParam(value = "userID") int userID) {

        String sql = "SELECT * FROM user WHERE user_id = ?";

        User user = (User) jdbcTemplate.queryForObject(sql, new Object[]{userID}, new UserRowMapper());

        if (user == null) {

            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
//

    @RequestMapping(value = "/{userID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updatedUser(@PathVariable("userID") int userID, @RequestBody User updatedUserValues) {
        System.out.println("-------------------------------test");

        jdbcTemplate.update("UPDATE user SET role_id = ?, first_name = ?, last_name = ?, email = ?, telephone_no = ?   where user_id = ?", updatedUserValues.getUserType(), updatedUserValues.getFirstName(), updatedUserValues.getLastName(), updatedUserValues.getEmail(), updatedUserValues.getTelephoneNo(), userID);

        String sql = "SELECT * FROM user WHERE user_id = ?";

        updatedUserValues = (User) jdbcTemplate.queryForObject(sql, new Object[]{userID}, new UserRowMapper());

        if (updatedUserValues == null) {
            System.out.println("Unable to delete. User with id " + userID + " not found");
            return new ResponseEntity<>(updatedUserValues, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedUserValues, HttpStatus.OK);
    }

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("userID") int userID) {

        jdbcTemplate.update("DELETE FROM user WHERE user_id = ?", userID);

        String sql = "SELECT * FROM user WHERE user_id = ?";

        User user = (User) jdbcTemplate.queryForObject(sql, new Object[]{userID}, new CustomerRowMapper());

        if (user == null) {
            System.out.println("Unable to delete. User with id " + userID + " not found");
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);

    }
//                                                                                                                                         //
//--------------------------------------------------------------------TEST-----------------------------------------------------------------//
//                                                                                                                                         //

    @RequestMapping("/Test")
    public String getTestMessage() {

        return "Test message from customerservice ";
    }

}
