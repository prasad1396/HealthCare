package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment_tab")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id_col", length = 10, nullable = false, unique = true)
	private Long id;

	@Column(name = "appointment_doctor_col")
	private String doctor;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "appointment_date_col")
	private Date date;

	@Column(name = "appointment_slots_col")
	private int slots;

	@Column(name = "appointment_amount_col")
	private int amount;

	@Column(name = "appointment_details_col")
	private String details;

}