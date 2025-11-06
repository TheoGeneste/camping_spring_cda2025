package com.cda.camping.model;

import java.math.BigDecimal;
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
@Table(name = "echeances")
public class Echeance {
    
    @Id
    @Column(name="id_echeance")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="date_echeance")
    private Date dateEcheance;

    @Column(name="montant")
    private BigDecimal montant;

    @Column(name="payer")
    private Boolean payer;

    @Column(name = "id_facture")
    private Integer idFacture;
}


