package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.entity.Doctor;
import com.example.hospitalmanagementsystem.repository.DoctorRepository;
import com.example.hospitalmanagementsystem.service.DoctorService;

import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DoctorServiceImpl implements DoctorService {


    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository= doctorRepository;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = convertToEntity(doctorDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDto(savedDoctor);
    }

    @Override
    public DoctorDto getDoctor(Long doctorID) {
        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorID));
        return convertToDto(doctor);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDto updateDoctor(Long doctorID, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorID));


        doctor.setAge(doctorDto.getAge());
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setSalary(doctorDto.getSalary());
        doctor.setSpeciaization(doctorDto.getSpeciaization());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return convertToDto(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long doctorID) {
        if (!doctorRepository.existsById(doctorID)) {
            throw new ResourceNotFoundException("Doctor", "id", doctorID);
        }
        doctorRepository.deleteById(doctorID);
    }

    private DoctorDto convertToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setDoctorID(doctor.getDoctorID());
        doctorDto.setAge(doctor.getAge());
        doctorDto.setSalary(doctor.getSalary());
        doctorDto.setName(doctor.getName());
        doctorDto.setPhone(doctor.getPhone());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setSpeciaization(doctor.getSpeciaization());

        return doctorDto;
    }

    private Doctor convertToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();

        doctor.setDoctorID(doctorDto.getDoctorID());
        doctor.setAge(doctorDto.getAge());
        doctor.setSalary(doctorDto.getSalary());
        doctor.setName(doctorDto.getName());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpeciaization(doctorDto.getSpeciaization());

        return doctor;
    }
}
