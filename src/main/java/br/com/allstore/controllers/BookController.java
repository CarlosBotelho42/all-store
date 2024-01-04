package br.com.allstore.controllers;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.dto.UpdateBookDTO;
import br.com.allstore.dto.UpdateClientDTO;
import br.com.allstore.entities.Book;
import br.com.allstore.entities.Client;
import br.com.allstore.services.BookService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody BookDTO dto){
        try {
            this.service.bookRegister(dto);
            return ResponseEntity.ok("Cadastro realizado com sucesso!");
        } catch (ValidationException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findByDocument(@PathVariable Long id){

        try {
            Book book = service.findBook(id);
            return ResponseEntity.ok(book);
        }
        catch(ValidationException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> clientUpdate(@RequestBody @Valid UpdateBookDTO dto){
        try {
            this.service.bookUpdate(dto);
            return ResponseEntity.ok("Atualizacao do livro realizada com sucesso...");
        }
        catch (ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
