package com.ci.py.controller;

import com.ci.py.model.exception.DataBaseException;
import com.ci.py.model.response.ErrorMessageResponse;
import com.ci.py.model.response.SubjectResponse;
import com.ci.py.model.response.SubjectResponseData;
import com.ci.py.service.SubjectService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Mendoza
 */
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping(value = "/{subject_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubjectById(
            @PathVariable(value = "subject_id", required = true) Integer id,
            @RequestHeader(value = "log_id", required = false) String logId) {
        try {
            SubjectResponse subject = service.getSubjectById(id, logId);
            if (subject == null) {
                ErrorMessageResponse errorMessage = new ErrorMessageResponse();
                errorMessage.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                errorMessage.setMessage(HttpStatus.NOT_FOUND.name());
                return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new SubjectResponseData(subject), HttpStatus.OK);
        } catch (DataBaseException ex) {
            Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
