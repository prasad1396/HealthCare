package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repo.AppointmentRepository;
import com.example.demo.repo.DoctorRepository;
import com.example.demo.repo.PatientRepository;
import com.example.demo.service.IAppointmentService;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPatientService;

@Service
public class IAppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository repo;

	@Override
	public Long saveAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		System.out.println("savingPatientService::" + appointment);
		return repo.save(appointment).getId();
	}

	@Override
	public List<Appointment> getAllAppointments() {
//		System.out.println("getAllDatService" +getAllPatient());
		// TODO Auto-generated method stub
		System.out.println("GetAllService::::" + repo.findAll());
		return repo.findAll();
	}

	@Override
	public void removeAppointment(Long id) {
		// TODO Auto-generated method stub
		repo.delete(getOneAppointment(id));

	}

	@Override
	public Appointment getOneAppointment(Long id) {
		// TODO Auto-generated method stub
		System.out.println("editService" + repo.findById(id));
		return repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id + ",not exist"));
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		if (repo.existsById(appointment.getId()))
			repo.save(appointment);
		else
			throw new AppointmentNotFoundException(appointment.getId() + ",not exist");

	}

}