package com.cda.camping.model;

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
@Table(name = "types")
public class Type {
    
    @Id
    @Column(name="id_type")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="label")
    private String label;
}


