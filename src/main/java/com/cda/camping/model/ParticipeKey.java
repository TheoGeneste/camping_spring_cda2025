package com.cda.camping.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ParticipeKey implements Serializable {
    private static final long serialVersionUID = 1L;
    public Integer idClient;
    public Integer idServices;
}


