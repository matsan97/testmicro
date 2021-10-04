/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.service.serviceImpl;

import com.ci.py.converter.ExampleConverter;
import com.ci.py.repository.ExampleRepository;
import com.ci.py.service.ExampleService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Mendoza
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository repository;

    @Autowired
    private ExampleConverter converter;

    @Override
    public List<String> getCategoryList() {
        List<String> categories = repository.retrieveCategoria();
        if (Objects.isNull(categories) || categories.isEmpty()) {
            return null;
        }
        return converter.buildCategoryList(categories);
    }

}
