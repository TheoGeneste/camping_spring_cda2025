package com.cda.camping.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Service {
    
    @Id
    @Column(name="id_services")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="label")
    private String label;

    @Column(name="prix")
    private BigDecimal prix;
}


