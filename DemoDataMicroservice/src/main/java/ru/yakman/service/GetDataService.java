/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.service;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.yakman.domain.CustomData;

/**
 *
 * @author Test
 */
@Service
public class GetDataService {
    
    
    @Value("${string.additional}")
    private String additionalString;

    public CustomData getRandomData() {
        CustomData data = new CustomData();
        data.setDate(new Date());
        data.setPayload(additionalString+" : "+randomString());
        return data;
    }

    public static String randomString() {
        int n = 10;
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));

        StringBuilder r = new StringBuilder();
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }
        return r.toString();
    }
}
