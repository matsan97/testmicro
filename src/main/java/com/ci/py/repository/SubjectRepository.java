/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.repository;

import com.ci.py.dto.SubjectDTO;
import com.ci.py.dto.rowmapper.SubjectRowMapper;
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
public class SubjectRepository extends JdbcDaoSupport {

    private static final String ERROR_DATABASE = "Data Base error";

    private final String SELECT_SUBJECT_BY_ID = "SELECT subject_id, name FROM subjects WHERE subject_id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void initialize(@Qualifier("dataSourcePostgresql") DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public SubjectDTO GetSubjectById(Integer id, String logId) throws DataBaseException {
        try {
            Object[] params = new Object[]{id};
            return jdbcTemplate.queryForObject(SELECT_SUBJECT_BY_ID, params, new SubjectRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            throw new DataBaseException(ERROR_DATABASE + e.getMessage());
        }

    }

}
