package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    AppointmentDto getAppointment(Long appointmentID);

    List<AppointmentDto> getAllAppointmet();

    AppointmentDto updateAppointmet(Long appointmentID, AppointmentDto appointmentDto);

    void deleteAppointmet(Long appointmentID);
}
