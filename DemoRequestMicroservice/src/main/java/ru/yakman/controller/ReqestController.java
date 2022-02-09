/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakman.domain.CustomData;
import ru.yakman.service.GetDataFromRemoteMiscroservice;

/**
 *
 * @author Test
 */
@RestController
@RefreshScope
public class ReqestController {

    @Autowired
    private GetDataFromRemoteMiscroservice service;

    @GetMapping("/request")
    public CustomData getData() {
        System.out.println("request microservice called");
        return service.getData();
    }
}
