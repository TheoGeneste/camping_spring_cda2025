package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Service;

@Repository
public class ServiceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Service> findAll() {
		String sql = "SELECT id_services,label,prix FROM services";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Service> items = new ArrayList<>();
			while (resultSet.next()) {
				Service s = new Service();
				s.setId(resultSet.getInt("id_services"));
				s.setLabel(resultSet.getString("label"));
				s.setPrix(resultSet.getBigDecimal("prix"));
				items.add(s);
			}
			return items;
		});
	}

	public Service findById(Integer id) {
		String sql = "SELECT id_services,label,prix FROM services WHERE id_services = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Service s = new Service();
				s.setId(resultSet.getInt("id_services"));
				s.setLabel(resultSet.getString("label"));
				s.setPrix(resultSet.getBigDecimal("prix"));
				return s;
			}
			return null;
		}, id);
	}

	public int save(Service s) {
		String sql = "INSERT INTO services(label, prix) VALUES (?,?)";
		return jdbcTemplate.update(sql, s.getLabel(), s.getPrix());
	}

	public int update(Service s) {
		String sql = "UPDATE services set label = ?, prix= ? WHERE id_services = ?";
		return jdbcTemplate.update(sql, s.getLabel(), s.getPrix(), s.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM services WHERE id_services = ?";
		return jdbcTemplate.update(sql, id);
	}
}
