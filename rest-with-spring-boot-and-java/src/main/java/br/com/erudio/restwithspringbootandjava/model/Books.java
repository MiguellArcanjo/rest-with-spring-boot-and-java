package br.com.erudio.restwithspringbootandjava.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = true, length = 80)
    private String author;

    @Column(name = "launcher_date", nullable = false, length = 80)
    private LocalDate launcherDate;

    @Column(name = "price", nullable = false, length = 80)
    private double price;

    @Column(name = "title", nullable = true, length = 80)
    private String tittle;

    public Books(Long id, String author, LocalDate launcherDate, double price, String tittle) {
        this.id = id;
        this.author = author;
        this.launcherDate = launcherDate;
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

    public LocalDate getLauncherDate() {
        return launcherDate;
    }

    public void setLauncherDate(LocalDate launcherDate) {
        this.launcherDate = launcherDate;
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
        return Double.compare(price, books.price) == 0 && Objects.equals(id, books.id) && Objects.equals(author, books.author) && Objects.equals(launcherDate, books.launcherDate) && Objects.equals(tittle, books.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launcherDate, price, tittle);
    }
}
