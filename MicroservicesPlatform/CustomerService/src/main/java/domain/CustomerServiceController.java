package domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Idorf
 */
@RestController
public class CustomerServiceController {

    @RequestMapping("/CustomerService")
    public String getSentence() {

        return "hallo from customerservice";
    }

}
