package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		String sql = "SELECT id_user,login,password,roles FROM users";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			List<User> items = new ArrayList<>();
			while (resultSet.next()) {
				User u = new User();
				u.setId(resultSet.getInt("id_user"));
				u.setLogin(resultSet.getString("login"));
				u.setPassword(resultSet.getString("password"));
				u.setRoles(resultSet.getString("roles"));
				items.add(u);
			}
			return items;
		});
	}

	public User findById(Integer id) {
		String sql = "SELECT id_user,login,password,roles FROM users WHERE id_user = ?";
		return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
			if (resultSet.next()) {
				User u = new User();
				u.setId(resultSet.getInt("id_user"));
				u.setLogin(resultSet.getString("login"));
				u.setPassword(resultSet.getString("password"));
				u.setRoles(resultSet.getString("roles"));
				return u;
			}
			return null;
		}, id);
	}

	public int save(User u) {
		String sql = "INSERT INTO users(login, password, roles) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, u.getLogin(), u.getPassword(), u.getRoles());
	}

	public int update(User u) {
		String sql = "UPDATE users set login = ?, password= ?, roles = ? WHERE id_user = ?";
		return jdbcTemplate.update(sql, u.getLogin(), u.getPassword(), u.getRoles(), u.getId());
	}

	public int delete(Integer id){
		String sql = "DELETE FROM users WHERE id_user = ?";
		return jdbcTemplate.update(sql, id);
	}
}
