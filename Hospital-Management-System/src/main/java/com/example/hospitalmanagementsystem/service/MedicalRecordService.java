package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto);

    MedicalRecordDto getMedicalRecord(Long recordID);

    List<MedicalRecordDto> getAllMedicalRecord();

    MedicalRecordDto updateMedicalRecord(Long RecordID, MedicalRecordDto medicalRecordDto);

    void deleteMedicalRecord(Long RecordID);
}
