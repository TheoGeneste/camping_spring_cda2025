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
@Table(name = "hebergements")
public class Hebergement {
    
    @Id
    @Column(name="id_hebergement")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="emplacement")
    private String emplacement;

    @Column(name="etat")
    private String etat;

    @Column(name = "id_type")
    private Integer idType;
}


