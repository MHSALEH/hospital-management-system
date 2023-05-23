package com.example.hospitalmanagementsystem.Controller;
import com.example.hospitalmanagementsystem.dto.DoctorDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalmanagementsystem.service.DoctorService;


import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {


    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        return new ResponseEntity<>(doctorService.createDoctor(doctorDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable("id") Long doctorID) {
        return new ResponseEntity<>(doctorService.getDoctor(doctorID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long doctorID, @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorID, doctorDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") Long doctorID) {
        doctorService.deleteDoctor(doctorID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
