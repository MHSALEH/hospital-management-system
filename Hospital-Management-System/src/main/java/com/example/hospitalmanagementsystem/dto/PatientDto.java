package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

import java.awt.*;

@Data
public class PatientDto {
    private Long patientID;

    private String name;

    private int age;

    private String phone;

    private  String email;

}
