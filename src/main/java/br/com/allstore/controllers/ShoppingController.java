package br.com.allstore.controllers;

import br.com.allstore.services.ShoppingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buy")
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping(value = "/book")
    public ResponseEntity<String> BookBuy(@RequestParam Long clientId, @RequestParam Long bookId){

        if(shoppingService.buyBook(clientId, bookId)){
            return ResponseEntity.ok("Compra realizada, parabens!!!!");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente para a compra.");
        }
    }
}
