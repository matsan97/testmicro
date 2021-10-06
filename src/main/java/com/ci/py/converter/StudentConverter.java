/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.converter;

import com.ci.py.dto.StudentDTO;
import com.ci.py.model.response.StudentResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author matias
 */
@Component
public class StudentConverter {

    public StudentResponse buildDTOtoStudentResponse(StudentDTO dto) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(dto.getId());
        studentResponse.setDate(dto.getDate());
        studentResponse.setDocumentNumber(dto.getDocumentNumber());
        studentResponse.setEmail(dto.getEmail());
        studentResponse.setFirstName(dto.getName());
        studentResponse.setLastName(dto.getLastName());
        studentResponse.setGender(dto.getGender());
        studentResponse.setHeight(dto.getHeight());
        studentResponse.setWeight(dto.getWeight());
        studentResponse.setStudentId(dto.getId());
        studentResponse.setStudentId(dto.getId());
        studentResponse.setCreationDateTime(dto.getCreationDateTime());
        return studentResponse;
    }
}
