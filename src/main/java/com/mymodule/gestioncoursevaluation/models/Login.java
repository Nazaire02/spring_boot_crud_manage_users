package com.mymodule.gestioncoursevaluation.models;

import lombok.Data;

@Data
public class Login {
    private String email;
    private String password;
    private String usertype;
}
