package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.Client;

@Repository
public class ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> findAll() {
        String sql = "SELECT id_client,nom,prenom,adresse,telephone,id_user FROM clients";
        return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client c = new Client();
                c.setId(resultSet.getInt("id_client"));
                c.setNom(resultSet.getString("nom"));
                c.setPrenom(resultSet.getString("prenom"));
                c.setAdresse(resultSet.getString("adresse"));
                c.setTelephone(resultSet.getString("telephone"));
                c.setIdUser(resultSet.getInt("id_user"));
                clients.add(c);
            }
            return clients;
        });
    }

    public Client findById(Integer id) {
        String sql = "SELECT id_client,nom,prenom,adresse,telephone,id_user FROM clients WHERE id_client = ?";
        return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            if (resultSet.next()) {
                Client c = new Client();
                c.setId(resultSet.getInt("id_client"));
                c.setNom(resultSet.getString("nom"));
                c.setPrenom(resultSet.getString("prenom"));
                c.setAdresse(resultSet.getString("adresse"));
                c.setTelephone(resultSet.getString("telephone"));
                c.setIdUser(resultSet.getInt("id_user"));
                return c;
            }
            return null;
        }, id);
    }

    public int save(Client c) {
        String sql = "INSERT INTO clients(nom, prenom, adresse,telephone,id_user) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getIdUser());
    }

    public int update(Client c) {
        String sql = "UPDATE clients set nom = ?, prenom= ?, adresse =?,telephone =?,id_user = ? WHERE id_client = ?";
        return jdbcTemplate.update(sql, c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getIdUser(), c.getId());
    }

    public int delete(Integer id){
        String sql = "DELETE FROM clients WHERE id_client = ?";
        return jdbcTemplate.update(sql, id);
    }
}
