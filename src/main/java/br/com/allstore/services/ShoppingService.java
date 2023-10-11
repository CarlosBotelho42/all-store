package br.com.allstore.services;

import br.com.allstore.entities.Book;
import br.com.allstore.entities.Client;
import br.com.allstore.repositories.BookRepository;
import br.com.allstore.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingService {

    private final ClientRepository clientRepository;

    private final BookRepository bookRepository;

    public ShoppingService(ClientRepository clientRepository, BookRepository bookRepository) {
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }

    public boolean buyBook(Integer clientId, Integer bookId){

        Optional<Client> clientOptional = clientRepository.findById(clientId);
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (clientOptional.isPresent() && bookOptional.isPresent()){
            Client client = clientOptional.get();
            Book book = bookOptional.get();

            if (client.getBalance() >= book.getPrice()){

                client.setBalance(client.getBalance() - book.getPrice());
                client.getBooks().add(book);

                clientRepository.save(client);

                return true;
            }
        }
        return false;
    }
}
