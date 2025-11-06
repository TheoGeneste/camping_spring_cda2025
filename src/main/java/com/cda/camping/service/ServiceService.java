package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.repository.ServiceRepository;

@Service
public class ServiceService {
	
	@Autowired
	private ServiceRepository serviceRepository;

	public java.util.List<com.cda.camping.model.Service> getAllServices(){
		return serviceRepository.findAll();
	}

	public com.cda.camping.model.Service getService(Integer id){
		return serviceRepository.findById(id);
	}

	public void createService(com.cda.camping.model.Service s){
		serviceRepository.save(s);
	}

	public void updateService(com.cda.camping.model.Service s){
		serviceRepository.update(s);
	}

	public void deleteService(Integer id){
		serviceRepository.delete(id);
	}
}
