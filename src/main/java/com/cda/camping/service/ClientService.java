package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Client;
import com.cda.camping.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(Integer id){
        return clientRepository.findById(id);
    }

    public void createClient(Client client){
        clientRepository.save(client);
    }

    public void updateClient(Client client){
        clientRepository.update(client);
    }

    public void deleteClient(Integer id){
        clientRepository.delete(id);
    }
}
