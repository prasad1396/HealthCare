package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.Specialization;

public interface IDoctorRegistrationService {
	public Long saveDoctorRegistration(DoctorRegistration doctorReg);
	public List<DoctorRegistration> getAllDoctorsRgistration();
	public void removeDoctorRegistration(Long id);
	public DoctorRegistration getOneDoctorRegistration(Long id);
	public void updateDoctorRegistration(DoctorRegistration doctorReg);
//	public boolean isDoctorRegCodeExist(String specCode);
//	public boolean isisDoctorRegNameExist(String specName);

}
