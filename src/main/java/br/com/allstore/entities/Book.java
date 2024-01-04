package br.com.allstore.entities;

import br.com.allstore.dto.BookDTO;
import br.com.allstore.dto.UpdateBookDTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CH_BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String author;
    private Float price;


    public Book() {
    }

    public Book(BookDTO dto) {
        this.name = dto.name();
        this.author = dto.author();
        this.price = dto.price();
    }

    public void updateData(UpdateBookDTO dto) {
        this.name = dto.name();
        this.author = dto.author();
        this.price = dto.price();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }


}
