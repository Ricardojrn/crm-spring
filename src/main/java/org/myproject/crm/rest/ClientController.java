package org.myproject.crm.rest;

import org.myproject.crm.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;
    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping
    public ResponseEntity <List<String>> getClients(){
        return ResponseEntity.ok(clientService.getClients());
    }
    @PostMapping
    public ResponseEntity addClientService(@RequestBody String client){
        this.clientService.setClients(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
