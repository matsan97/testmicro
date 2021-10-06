/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Mendoza
 */
@Component
public class ExampleConverter {

    public List<String> buildCategoryList(List<String> categories) {
        List<String> listCategory = new ArrayList<>();
        categories.forEach((category) -> {
            listCategory.add(category);
        });
        return listCategory;
    }

}
