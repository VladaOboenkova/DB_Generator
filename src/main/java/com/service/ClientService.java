package com.service;

import com.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.ClientRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public int count() {
        return (int) clientRepository.count();
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> findAllSuitable(LocalDateTime date){
        List<Client> clients = findAll();
        List<Client> suitableClients = new ArrayList<>();
        for (Client c : clients){
            if (c.getId_person_info().getDob().plusYears(18).toEpochDay() <=
                    date.toLocalDate().minusDays(1).toEpochDay()){
                suitableClients.add(c);
            }
        }
        return  suitableClients;
    }

}