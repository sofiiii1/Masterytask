package com.example.mastery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String jobTitle;
    private Gender gender;
    private Date dateOfBirth;

}
