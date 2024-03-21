package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.service.IAppointmentService;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPatientService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private IAppointmentService service;

	// 1. show register page
	@GetMapping("/register")
	public String showRegister(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "AppointmentRegister";

	}

	// 2.save on submit
	@PostMapping("/save")
	public String save(@ModelAttribute Appointment appointment, RedirectAttributes attributes) {
		System.out.println("savingAppointmentCtrl::" +appointment);
		Long id = service.saveAppointment(appointment);
		System.out.println("savingAppointmentId::" +id);
		attributes.addAttribute("message", "appointment(" + id + ") is created");
		return "redirect:register";

	}

	// 3.display data
	@GetMapping("/all")
	public String display(Model model, @RequestParam(value = "message", required = false) String message) {
		System.out.println("gettingDataCtrl11::" +service.getAllAppointments());
		List<Appointment> list = service.getAllAppointments();
		
//		System.out.println("gettingDataCtrl::" +list);
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "AppointmentData";

	}

	// 4.delete by id
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
		String message = null;
		try {
			service.removeAppointment(id);
			message = "Appointment removed";

		} catch (PatientNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			message = e.getMessage();
		}
		attributes.addAttribute("message", message);
		return "redirect:all";

	}

	// 5. show edit
	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, RedirectAttributes attributes, Model model) {

//		return "PatientEdit";

		String page = null;
		try {
			Appointment	appointment= service.getOneAppointment(id);
			System.out.println("editCtrl::"+appointment );
			model.addAttribute("appointment", appointment);
			page = "AppointmentEdit";

		} catch ( AppointmentNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			return "redirect:all";
		}
		return page;

	}

	// 6.do update
	@PostMapping("/update")
	public String doUpdate(@ModelAttribute Appointment  appointment  , RedirectAttributes attributes) {
		System.out.println("appointmentUpdateCtrl" +appointment.getAmount());
		service.updateAppointment(appointment );
//		System.out.println("patientUpdateCtrl" +service.updatePatient(patient));
		attributes.addAttribute("message", "Patient (" + appointment .getId() + ") is updated");
		return "redirect:all";

	}

	
}