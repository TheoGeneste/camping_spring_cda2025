package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.FactureService;
import com.cda.camping.repository.FactureServiceRepository;

@Service
public class FactureServiceService {
	
	@Autowired
	private FactureServiceRepository factureServiceRepository;

	public List<FactureService> getAllFactureServices(){
		return factureServiceRepository.findAll();
	}

	public FactureService getFactureService(Integer id){
		return factureServiceRepository.findById(id);
	}

	public void createFactureService(FactureService fs){
		factureServiceRepository.save(fs);
	}

	public void updateFactureService(FactureService fs){
		factureServiceRepository.update(fs);
	}

	public void deleteFactureService(Integer id){
		factureServiceRepository.delete(id);
	}
}
