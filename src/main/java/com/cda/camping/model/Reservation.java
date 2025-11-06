package com.cda.camping.model;

import java.sql.Date;

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
@Table(name = "reservations")
public class Reservation {
    
    @Id
    @Column(name="id_resa")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="date_debut")
    private Date dateDebut;

    @Column(name="date_fin")
    private Date dateFin;

    @Column(name = "id_hebergement")
    private Integer idHebergement;

    @Column(name = "id_client")
    private Integer idClient;
}


