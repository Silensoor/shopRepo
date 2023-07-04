package com.example.shopproject.dto.request;

import com.example.shopproject.model.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.ManyToOne;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRs {
    private Integer id;
    private String name;
    private Double price;
    private Integer category;
}
