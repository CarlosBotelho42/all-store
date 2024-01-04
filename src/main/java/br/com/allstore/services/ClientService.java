package br.com.allstore.services;

import br.com.allstore.dto.ClientDTO;
import br.com.allstore.dto.UpdateClientBalanceDTO;
import br.com.allstore.dto.UpdateClientDTO;
import br.com.allstore.entities.Client;
import br.com.allstore.exception.MyValidationException;
import br.com.allstore.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository repo) {
        this.clientRepository = repo;
    }


    public void cleinteRegister(ClientDTO dto) {

        boolean registerVerify = clientRepository.existsByDocument(dto.document());

        if (registerVerify) {
            throw new MyValidationException("CPF já cadstrado para outro cliente...");
        }
        clientRepository.save(new Client(dto));
    }

    public Client findClient(String documentOrId) {

        Optional<Client> optional;
        try {
            Long id = Long.parseLong(documentOrId);
            optional = clientRepository.findById(id);

        } catch (NumberFormatException e) {
            optional = Optional.ofNullable(clientRepository.findByDocument(documentOrId));
        }
        return optional.orElseThrow(() -> new MyValidationException("Cliente não encontrado!!"));
    }

    public void clientUpdate(UpdateClientDTO dto) {
        Client client = clientRepository.getReferenceById(dto.id());
        client.updateData(dto);
    }

    public void balanceInsert(UpdateClientBalanceDTO dto) {

        Client client = clientRepository.getReferenceByDocument(dto.document());
        client.updateBalance(dto);

    }
}
