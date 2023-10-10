package br.com.allstore.controllers;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.entities.Book;
import br.com.allstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) throws Exception {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody BookDTO bookDTO){
        Book obj = service.fromDTO(bookDTO);
        obj = service.insert(obj);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

}
