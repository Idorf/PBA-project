/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
//@RestController //@RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.  -- https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
//@Controller annotation indicates that a particular class serves the role of a controller.
//@ResponseBody indicates that the return type should be written straight to the HTTP response body 
@RestController
@RequestMapping("/TechnicianService/Technicians")
@SpringBootApplication
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------CRUD-CONTROLLER-TechnicianService----------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class TechnicianController {

    @Autowired
    JdbcTemplate jdbcTemplate;
  
//                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Technician> createTechnician(@RequestBody Technician technician) {
        
                jdbcTemplate.update(
                "insert into technician (employe_id, first_name, last_name) values (?, ?, ?)",
               technician.getEmployeId(), technician.getFirstName(), technician.getLastName());
               // customer.getContactPerson(), customer.getCompany());

        return new ResponseEntity<>(technician, HttpStatus.OK);
        
        
            }
//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"technicianID"})
    public ResponseEntity<Technician> selectTechnician(@RequestParam int technicianID) {
        
          String sql = "SELECT * FROM technician WHERE technician_id = ?";

        Technician technician = (Technician) jdbcTemplate.queryForObject(sql, new Object[]{technicianID}, new TechnicianRowMapper());
      

        if (technician == null) {

            return new ResponseEntity<>(technician, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(technician, HttpStatus.OK);
        
        
        
    }
//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{technicianID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Technician> updateTechnician(@PathVariable("technicianID") int technicianID, @RequestBody Technician updatedTechnicianValues) {
 System.out.println("-------------------------------test");

        jdbcTemplate.update("UPDATE technician SET first_name = ?, last_name = ?,  employe_id = ?  where technician_id = ?", updatedTechnicianValues.getFirstName(), updatedTechnicianValues.getLastName(), updatedTechnicianValues.getEmployeId(), technicianID);

        String sql = "SELECT * FROM technician WHERE technician_id = ?";

        updatedTechnicianValues = (Technician) jdbcTemplate.queryForObject(sql, new Object[]{technicianID}, new TechnicianRowMapper());

        if (updatedTechnicianValues == null) {
            System.out.println("Unable to delete. Technician with id " + technicianID + " not found");
            return new ResponseEntity<>(updatedTechnicianValues, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedTechnicianValues, HttpStatus.OK);
    }
//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(value = "/{technicianID}", method = RequestMethod.DELETE)
    public ResponseEntity<Technician> deleteTechnician(@PathVariable("technicianID") int technicianID) {

         jdbcTemplate.update("DELETE FROM technician WHERE technician_id = ?", technicianID);

        String sql = "SELECT * FROM technician WHERE technician_id = ?";

        Technician technician = (Technician) jdbcTemplate.queryForObject(sql, new Object[]{technicianID}, new TechnicianRowMapper());

        if (technician == null) {
            System.out.println("Unable to delete. Technician with id " + technicianID + " not found");
            return new ResponseEntity<>(technician, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(technician, HttpStatus.NO_CONTENT);

    }

//                                                                                                                                           //
//--------------------------------------------------------------------TEST-------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping("/Test")
    public String getTestMessage() {

        return "Test message from TechnicianService ";
    }

}
