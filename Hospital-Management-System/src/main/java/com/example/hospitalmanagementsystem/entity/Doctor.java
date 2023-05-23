package com.example.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="doctor")
public class Doctor implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorID ;

    private String name;

    private int age;

    private String phone;

    private double salary;

    private String email;

    private String speciaization;

}
