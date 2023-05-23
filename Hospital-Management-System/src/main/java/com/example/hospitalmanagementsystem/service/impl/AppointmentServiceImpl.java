package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.AppointmentDto;
import com.example.hospitalmanagementsystem.entity.Appointment;
import com.example.hospitalmanagementsystem.repository.AppointmentRepository;
import com.example.hospitalmanagementsystem.service.AppointmentService;

import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AppointmentServiceImpl implements AppointmentService {


    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository= appointmentRepository;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = convertToEntity(appointmentDto);
        System.out.println(appointment.toString());
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDto(savedAppointment);
    }

    @Override
    public AppointmentDto getAppointment(Long appointmentID) {
        Appointment appointment = appointmentRepository.findById(appointmentID).orElseThrow(() -> new ResourceNotFoundException("Appointmet", "id", appointmentID));
        return convertToDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointmet() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto updateAppointmet(Long appointmentID, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(appointmentID).orElseThrow(() -> new ResourceNotFoundException("Appointmet", "id", appointmentID));


        appointment.setDate(appointmentDto.getDate());


        Appointment updatedAppointmet = appointmentRepository.save(appointment);
        return convertToDto(updatedAppointmet);
    }

    @Override
    public void deleteAppointmet(Long appointmentID) {
        if (!appointmentRepository.existsById(appointmentID)) {
            throw new ResourceNotFoundException("Appointmet", "id", appointmentID);
        }
        appointmentRepository.deleteById(appointmentID);
    }

    private AppointmentDto convertToDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setAppointmentID(appointment.getAppointmentID());
        appointmentDto.setDate(appointment.getDate());

        return appointmentDto;
    }

    private Appointment convertToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setAppointmentID(appointmentDto.getAppointmentID());
        appointment.setDate(appointmentDto.getDate());

        return appointment;
    }
}
