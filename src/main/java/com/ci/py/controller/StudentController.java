package com.ci.py.controller;

import com.ci.py.model.exception.DataBaseException;
import com.ci.py.model.response.ErrorMessageResponse;
import com.ci.py.model.response.StudentResponse;
import com.ci.py.model.response.StudentResponseData;
import com.ci.py.service.StudentService;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/{student_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentById(
            @PathVariable(value = "student_id", required = true) Integer id,
            @RequestHeader(value = "log_id", required = false) String logId) {
        try {
            StudentResponse student = service.getStudentById(id, logId);
            if (student == null) {
                ErrorMessageResponse errorMessage = new ErrorMessageResponse();
                errorMessage.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                errorMessage.setMessage(HttpStatus.NOT_FOUND.name());
                return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new StudentResponseData(student), HttpStatus.OK);
        } catch (DataBaseException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
