
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
@RequestMapping("/TechnicianService/Technicians")
@SpringBootApplication
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------CRUD-CONTROLLER-API------------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class APITechnicianController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    TechnicianServiceInterface TechnicianServiceInterface;

//                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Technician> createTechnician(@RequestBody Technician technician) {
        return TechnicianServiceInterface.createTechnician(technician);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"technicianID"})
    public ResponseEntity<Technician> selectTechnician(@RequestParam int technicianID) {
        return TechnicianServiceInterface.selectTechnician(technicianID);
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{technicianID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Technician> updateTechnician(@PathVariable("technicianID") int technicianID, @RequestBody Technician updatedTechnicianValues) {

        return TechnicianServiceInterface.updateTechnician(technicianID, updatedTechnicianValues);
    }
//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{technicianID}", method = RequestMethod.DELETE)
    public ResponseEntity<Technician> deleteTechnician(@PathVariable("technicianID") int technicianID) {

        return TechnicianServiceInterface.deleteTechnician(technicianID);

    }

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping("/Test")
    public String getTestMessage() {

        return "Test message from API ";
    }

}
