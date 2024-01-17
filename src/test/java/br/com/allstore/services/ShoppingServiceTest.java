package br.com.allstore.services;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.dto.ClientDTO;
import br.com.allstore.entities.Book;
import br.com.allstore.entities.Client;
import br.com.allstore.repositories.BookRepository;
import br.com.allstore.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingServiceTest {

//    @InjectMocks
//    private ShoppingService service;
//
//    @Mock
//    private ClientService clientService;
//
//    @Mock
//    private ClientRepository clientRepository;
//
//    @Mock
//    private BookRepository bookRepository;
//
//    @Mock
//    private Client client;
//
//    @Mock
//    private Book book;
//
//    @Mock
//    private ClientDTO clientDTO;
//
//    @Mock
//    private BookDTO bookDTO;
//
//
//    @Test
//    void deveriaRetornarVerdadeiroParaACompra(){
//
//        this.clientDTO = new ClientDTO(1L, "Jessya", "81638063036", 100f);
//        this.bookDTO = new BookDTO(1L,"HarryPotter", "Tranfobica", 50f);
//        when(clientDTO).thenReturn(clientDTO);
//        when(bookDTO).thenReturn(bookDTO);
//
//        clientService.cleinteRegister(clientDTO);
//
//        //assertTrue(result);
//        assertEquals("Jessya", client.getName()); // Verifica se o saldo foi deduzido corretamente
//        //assertTrue(client.getBooks().contains(book)); // Verifica se o livro foi adicionado à lista de livros do cliente
//        //verify(clientRepository, times(1)).save(client);
//
//    }

}