package com.csm.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Doctor_Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorAppointmentId;
    private String patientName;
    private String patient_Phone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date Date_Of_appointment;
    private Character Patient_Status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId")
    private Doctor_Master doctorId;
}