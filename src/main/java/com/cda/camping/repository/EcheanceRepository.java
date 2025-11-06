package com.cda.camping.repository;

import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Echeance;

@Repository
public class EcheanceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Echeance> findAll() {
		String sql = "SELECT id_echeance,date_echeance,montant,payer,id_facture FROM echeances";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Echeance> items = new ArrayList<>();
			while (resultSet.next()) {
				Echeance e = new Echeance();
				e.setId(resultSet.getInt("id_echeance"));
				e.setDateEcheance(resultSet.getDate("date_echeance"));
				e.setMontant(resultSet.getBigDecimal("montant"));
				e.setPayer(resultSet.getBoolean("payer"));
				e.setIdFacture(resultSet.getInt("id_facture"));
				items.add(e);
			}
			return items;
		});
	}

	public Echeance findById(Integer id) {
		String sql = "SELECT id_echeance,date_echeance,montant,payer,id_facture FROM echeances WHERE id_echeance = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Echeance e = new Echeance();
				e.setId(resultSet.getInt("id_echeance"));
				e.setDateEcheance(resultSet.getDate("date_echeance"));
				e.setMontant(resultSet.getBigDecimal("montant"));
				e.setPayer(resultSet.getBoolean("payer"));
				e.setIdFacture(resultSet.getInt("id_facture"));
				return e;
			}
			return null;
		}, id);
	}

	public int save(Echeance e) {
		String sql = "INSERT INTO echeances(date_echeance, montant, payer, id_facture) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, e.getDateEcheance(), e.getMontant(), e.getPayer(), e.getIdFacture());
	}

	public int update(Echeance e) {
		String sql = "UPDATE echeances set date_echeance = ?, montant= ?, payer =?, id_facture = ? WHERE id_echeance = ?";
		return jdbcTemplate.update(sql, e.getDateEcheance(), e.getMontant(), e.getPayer(), e.getIdFacture(), e.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM echeances WHERE id_echeance = ?";
		return jdbcTemplate.update(sql, id);
	}
}
