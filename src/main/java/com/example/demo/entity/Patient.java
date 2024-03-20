package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "patient_tab")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pat_id_col")
	private Long id;

	@Column(name = "pat_firstName_col")
	private String firstName;

	@Column(name = "pat_lastName_col")
	private String lastName;

	@Column(name = "pat_gender_col")
	private String gender;
	

	@Column(name = "pat_mobile_col")
	private String mobile;

	@Column(name = "pat_dob_col")
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateOfBirth;

	@Column(name = "pat_marStatus_col")
	private String marialStatus;

	@Column(name = "pat_presenttAddr")
	private String presentAddr;

	@Column(name = "pat_communicationAddr")
	private String communicationAddr;

//	@Column(name = "pat_medchstry_col")
	@ElementCollection
	@CollectionTable(name = "pat_medi_hist_tab", joinColumns = @JoinColumn(name = "pat_medchstry_col"))
	private Set<String> mediHistroy;

	@Column(name = "pat_othe_col")
	private String ifOther;

	@Column(name = "pat_note_col")
	private String note;

}