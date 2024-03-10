package br.com.erudio.restwithspringbootandjava.data.vo.v1;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

public class BooksVO {

    private Long id;
    private String author;
    private LocalDate launcherDate;
    private double price;
    private String tittle;

    public BooksVO(Long id, String author, LocalDate launcherDate, double price, String tittle) {
        this.id = id;
        this.author = author;
        this.launcherDate = launcherDate;
        this.price = price;
        this.tittle = tittle;
    }

    public BooksVO() {

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
        BooksVO books = (BooksVO) o;
        return Double.compare(price, books.price) == 0 && Objects.equals(id, books.id) && Objects.equals(author, books.author) && Objects.equals(launcherDate, books.launcherDate) && Objects.equals(tittle, books.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launcherDate, price, tittle);
    }
}
