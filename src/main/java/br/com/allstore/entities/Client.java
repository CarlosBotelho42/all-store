package br.com.allstore.entities;

import br.com.allstore.dto.ClientDTO;
import br.com.allstore.dto.UpdateClientBalanceDTO;
import br.com.allstore.dto.UpdateClientDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CH_CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String document;
    private Float balance;

    @ManyToMany
    @JoinTable(name = "TB_CH_CLIENTS_BOOKS")
    private List<Book> books = new ArrayList<>();

    public Client() {
    }

    public Client(ClientDTO dto){
        this.name = dto.name();
        this.document = dto.document();
        this.balance = dto.balance();
    }

    public void updateData(UpdateClientDTO dto) {
        this.name = dto.name();
        this.document = dto.document();
    }

    public void updateBalance(UpdateClientBalanceDTO dto){

        this.balance += dto.balance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getBalance() {
        return balance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Client client = (Client) object;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
