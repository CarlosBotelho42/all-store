package br.com.allstore.controllers;

import br.com.allstore.dto.ClientDTO;
import br.com.allstore.entities.Client;
import br.com.allstore.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById (@PathVariable Integer id) throws Exception {
        Client obj =service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Client> clientInsert(@RequestBody ClientDTO objDTO){
        Client obj = service.fromDTO(objDTO);
        obj =  service.insert(obj);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
}
