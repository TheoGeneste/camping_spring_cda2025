package com.cda.camping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.camping.model.Participe;
import com.cda.camping.service.ParticipeService;

@Controller
@RestController
@RequestMapping("/api/participe")
public class ParticipeController {

	@Autowired
	private ParticipeService participeService;

	@GetMapping
	public ResponseEntity<List<Participe>> getAll(){
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			return new ResponseEntity<>(participeService.getAllParticipations(), headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{idClient}/{idServices}")
	public ResponseEntity<Participe> getById(@PathVariable("idClient") Integer idClient, @PathVariable("idServices") Integer idServices) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			return new ResponseEntity<>(participeService.getParticipation(idClient, idServices), headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Participe item) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			participeService.createParticipation(item);
			return new ResponseEntity<>("{message : 'Participation ajoutée'}", headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Participe item) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			participeService.updateParticipation(item);
			return new ResponseEntity<>("{message : 'Participation modifiée'}", headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{idClient}/{idServices}")
	public ResponseEntity<String> delete(@PathVariable("idClient") Integer idClient, @PathVariable("idServices") Integer idServices) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			participeService.deleteParticipation(idClient, idServices);
			return new ResponseEntity<>("{message : 'Participation supprimée'}", headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
