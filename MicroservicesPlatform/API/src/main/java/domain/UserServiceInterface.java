
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
public interface UserServiceInterface {


 //                                                                                                                                           //
//---------------------------------------------------------------------Users----------------------------------------------------------------//
//  
      
 //                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/Users/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> createUser(@RequestBody User user);

//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(method = RequestMethod.GET, value = "/CustomerService/Users/", params = {"userID"})
    ResponseEntity<User> selectUser(@RequestParam(value = "userID") int userID);

//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/CustomerService/Users/{userID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> updateUser(@PathVariable("userID") int userID, @RequestBody User updatedUserValues);

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(method = RequestMethod.DELETE, value = "/CustomerService/Users/{userID}", params = {"userID"})
    ResponseEntity<User> deleteUser(@RequestParam(value = "userID") int userID);

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//              
    

   @RequestMapping("/CustomerService/Test")
    public String getTestMessage();

}
