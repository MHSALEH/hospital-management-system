package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);

    PatientDto getPatient(Long patientID);

    List<PatientDto> getAllPatients();

    PatientDto updatePatient(Long patientID, PatientDto patientDto);

    void deletePatient(Long patientID);
}
