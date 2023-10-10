package br.com.allstore.services;

import br.com.allstore.dto.ClientDTO;
import br.com.allstore.entities.Client;
import br.com.allstore.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public Client findById(Integer id) throws Exception {
        Optional<Client> obj = repo.findById(id);

        return obj.orElseThrow(() -> new Exception(
                "Objeto não encontrado! Id: " + id
        )) ;
    }

    public Client insert(Client obj){
        obj = repo.save(obj);
        return obj;
    }

    public Client fromDTO(ClientDTO clientDTO){
        return new Client(null, clientDTO.firstName(), clientDTO.lastName(), clientDTO.document(), clientDTO.balance());
    }

}
