package com.csm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Doctor_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;
    private String doctorName;
    private String doctorPhone;
    private String doctorEmail;

}