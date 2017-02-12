/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
//@RestController //@RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.  -- https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
//@Controller annotation indicates that a particular class serves the role of a controller.
//@ResponseBody indicates that the return type should be written straight to the HTTP response body 
@RestController
@RequestMapping("/CustomerService/Users")
@SpringBootApplication
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------CRUD-CONTROLLER-API------------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class APIUserController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    UserServiceInterface UserServiceInterface;

//                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUsers(@RequestBody User user) {
        return UserServiceInterface.createUser(user);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"userID"})
    public ResponseEntity<User> selectUser(@RequestParam int userID) {
        return UserServiceInterface.selectUser(userID);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{userID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userID") int userID, @RequestBody User updatedUserValues) {

        return UserServiceInterface.updateUser(userID, updatedUserValues);
    }
//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("userID") int userID) {

        return UserServiceInterface.deleteUser(userID);

    }

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping("/Test")
    public String getTestMessage() {

        return UserServiceInterface.getTestMessage();
    }

}
