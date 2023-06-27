package com.example.shopproject.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRq {

    private String username;
    private String email;
    private String password;

    private String confirmpassword;

}
