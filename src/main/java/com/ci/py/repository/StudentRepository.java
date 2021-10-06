/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.repository;

import com.ci.py.dto.StudentDTO;
import com.ci.py.dto.rowmapper.StudentRowMaper;
import com.ci.py.model.exception.DataBaseException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author matias
 */
@Repository
public class StudentRepository extends JdbcDaoSupport {

    private static final String ERROR_DATABASE = "Data Base error";

    private final String SELECT_STUDENT_BY_ID = "SELECT student_id, first_name, last_name, birth_date, gender, height, \n"
            + "                                       weight, email, creation_date_time, document_number\n"
            + "                                       FROM students WHERE student_id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void initialize(@Qualifier("dataSourcePostgresql") DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public StudentDTO GetStudentById(Integer id, String logId) throws DataBaseException {
        try {
            Object[] params = new Object[]{id};
            return jdbcTemplate.queryForObject(SELECT_STUDENT_BY_ID, params, new StudentRowMaper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            throw new DataBaseException(ERROR_DATABASE + e.getMessage());
        }
    }

}
