package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;
import com.example.hospitalmanagementsystem.entity.MedicalRecord;

import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {


    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository= medicalRecordRepository;
    }

    @Override
    public MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = convertToEntity(medicalRecordDto);
        MedicalRecord savedMidicalRecoed = medicalRecordRepository.save(medicalRecord);
        return convertToDto(savedMidicalRecoed);
    }
    @Override
    public MedicalRecordDto getMedicalRecord(Long recordID) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordID).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", recordID));
        return convertToDto(medicalRecord);
    }

    @Override
    public List<MedicalRecordDto> getAllMedicalRecord() {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
        return medicalRecords.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDto updateMedicalRecord(Long recordID, MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordID).orElseThrow(() -> new ResourceNotFoundException("MedicalRecoed", "id", recordID));


        medicalRecord.setMedicineName(medicalRecordDto.getMedicineName());
        medicalRecord.setDate(medicalRecordDto.getDate());



        MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return convertToDto(updatedMedicalRecord);
    }

    @Override
    public void deleteMedicalRecord(Long recordID) {
        if (!medicalRecordRepository.existsById(recordID)) {
            throw new ResourceNotFoundException("MedicalRecord", "id", recordID);
        }
        medicalRecordRepository.deleteById(recordID);
    }

    private MedicalRecordDto convertToDto(MedicalRecord medicalRecord) {
        MedicalRecordDto medicalRecordDto = new MedicalRecordDto();

        medicalRecordDto.setRecordID(medicalRecord.getRecordID());
        medicalRecordDto.setMedicineName(medicalRecord.getMedicineName());
        medicalRecordDto.setDate(medicalRecord.getDate());

        return medicalRecordDto;
    }

    private MedicalRecord convertToEntity(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setRecordID(medicalRecordDto.getRecordID());
        medicalRecord.setMedicineName(medicalRecordDto.getMedicineName());
        medicalRecord.setDate(medicalRecordDto.getDate());

        return medicalRecord;
    }

}
