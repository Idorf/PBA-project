/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Idorf
 */
@FeignClient("TechnicianService")
public interface TechnicianService {

    @RequestMapping("/TechnicianService")
    public String getTechnician();
}
