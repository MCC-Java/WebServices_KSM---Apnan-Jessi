/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.webservice.services;


import com.mcc.webservice.entities.Admin;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class AdminRestService {
    
    private final String uri = "http://localhost:8080/api/restAdmin";
    private static final RestTemplate restTemplate = new RestTemplate();
    
    public List<Admin> getAll(){
        ResponseEntity<List<Admin>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Admin>>(){
                    
                });
        List<Admin> result = response.getBody();
        return result;
    }
    
    public void save(Matkul matkul){
        Matkul result = restTemplate.postForObject(uri, + "/savematkul", matkul, Matkul.class);
        
    }
    
}
