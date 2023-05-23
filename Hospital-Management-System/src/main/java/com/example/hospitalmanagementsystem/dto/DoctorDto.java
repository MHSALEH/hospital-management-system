package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private Long doctorID ;

    private String name;

    private int age;

    private String phone;

    private double salary;

    private String email;

    private String speciaization;
}
