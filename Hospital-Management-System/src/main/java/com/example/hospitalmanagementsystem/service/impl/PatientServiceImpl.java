package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.PatientDto;
import com.example.hospitalmanagementsystem.service.PatientService;
import com.example.hospitalmanagementsystem.entity.Patient;
import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospitalmanagementsystem.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {


    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = convertToEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return convertToDto(savedPatient);
    }

    @Override
    public PatientDto getPatient(Long patientID) {
        Patient patient = patientRepository.findById(patientID).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientID));
        return convertToDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long patientID, PatientDto patientDto) {
        System.out.println(patientDto.toString());
        Patient patient = patientRepository.findById(patientID).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientID));
        System.out.println(patient.toString());
//        patient.setPatientID(patientDto.getPatientID());
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setAge(patientDto.getAge());
        patient.setPhone(patientDto.getPhone());
        System.out.println(patient.toString());
        System.out.println("replaaaaaaaaaaaaaaaaaaaaaaaace");



        Patient updatedPatient = patientRepository.save(patient);
        System.out.println(updatedPatient.toString());
        return convertToDto(updatedPatient);
    }

    @Override
    public void deletePatient(Long patientID) {
        if (!patientRepository.existsById(patientID)) {
            throw new ResourceNotFoundException("Patient", "id", patientID);
        }
        patientRepository.deleteById(patientID);
    }

    private PatientDto convertToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();

        patientDto.setPatientID(patient.getPatientID());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAge(patient.getAge());
        patientDto.setPhone(patient.getPhone());



        return patientDto;
    }

    private Patient convertToEntity(PatientDto patientDto) {
        Patient patient = new Patient();

        patient.setPatientID(patientDto.getPatientID());
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setAge(patientDto.getAge());
        patient.setPhone(patientDto.getPhone());



        return patient;
    }
}

