package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Participe;

@Repository
public class ParticipeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Participe> findAll() {
		String sql = "SELECT id_client,id_services,date_debut,date_fin FROM participe";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Participe> items = new ArrayList<>();
			while (resultSet.next()) {
				Participe p = new Participe();
				p.setIdClient(resultSet.getInt("id_client"));
				p.setIdServices(resultSet.getInt("id_services"));
				p.setDateDebut(resultSet.getTimestamp("date_debut"));
				p.setDateFin(resultSet.getTimestamp("date_fin"));
				items.add(p);
			}
			return items;
		});
	}

	public Participe findById(Integer idClient, Integer idServices) {
		String sql = "SELECT id_client,id_services,date_debut,date_fin FROM participe WHERE id_client = ? AND id_services = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Participe p = new Participe();
				p.setIdClient(resultSet.getInt("id_client"));
				p.setIdServices(resultSet.getInt("id_services"));
				p.setDateDebut(resultSet.getTimestamp("date_debut"));
				p.setDateFin(resultSet.getTimestamp("date_fin"));
				return p;
			}
			return null;
		}, idClient, idServices);
	}

	public int save(Participe p) {
		String sql = "INSERT INTO participe(id_client, id_services, date_debut, date_fin) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, p.getIdClient(), p.getIdServices(), p.getDateDebut(), p.getDateFin());
	}

	public int update(Participe p) {
		String sql = "UPDATE participe set date_debut = ?, date_fin= ? WHERE id_client = ? AND id_services = ?";
		return jdbcTemplate.update(sql, p.getDateDebut(), p.getDateFin(), p.getIdClient(), p.getIdServices());
	}

	public int delete(Integer idClient, Integer idServices){
		String sql = "DELETE FROM participe WHERE id_client = ? AND id_services = ?";
		return jdbcTemplate.update(sql, idClient, idServices);
	}
}
