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
@FeignClient("TechnicianService")
public interface TechnicianServiceInterface {


 //                                                                                                                                           //
//---------------------------------------------------------------------CREATE----------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/TechnicianService/Technicians/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Technician> createTechnician(@RequestBody Technician technician);

//                                                                                                                                           //
//---------------------------------------------------------------------READ------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(method = RequestMethod.GET, value = "/TechnicianService/Technicians/", params = {"technicianID"})
    ResponseEntity<Technician> selectTechnician(@RequestParam(value = "technicianID") int technicianID);

//                                                                                                                                           //
//---------------------------------------------------------------------EDIT------------------------------------------------------------------//
//                                                                                                                                           //
    @RequestMapping(value = "/TechnicianService/Technician/{technicianID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Technician> updateTechnician(@PathVariable("technicianID") int technicianID, @RequestBody Technician updatedTechnicianValues);

//                                                                                                                                           //
//--------------------------------------------------------------------DElETE-----------------------------------------------------------------//
//                                                                                                                                           //

    @RequestMapping(method = RequestMethod.DELETE, value = "/TechnicianService/Technician/{technicianID}", params = {"technicianID"})
    ResponseEntity<Technician> deleteTechnician(@RequestParam(value = "technicianID") int technicianID);

  
}
