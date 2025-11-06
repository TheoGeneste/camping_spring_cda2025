package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Echeance;
import com.cda.camping.repository.EcheanceRepository;

@Service
public class EcheanceService {
	
	@Autowired
	private EcheanceRepository echeanceRepository;

	public List<Echeance> getAllEcheances(){
		return echeanceRepository.findAll();
	}

	public Echeance getEcheance(Integer id){
		return echeanceRepository.findById(id);
	}

	public void createEcheance(Echeance echeance){
		echeanceRepository.save(echeance);
	}

	public void updateEcheance(Echeance echeance){
		echeanceRepository.update(echeance);
	}

	public void deleteEcheance(Integer id){
		echeanceRepository.delete(id);
	}
}
