package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Reservation;

@Repository
public class ReservationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Reservation> findAll() {
		String sql = "SELECT id_resa,date_debut,date_fin,id_hebergement,id_client FROM reservations";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Reservation> items = new ArrayList<>();
			while (resultSet.next()) {
				Reservation r = new Reservation();
				r.setId(resultSet.getInt("id_resa"));
				r.setDateDebut(resultSet.getDate("date_debut"));
				r.setDateFin(resultSet.getDate("date_fin"));
				r.setIdHebergement(resultSet.getInt("id_hebergement"));
				r.setIdClient(resultSet.getInt("id_client"));
				items.add(r);
			}
			return items;
		});
	}

	public Reservation findById(Integer id) {
		String sql = "SELECT id_resa,date_debut,date_fin,id_hebergement,id_client FROM reservations WHERE id_resa = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Reservation r = new Reservation();
				r.setId(resultSet.getInt("id_resa"));
				r.setDateDebut(resultSet.getDate("date_debut"));
				r.setDateFin(resultSet.getDate("date_fin"));
				r.setIdHebergement(resultSet.getInt("id_hebergement"));
				r.setIdClient(resultSet.getInt("id_client"));
				return r;
			}
			return null;
		}, id);
	}

	public int save(Reservation r) {
		String sql = "INSERT INTO reservations(date_debut, date_fin, id_hebergement, id_client) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, r.getDateDebut(), r.getDateFin(), r.getIdHebergement(), r.getIdClient());
	}

	public int update(Reservation r) {
		String sql = "UPDATE reservations set date_debut = ?, date_fin= ?, id_hebergement = ?, id_client = ? WHERE id_resa = ?";
		return jdbcTemplate.update(sql, r.getDateDebut(), r.getDateFin(), r.getIdHebergement(), r.getIdClient(), r.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM reservations WHERE id_resa = ?";
		return jdbcTemplate.update(sql, id);
	}
}
