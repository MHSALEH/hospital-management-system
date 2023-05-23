package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MedicalRecordDto {
    private Long recordID;

    private String medicineName;

    private Date date;
}
