/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.dto.rowmapper;

import com.ci.py.dto.SubjectDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matiasS
 */
public class SubjectRowMapper implements RowMapper<SubjectDTO> {

    private static final String ID = "subject_id";
    private static final String NAME = "name";

    @Override
    public SubjectDTO mapRow(ResultSet rs, int arg1) throws SQLException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(rs.getInt(ID));
        subjectDTO.setName(rs.getString(NAME));
        return subjectDTO;
    }

}
