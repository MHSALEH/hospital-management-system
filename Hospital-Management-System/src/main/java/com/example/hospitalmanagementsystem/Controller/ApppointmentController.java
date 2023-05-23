package com.example.hospitalmanagementsystem.Controller;
import com.example.hospitalmanagementsystem.dto.AppointmentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalmanagementsystem.service.AppointmentService;


import java.util.List;

@RestController
@RequestMapping("/appointmets")
public class ApppointmentController {


    private AppointmentService appointmentService;

    public ApppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        System.out.println(appointmentDto.toString());
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable("id") Long appointmentID) {
        return new ResponseEntity<>(appointmentService.getAppointment(appointmentID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment() {
        System.out.println("appointmentDto.toString()");
        return new ResponseEntity<>(appointmentService.getAllAppointmet(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable("id") Long appointmentID, @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.updateAppointmet(appointmentID, appointmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") Long appointmentID) {
        appointmentService.deleteAppointmet(appointmentID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
