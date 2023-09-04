package org.myproject.crm.service;

import org.modelmapper.ModelMapper;
import org.myproject.crm.dtos.ClientInputDTO;
import org.myproject.crm.model.Client;
import org.myproject.crm.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clienterepository;

    public ClientService(ClientRepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    public Iterable<Client> getClient(){
        return this.clienterepository.findAll();
    }

    public void addClient(ClientInputDTO client){
        ModelMapper mapper = new ModelMapper();
        Client clientToPersist = mapper.map(client, Client.class);
        this.clienterepository.save(clientToPersist);
    }

    public Optional<Client> getClientById(int idClient) {
        return this.clienterepository.findById(idClient);
    }
}
