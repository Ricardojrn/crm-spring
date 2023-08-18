package org.myproject.crm.service;

import org.myproject.crm.model.Client;
import org.myproject.crm.repository.ClientRepository;
import org.springframework.stereotype.Service;
@Service
public class ClientService {
    private final ClientRepository clienterepository;

    public ClientService(ClientRepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    public Iterable<Client> getClient(){
        return this.clienterepository.findAll();
    }

    public void addClient(Client client){
        this.clienterepository.save(client);
    }
}
