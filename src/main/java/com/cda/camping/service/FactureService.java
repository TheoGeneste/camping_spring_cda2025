package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Facture;
import com.cda.camping.repository.FactureRepository;

@Service
public class FactureService {
	
	@Autowired
	private FactureRepository factureRepository;

	public List<Facture> getAllFactures(){
		return factureRepository.findAll();
	}

	public Facture getFacture(Integer id){
		return factureRepository.findById(id);
	}

	public void createFacture(Facture facture){
		factureRepository.save(facture);
	}

	public void updateFacture(Facture facture){
		factureRepository.update(facture);
	}

	public void deleteFacture(Integer id){
		factureRepository.delete(id);
	}
}
