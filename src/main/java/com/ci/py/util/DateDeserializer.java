/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author matias
 */
public class DateDeserializer extends StdDeserializer<Date> {

    protected DateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = (String) jsonParser.readValueAs(String.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (value != null && !value.isEmpty()) {
            try {
                return dateFormat.parse(value);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }
}
