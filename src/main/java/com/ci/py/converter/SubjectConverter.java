/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.converter;

import com.ci.py.dto.SubjectDTO;
import com.ci.py.model.response.SubjectResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author matias
 */
@Component
public class SubjectConverter {

    public SubjectResponse buildDTOtoSubjectResponse(SubjectDTO dto) {
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setId(dto.getId());
        subjectResponse.setName(dto.getName());
        return subjectResponse;
    }
}
