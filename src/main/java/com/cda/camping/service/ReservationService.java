package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Reservation;
import com.cda.camping.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getAllReservations(){
		return reservationRepository.findAll();
	}

	public Reservation getReservation(Integer id){
		return reservationRepository.findById(id);
	}

	public void createReservation(Reservation r){
		reservationRepository.save(r);
	}

	public void updateReservation(Reservation r){
		reservationRepository.update(r);
	}

	public void deleteReservation(Integer id){
		reservationRepository.delete(id);
	}
}
