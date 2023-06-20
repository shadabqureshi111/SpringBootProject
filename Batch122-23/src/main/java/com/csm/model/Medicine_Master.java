package com.csm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Medicine_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicine_id;
    private String medicine_Name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diseaseId")
    private Disease_Master diseaseId;

    // getters and setters
}