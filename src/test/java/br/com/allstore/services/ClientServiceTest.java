package br.com.allstore.services;



import br.com.allstore.dto.ClientDTO;
import br.com.allstore.dto.UpdateClientBalanceDTO;
import br.com.allstore.dto.UpdateClientDTO;
import br.com.allstore.entities.Client;
import br.com.allstore.exception.MyValidationException;
import br.com.allstore.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService service;

    @Mock
    private ClientRepository repository;

    @Mock
    private Client client;

    @Mock
    private ClientDTO clientDTO;

    @Mock
    private UpdateClientDTO updateClientDTO;

    @Mock
    private UpdateClientBalanceDTO updateClientBalanceDTO;


    @Test
    void deveriaCadastrarClienteComSucesso(){
        //this.clientDTO = new ClientDTO(1l, "Jessya", "81638063036", 120f);
        given(repository.existsByDocument(clientDTO.document())).willReturn(false);

        service.cleinteRegister(clientDTO);

        verify(repository).save(Mockito.any(Client.class));
    }

    @Test
    void deveriaCadastrarClienteComErro(){
        //this.clientDTO = new ClientDTO(1l, "Jessya", "81638063036", 120f);
        given(repository.existsByDocument(clientDTO.document())).willReturn(true);

        assertThrows(MyValidationException.class, () -> service.cleinteRegister(clientDTO));
    }

    @Test
    void deveriaAtualizarSaldoCliente(){

        //this.updateClientBalanceDTO = new UpdateClientBalanceDTO("81638063036", 1000f );
        given(repository.getReferenceByDocument(updateClientBalanceDTO.document())).willReturn(client);

        service.balanceInsert(updateClientBalanceDTO);

        verify(client).updateBalance(updateClientBalanceDTO);
    }

    @Test
    void deveriaAtualizarCliente(){
       // this.updateClientDTO = new UpdateClientDTO(1l, "Jessya", "81638063036");
        given(repository.getReferenceById(updateClientDTO.id())).willReturn(client);

        service.clientUpdate(updateClientDTO);

        then(client).should().updateData(updateClientDTO);
    }

}