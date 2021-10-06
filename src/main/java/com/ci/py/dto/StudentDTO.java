/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.dto;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author matias
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    
    private Integer id;
    private String name;
    private String lastName;
    private Date date;
    private String gender;
    private Integer height;
    private Integer weight;
    private String email;
    private Date creationDateTime;
    private String documentNumber;
}
