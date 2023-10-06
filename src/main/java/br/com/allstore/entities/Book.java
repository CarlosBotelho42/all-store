package br.com.allstore.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CH_BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private Float price;


    public Book() {
    }

    public Book(Integer id, String name, String author, Float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
