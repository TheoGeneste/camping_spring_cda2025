package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Type;

@Repository
public class TypeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Type> findAll() {
		String sql = "SELECT id_type,label FROM types";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<Type> items = new ArrayList<>();
			while (resultSet.next()) {
				Type t = new Type();
				t.setId(resultSet.getInt("id_type"));
				t.setLabel(resultSet.getString("label"));
				items.add(t);
			}
			return items;
		});
	}

	public Type findById(Integer id) {
		String sql = "SELECT id_type,label FROM types WHERE id_type = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				Type t = new Type();
				t.setId(resultSet.getInt("id_type"));
				t.setLabel(resultSet.getString("label"));
				return t;
			}
			return null;
		}, id);
	}

	public int save(Type t) {
		String sql = "INSERT INTO types(label) VALUES (?)";
		return jdbcTemplate.update(sql, t.getLabel());
	}

	public int update(Type t) {
		String sql = "UPDATE types set label = ? WHERE id_type = ?";
		return jdbcTemplate.update(sql, t.getLabel(), t.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM types WHERE id_type = ?";
		return jdbcTemplate.update(sql, id);
	}
}
