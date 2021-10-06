/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.service;

import com.ci.py.model.exception.DataBaseException;
import com.ci.py.model.response.SubjectResponse;

/**
 *
 * @author matias
 */
public interface SubjectService {   

    public SubjectResponse getSubjectById(Integer id, String logId) throws DataBaseException;

}
