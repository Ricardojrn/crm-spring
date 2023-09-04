package org.myproject.crm.rest;

import jakarta.validation.Valid;
import org.myproject.crm.dtos.ClientInputDTO;
import org.myproject.crm.model.Client;
import org.myproject.crm.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;
    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("{id}")
    public ResponseEntity getClientById(@PathVariable("id") int idClient){
        Optional<Client> client = clientService.getClientById(idClient);
        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity <Iterable<Client>> getClient(){
        return ResponseEntity.ok(clientService.getClient());
    }
    @PostMapping
    public ResponseEntity addClient(@Valid @RequestBody ClientInputDTO client){
        this.clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
