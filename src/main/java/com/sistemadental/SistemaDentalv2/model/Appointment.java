package com.sistemadental.SistemaDentalv2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="appointments")
public class Appointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="date_time")
    private Date dateTime;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
    private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="dentist_id")
    private Dentist dentist;
    
    
  //getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Dentist getDentist() {
		return dentist;
	}
	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", dateTime=" + dateTime + ", patient=" + patient + ", dentist=" + dentist
				+ "]";
	}
	
	
	
	
    
    
    
    
	

}
