package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Participe;
import com.cda.camping.repository.ParticipeRepository;

@Service
public class ParticipeService {
	
	@Autowired
	private ParticipeRepository participeRepository;

	public List<Participe> getAllParticipations(){
		return participeRepository.findAll();
	}

	public Participe getParticipation(Integer idClient, Integer idServices){
		return participeRepository.findById(idClient, idServices);
	}

	public void createParticipation(Participe p){
		participeRepository.save(p);
	}

	public void updateParticipation(Participe p){
		participeRepository.update(p);
	}

	public void deleteParticipation(Integer idClient, Integer idServices){
		participeRepository.delete(idClient, idServices);
	}
}
