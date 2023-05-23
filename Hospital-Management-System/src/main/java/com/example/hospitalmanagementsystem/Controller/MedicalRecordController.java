package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;


import java.util.List;

@RestController
@RequestMapping("/MedicalRecord")
public class MedicalRecordController {

    private  MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto){
        return new ResponseEntity<>(medicalRecordService.createMedicalRecord(medicalRecordDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> getMedicalRecord(@PathVariable("id") Long recordID) {
        return new ResponseEntity<>(medicalRecordService.getMedicalRecord(recordID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordDto>> getAllMedicalRecord() {
        return new ResponseEntity<>(medicalRecordService.getAllMedicalRecord(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> updateMedicalRecord(@PathVariable("id") Long recordID, @RequestBody MedicalRecordDto medicalRecordDto) {
        return new ResponseEntity<>(medicalRecordService.updateMedicalRecord(recordID, medicalRecordDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable("id") Long recordID) {
        medicalRecordService.deleteMedicalRecord(recordID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
