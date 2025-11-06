package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Type;
import com.cda.camping.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	private TypeRepository typeRepository;

	public List<Type> getAllTypes(){
		return typeRepository.findAll();
	}

	public Type getType(Integer id){
		return typeRepository.findById(id);
	}

	public void createType(Type t){
		typeRepository.save(t);
	}

	public void updateType(Type t){
		typeRepository.update(t);
	}

	public void deleteType(Integer id){
		typeRepository.delete(id);
	}
}
