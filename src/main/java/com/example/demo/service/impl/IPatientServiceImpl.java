package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repo.DoctorRepository;
import com.example.demo.repo.PatientRepository;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPatientService;

@Service
public class IPatientServiceImpl implements IPatientService{
	@Autowired
	private PatientRepository repo;
   

	@Override
	public Long savePatient(Patient  patient) {
		// TODO Auto-generated method stub
		System.out.println("savingPatientService::" +patient);
		return repo.save(patient).getId();
	}

	@Override
	public List<Patient> getAllPatient() {
//		System.out.println("getAllDatService" +getAllPatient());
		// TODO Auto-generated method stub
		System.out.println("GetAllService::::" +repo.findAll());
		return repo.findAll();
	}

	@Override
	public void removePatient(Long id) {
		// TODO Auto-generated method stub
		repo.delete(getOnePatient(id));

	}

	@Override
	public Patient getOnePatient(Long id) {
		// TODO Auto-generated method stub
		System.out.println("editService" +repo.findById(id));
		return repo.findById(id).orElseThrow(() -> new PatientNotFoundException(id + ",not exist"));
	}

	@Override
	public void updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		if (repo.existsById(patient.getId()))
			repo.save(patient);
		else
			throw new DoctorNotFoundException(patient.getId() + ",not exist");

	}

}