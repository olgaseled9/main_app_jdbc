package com.seledtsova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private Long id;
    private String firstname;
    private String lastname;
    private Long departmentId;
    private String jobTitle;
    private String gender;
    private String dateOfBirth;


}





