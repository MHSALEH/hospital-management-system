package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto getDoctor(Long doctorID);

    List<DoctorDto> getAllDoctors();

    DoctorDto updateDoctor(Long doctorID, DoctorDto doctorDto);

    void deleteDoctor(Long doctorID);
}
