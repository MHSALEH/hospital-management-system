package com.example.hospitalmanagementsystem.Controller;

import com.example.hospitalmanagementsystem.dto.PatientDto;
import com.example.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalmanagementsystem.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable("id") Long patientID) {
        return new ResponseEntity<>(patientService.getPatient(patientID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientID, @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.updatePatient(patientID, patientDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long patientID) {
        patientService.deletePatient(patientID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
