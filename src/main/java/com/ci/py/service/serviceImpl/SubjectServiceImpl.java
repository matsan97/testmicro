/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.service.serviceImpl;

import com.ci.py.converter.SubjectConverter;
import com.ci.py.dto.SubjectDTO;
import com.ci.py.model.exception.DataBaseException;
import com.ci.py.model.response.SubjectResponse;
import com.ci.py.repository.SubjectRepository;
import com.ci.py.service.SubjectService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Mendoza
 */
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private SubjectConverter converter;

    @Override
    public SubjectResponse getSubjectById(Integer id, String logId) throws DataBaseException{
        try {
            SubjectDTO subject = repository.GetSubjectById(id, logId);
            if (Objects.isNull(subject)) {
                return null;
            }
            return converter.buildDTOtoSubjectResponse(subject);
        } catch (DataBaseException ex) {
            Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataBaseException(ex.getMessage());
        }
    }

}
