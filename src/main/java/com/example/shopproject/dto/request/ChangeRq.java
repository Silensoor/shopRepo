package com.example.shopproject.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeRq {
    private Integer id;
    private Integer categoryId;
}
