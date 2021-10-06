/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.repository;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Mendoza
 */
@Repository
public class ExampleRepository extends JdbcDaoSupport {

    private static final String RETRIEVE_CATEGORY = "Select descripcion from categoria";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void initialize(@Qualifier("dataSourcePostgresql") DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<String> retrieveCategoria() {
        try {
            String sql = ExampleRepository.RETRIEVE_CATEGORY;
            return jdbcTemplate.queryForList(sql, String.class);
        } catch (DataAccessException ex) {
            throw ex;
        }
    }
}
