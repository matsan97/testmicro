/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.model.response;

import com.ci.py.util.DateDeserializer;
import com.ci.py.util.DateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author matias
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse implements Serializable {

    @Min(1)
    @Max(999999999)
    @NotNull
    @JsonProperty(value = "id")
    private Integer studentId;

    @Size(min = 1, max = 80)
    @NotNull
    @JsonProperty(value = "first_name")
    private String firstName;

    @Size(min = 1, max = 80)
    @NotNull
    @JsonProperty(value = "last_name")
    private String lastName;

    @Size(min = 1, max = 15)
    @NotNull
    @JsonProperty(value = "document_number")
    @Pattern(regexp = "[0-9]([0-9])*([A-Z])?")
    private String documentNumber;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonProperty(value = "date")
    @NotNull
    private Date date;

    @JsonProperty(value = "gender")
    @NotNull
    @Pattern(regexp = "((M | F),?)+")
    private String gender;

    @JsonProperty(value = "height")
    @NotNull
    private Integer height;

    @JsonProperty(value = "wight")
    @NotNull
    private Integer weight;

    @Size(min = 1, max = 40)
    @NotNull
    @JsonProperty(value = "email")
    private String email;

    @NotNull
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonProperty(value = "creation_date_time")
    private Date creationDateTime;

}
