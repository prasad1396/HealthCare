package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecializationNotFoundException;
import com.example.demo.repo.DoctorRegistrationRepository;
import com.example.demo.repo.SpecializationRepository;
import com.example.demo.service.IDoctorRegistrationService;
import com.example.demo.service.ISpecializationService;
@Service
public class IDoctorRegistrationImpl implements IDoctorRegistrationService{
	@Autowired
	private DoctorRegistrationRepository doctorRegRepo;

	@Override
	public Long saveDoctorRegistration(DoctorRegistration doctorReg) {
		// TODO Auto-generated method stub
		return doctorRegRepo.save(doctorReg).getId();
	}

	@Override
	public List<DoctorRegistration> getAllDoctorsRgistration() {
		// TODO Auto-generated method stub
		return doctorRegRepo.findAll();
	}

	@Override
	public void removeDoctorRegistration(Long id) {
		// TODO Auto-generated method stub
		doctorRegRepo.delete(getOneDoctorRegistration(id));

	}

	@Override
	public DoctorRegistration getOneDoctorRegistration(Long id) {
		// TODO Auto-generated method stub
		Optional<DoctorRegistration> optional = doctorRegRepo.findById(id);
		System.out.println("serviceEdit:::"+optional );
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new SpecializationNotFoundException(id+" Not Found");
		}
	}

	@Override
	public void updateDoctorRegistration(DoctorRegistration doctorReg) {
		// TODO Auto-generated method stub
		doctorRegRepo.save(doctorReg);

	}

}
