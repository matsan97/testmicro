/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.service.serviceImpl;

import com.ci.py.converter.StudentConverter;
import com.ci.py.dto.StudentDTO;
import com.ci.py.model.exception.DataBaseException;
import com.ci.py.model.response.StudentResponse;
import com.ci.py.repository.StudentRepository;
import com.ci.py.service.StudentService;
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
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentConverter converter;

    @Override
    public StudentResponse getStudentById(Integer id, String logId) throws DataBaseException{
        try {
            StudentDTO student = repository.GetStudentById(id, logId);
            if (Objects.isNull(student)) {
                return null;
            }
            return converter.buildDTOtoStudentResponse(student);
        } catch (DataBaseException ex) {
            Logger.getLogger(StudentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataBaseException(ex.getMessage());
        }
    }

}
