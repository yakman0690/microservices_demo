/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Test
 */
@Getter
@Setter
public class CustomData {
    private Date date;
    private String payload;
}
