package com.cda.camping.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "participe")
@IdClass(ParticipeKey.class)
public class Participe {

    @Id
    @Column(name="id_client")
    private Integer idClient;

    @Id
    @Column(name="id_services")
    private Integer idServices;

    @Column(name="date_debut")
    private Timestamp dateDebut;

    @Column(name="date_fin")
    private Timestamp dateFin;
}


