/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.yakman.domain.CustomData;

/**
 *
 * @author Test
 */
@Service
public class GetDataFromRemoteMiscroservice {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Value("${string.additional}")
    private String additionalString;

    public CustomData getData() {
        return circuitBreakerFactory.create("demodatarequest").run(
                () -> {

                    CustomData data = restTemplate.getForObject("http://service/demo-data/data", CustomData.class);
                    data.setPayload(data.getPayload() + " " + additionalString);
                    return data;

                },
                throwable -> fallbackF());
    }

    private CustomData fallbackF() {
        CustomData data = new CustomData();
        data.setDate(new Date());
        data.setPayload("NO_PAYLOAD");
        return data;
    }
}
