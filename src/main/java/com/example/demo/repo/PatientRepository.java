package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}