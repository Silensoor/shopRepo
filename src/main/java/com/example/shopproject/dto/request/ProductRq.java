package com.example.shopproject.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRq {
    private String name;
    private double price;

}
