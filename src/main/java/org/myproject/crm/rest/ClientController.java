package org.myproject.crm.rest;

import org.myproject.crm.model.Client;
import org.myproject.crm.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;
    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping
    public ResponseEntity <Iterable<Client>> getClient(){
        return ResponseEntity.ok(clientService.getClient());
    }
    @PostMapping
    public ResponseEntity addClient(@RequestBody Client client){
        this.clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
