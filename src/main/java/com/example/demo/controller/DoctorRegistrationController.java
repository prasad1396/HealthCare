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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecializationNotFoundException;
import com.example.demo.service.IDoctorRegistrationService;
import com.example.demo.service.ISpecializationService;

@Controller
@RequestMapping("/doctReg")
public class DoctorRegistrationController {
	@Autowired
	private IDoctorRegistrationService regService;

	@GetMapping("/register")
	public String displayRegister() {
		return "DoctorRegistration";
	}

	@PostMapping("/save")
	public String saveForm(@ModelAttribute DoctorRegistration doctorReg, Model model) {

		Long id = regService.saveDoctorRegistration(doctorReg);
		String msg = "Record (" + id + ") Created";
		model.addAttribute("message", msg);

		return "DoctorRegistration";
	}

	@GetMapping("/all")
	public String viewAll(Model model, @RequestParam(value = "message", required = false) String message) {
		List<DoctorRegistration> list = regService.getAllDoctorsRgistration();
//		System.out.println("list ::"+list );
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "DoctorRegData";

	}

	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			regService.removeDoctorRegistration(id);
			attributes.addAttribute("message", "Record (" + id + ") Deleted");

		} catch (SpecializationNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}

		return "redirect:all";
	}

	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model,RedirectAttributes attributes) {
		String page = null;
		try {
			DoctorRegistration  doctReg= regService.getOneDoctorRegistration(id);
			System.out.println("doctorReg::"+doctReg );
			model.addAttribute("doctorReg", doctReg);
			page="DoctorRegistrationEdit";
		} catch (SpecializationNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			attributes.addAttribute("message",e.getMessage());
			page="redirect:all";
			
		}

		return page;
	}

	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute DoctorRegistration doctorReg, RedirectAttributes attributes) {
		regService.updateDoctorRegistration(doctorReg);
		attributes.addAttribute("message", "Record (" + doctorReg.getId() + ") is updated");
		return "redirect:all";

	}

//	@GetMapping("/checkCode")
//	public @ResponseBody String validateSpecCode(@RequestParam String code) {
//		String message = "";
//		if (service.isSpecCodeExist(code)) {
//			message = code + ", already exist";
//		}
//		return message; // this is not viewName this is a message
//	}
//
//	@GetMapping("/checkName")
//	public @ResponseBody String validateSpecName(@RequestParam String name) {
//		String message = "";
//		if (service.isSpecNameExist(name)) {
//			message = name + ", already exist";
//		}
//		return message; // this is not viewName this is a message
//	}

}
