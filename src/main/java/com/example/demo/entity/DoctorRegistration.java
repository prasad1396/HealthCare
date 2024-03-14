package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doct_reg_tab")
public class DoctorRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "register_id_col")
	private long id;

	@Column(name = "reg_first_name_col", length = 10, nullable = false, unique = true)
	private String firstName;

	@Column(name = "reg_last_name_col", length = 60, nullable = false, unique = true)
	private String lastName;

	@Column(name = "reg_email_col")
	private String email;
	

	@Column(name = "reg_specilization_col")
	private String specilization;
	

	@Column(name = "reg_address_col")
	private String address;

	@Column(name = "reg_mobile_col")
	private long mobileNo;
	

	@Column(name = "reg_gender_col")
	private String gender;
	
	
	@Column(name = "reg_note_col")
	private String note;
}
