package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Hebergement;

@Repository
public class HebergementRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Hebergement> findAll() {
		String sql = "SELECT id_hebergement,emplacement,etat,id_type FROM hebergements";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Hebergement> items = new ArrayList<>();
			while (resultSet.next()) {
				Hebergement h = new Hebergement();
				h.setId(resultSet.getInt("id_hebergement"));
				h.setEmplacement(resultSet.getString("emplacement"));
				h.setEtat(resultSet.getString("etat"));
				h.setIdType(resultSet.getInt("id_type"));
				items.add(h);
			}
			return items;
		});
	}

	public Hebergement findById(Integer id) {
		String sql = "SELECT id_hebergement,emplacement,etat,id_type FROM hebergements WHERE id_hebergement = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Hebergement h = new Hebergement();
				h.setId(resultSet.getInt("id_hebergement"));
				h.setEmplacement(resultSet.getString("emplacement"));
				h.setEtat(resultSet.getString("etat"));
				h.setIdType(resultSet.getInt("id_type"));
				return h;
			}
			return null;
		}, id);
	}

	public int save(Hebergement h) {
		String sql = "INSERT INTO hebergements(emplacement, etat, id_type) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, h.getEmplacement(), h.getEtat(), h.getIdType());
	}

	public int update(Hebergement h) {
		String sql = "UPDATE hebergements set emplacement = ?, etat= ?, id_type = ? WHERE id_hebergement = ?";
		return jdbcTemplate.update(sql, h.getEmplacement(), h.getEtat(), h.getIdType(), h.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM hebergements WHERE id_hebergement = ?";
		return jdbcTemplate.update(sql, id);
	}
}
