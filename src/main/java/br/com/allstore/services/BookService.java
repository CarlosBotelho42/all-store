package br.com.allstore.services;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.dto.UpdateBookDTO;
import br.com.allstore.entities.Book;
import br.com.allstore.exception.MyValidationException;
import br.com.allstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {


    private final BookRepository repository;

    public BookService(BookRepository repo) {
        this.repository = repo;
    }


    public void bookRegister(BookDTO dto){
        repository.save(new Book(dto));
    }

    public Book findBook(Long id) {
        Optional<Book> optional;
        optional = repository.findById(id);

        return optional.orElseThrow(() -> new MyValidationException("Livro não encontrado!!"));
    }

    public void bookUpdate(UpdateBookDTO dto) {
        Book book = repository.getReferenceById(dto.id());
        book.updateData(dto);
    }
}
