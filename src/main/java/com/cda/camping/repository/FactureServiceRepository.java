package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.FactureService;

@Repository
public class FactureServiceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<FactureService> findAll() {
		String sql = "SELECT id_facture,date_facture,prix_ttc,prix_ht,facture,id_services FROM factures_services";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<FactureService> items = new ArrayList<>();
			while (resultSet.next()) {
				FactureService f = new FactureService();
				f.setId(resultSet.getInt("id_facture"));
				f.setDateFacture(resultSet.getDate("date_facture"));
				f.setPrixTtc(resultSet.getBigDecimal("prix_ttc"));
				f.setPrixHt(resultSet.getBigDecimal("prix_ht"));
				f.setFacture(resultSet.getBoolean("facture"));
				f.setIdServices(resultSet.getInt("id_services"));
				items.add(f);
			}
			return items;
		});
	}

	public FactureService findById(Integer id) {
		String sql = "SELECT id_facture,date_facture,prix_ttc,prix_ht,facture,id_services FROM factures_services WHERE id_facture = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				FactureService f = new FactureService();
				f.setId(resultSet.getInt("id_facture"));
				f.setDateFacture(resultSet.getDate("date_facture"));
				f.setPrixTtc(resultSet.getBigDecimal("prix_ttc"));
				f.setPrixHt(resultSet.getBigDecimal("prix_ht"));
				f.setFacture(resultSet.getBoolean("facture"));
				f.setIdServices(resultSet.getInt("id_services"));
				return f;
			}
			return null;
		}, id);
	}

	public int save(FactureService f) {
		String sql = "INSERT INTO factures_services(date_facture, prix_ttc, prix_ht, facture, id_services) VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdServices());
	}

	public int update(FactureService f) {
		String sql = "UPDATE factures_services set date_facture = ?, prix_ttc= ?, prix_ht =?, facture = ?, id_services = ? WHERE id_facture = ?";
		return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdServices(), f.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM factures_services WHERE id_facture = ?";
		return jdbcTemplate.update(sql, id);
	}
}
