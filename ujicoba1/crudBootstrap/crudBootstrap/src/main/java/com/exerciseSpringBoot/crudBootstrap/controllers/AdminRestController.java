/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exerciseSpringBoot.crudBootstrap.controllers;

import com.exerciseSpringBoot.crudBootstrap.entities.Datamhs;
import com.exerciseSpringBoot.crudBootstrap.entities.LoginForm;
import com.exerciseSpringBoot.crudBootstrap.entities.Matkul;
import com.exerciseSpringBoot.crudBootstrap.services.MatkulService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RequestMapping("api/restAdmin")
@RestController
public class AdminRestController {
    @Autowired
    MatkulService matkulservices;
    
    @RequestMapping(value="/check",method=RequestMethod.POST )
    public String checkLogin(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model){
        
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        
        if("admin".equals(username) && "admin".equals(password)){
            return "ksm";
        }
        model.addAttribute("invalid",true);
        return "login";
    }
    
    @PostMapping("/savematkul")
    public Matkul save (@Valid @RequestBody Matkul matkul){
        return matkulservices.savematkul(matkul);
    }
    
    
    
    
    

    
}
