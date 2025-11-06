package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Facture;

@Repository
public class FactureRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Facture> findAll() {
		String sql = "SELECT id_facture,date_facture,prix_ttc,prix_ht,facture,id_resa FROM factures";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Facture> items = new ArrayList<>();
			while (resultSet.next()) {
				Facture f = new Facture();
				f.setId(resultSet.getInt("id_facture"));
				f.setDateFacture(resultSet.getDate("date_facture"));
				f.setPrixTtc(resultSet.getBigDecimal("prix_ttc"));
				f.setPrixHt(resultSet.getBigDecimal("prix_ht"));
				f.setFacture(resultSet.getBoolean("facture"));
				f.setIdResa(resultSet.getInt("id_resa"));
				items.add(f);
			}
			return items;
		});
	}

	public Facture findById(Integer id) {
		String sql = "SELECT id_facture,date_facture,prix_ttc,prix_ht,facture,id_resa FROM factures WHERE id_facture = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Facture f = new Facture();
				f.setId(resultSet.getInt("id_facture"));
				f.setDateFacture(resultSet.getDate("date_facture"));
				f.setPrixTtc(resultSet.getBigDecimal("prix_ttc"));
				f.setPrixHt(resultSet.getBigDecimal("prix_ht"));
				f.setFacture(resultSet.getBoolean("facture"));
				f.setIdResa(resultSet.getInt("id_resa"));
				return f;
			}
			return null;
		}, id);
	}

	public int save(Facture f) {
		String sql = "INSERT INTO factures(date_facture, prix_ttc, prix_ht, facture, id_resa) VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdResa());
	}

	public int update(Facture f) {
		String sql = "UPDATE factures set date_facture = ?, prix_ttc= ?, prix_ht =?, facture = ?, id_resa = ? WHERE id_facture = ?";
		return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdResa(), f.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM factures WHERE id_facture = ?";
		return jdbcTemplate.update(sql, id);
	}
}
