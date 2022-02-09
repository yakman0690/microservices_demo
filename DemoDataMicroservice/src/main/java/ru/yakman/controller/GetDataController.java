/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakman.domain.CustomData;
import ru.yakman.service.GetDataService;

/**
 *
 * @author Test
 */
@RestController
public class GetDataController {
    
    @Autowired
    private GetDataService getDataService;
    
    
    
    @GetMapping("/data")
    public CustomData getData(){
        System.out.println("data controller called");
        return getDataService.getRandomData();
    }
    
    
    
}
