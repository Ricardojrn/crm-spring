package org.myproject.crm.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientService {
    private List<String> clients;

    public ClientService() {
        this.clients = new ArrayList<>();
    }

    public List<String> getClients(){
        return this.clients;
    }

    public void setClients(String client){
        this.clients.add(client);
    }
}
