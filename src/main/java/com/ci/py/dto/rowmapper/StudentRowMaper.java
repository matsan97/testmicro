/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.dto.rowmapper;

import com.ci.py.dto.StudentDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matiasS
 */
public class StudentRowMaper implements RowMapper<StudentDTO> {

    private static final String STUDENT_ID = "student_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BIRTH_DATE = "birth_date";
    private static final String GENDER = "gender";
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";
    private static final String EMAIL = "email";
    private static final String CREATION_DATE_TIME = "creation_date_time";
    private static final String DOCUMENT_NUMBER = "document_number";

    @Override
    public StudentDTO mapRow(ResultSet rs, int arg1) throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(rs.getInt(STUDENT_ID));
        studentDTO.setName(rs.getString(FIRST_NAME));
        studentDTO.setLastName(rs.getString(LAST_NAME));
        studentDTO.setDate(rs.getDate(BIRTH_DATE));
        studentDTO.setGender(rs.getString(GENDER));
        studentDTO.setHeight(rs.getInt(HEIGHT));
        studentDTO.setWeight(rs.getInt(WEIGHT));
        studentDTO.setEmail(rs.getString(EMAIL));
        studentDTO.setCreationDateTime(rs.getDate(CREATION_DATE_TIME));
        studentDTO.setDocumentNumber(rs.getString(DOCUMENT_NUMBER));
        return studentDTO;
    }

}
