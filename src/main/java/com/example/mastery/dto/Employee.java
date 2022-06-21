package com.example.mastery.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String jobTitle;
    private Gender gender;
    private Date dateOfBirth;
    public void setGender(String gender){
        this.gender= Gender.valueOf(gender.toUpperCase());
    }

}
