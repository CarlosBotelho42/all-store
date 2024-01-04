package br.com.allstore.controllers;

import br.com.allstore.dto.ClientDTO;
import br.com.allstore.dto.UpdateClientBalanceDTO;
import br.com.allstore.dto.UpdateClientDTO;
import br.com.allstore.entities.Client;
import br.com.allstore.services.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> clientRegister(@Valid @RequestBody ClientDTO dto) {

        try {
            this.service.cleinteRegister(dto);
            return ResponseEntity.ok("Cadastro realizado com sucesso!");
        } catch (ValidationException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{documentOrId}")
    public ResponseEntity<Client> findByDocument(@PathVariable String documentOrId){

        try {
           Client client = service.findClient(documentOrId);
           return ResponseEntity.ok(client);
        }
        catch(ValidationException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> clientUpdate(@RequestBody @Valid UpdateClientDTO dto){
        try {
            this.service.clientUpdate(dto);
            return ResponseEntity.ok("Atualizacao de cliente realizada com sucesso...");
        }
        catch (ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/balance")
    @Transactional
    public ResponseEntity<String> clientBalanceInsert(@RequestBody @Valid UpdateClientBalanceDTO dto){
        try {
            this.service.balanceInsert(dto);
            return ResponseEntity.ok("Saldo do cleinte atualizado");
        }
        catch(ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
