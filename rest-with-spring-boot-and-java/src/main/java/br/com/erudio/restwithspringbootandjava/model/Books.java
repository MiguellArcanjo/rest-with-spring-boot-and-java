package br.com.erudio.restwithspringbootandjava.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = true, length = 80)
    private String author;

    @Column(name = "launch_date", nullable = false, length = 80)
    private LocalDate launch_date;

    @Column(name = "price", nullable = false, length = 80)
    private double price;

    @Column(name = "title", nullable = true, length = 80)
    private String tittle;

    public Books(Long id, String author, LocalDate launch_date, double price, String tittle) {
        this.id = id;
        this.author = author;
        this.launch_date = launch_date;
        this.price = price;
        this.tittle = tittle;
    }

    public Books() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getLaunchDate() {
        return launch_date;
    }

    public void setLaunchDate(LocalDate launch_date) {
        this.launch_date = launch_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Double.compare(price, books.price) == 0 && Objects.equals(id, books.id) && Objects.equals(author, books.author) && Objects.equals(launch_date, books.launch_date) && Objects.equals(tittle, books.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launch_date, price, tittle);
    }
}
