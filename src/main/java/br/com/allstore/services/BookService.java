package br.com.allstore.services;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.entities.Book;
import br.com.allstore.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {


    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book findById(Integer id) throws Exception{
        Optional<Book> obj = repo.findById(id);

        return obj.orElseThrow(() -> new Exception(
                "Objeto não encontrado! Id: " + id
        ));
    }

    public Book insert(Book obj){
        obj = repo.save(obj);
        return obj;
    }

    public Book fromDTO(BookDTO bookDTO){
        return new Book(null, bookDTO.name(), bookDTO.author(), bookDTO.price());
    }

}
