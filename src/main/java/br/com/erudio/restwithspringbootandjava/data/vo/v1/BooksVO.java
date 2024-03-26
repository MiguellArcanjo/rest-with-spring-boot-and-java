package br.com.erudio.restwithspringbootandjava.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"key", "author", "launchDate", "price", "tittle"})
public class BooksVO extends RepresentationModel<BooksVO> {

    private Long key;
    private String author;
    private LocalDate launch_date;
    private double price;
    private String tittle;

    public BooksVO(Long key, String author, LocalDate launch_date, double price, String tittle) {
        this.key = key;
        this.author = author;
        this.launch_date = launch_date;
        this.price = price;
        this.tittle = tittle;
    }

    public BooksVO() {

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
        BooksVO books = (BooksVO) o;
        return Double.compare(price, books.price) == 0 && Objects.equals(key, books.key) && Objects.equals(author, books.author) && Objects.equals(launch_date, books.launch_date) && Objects.equals(tittle, books.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, author, launch_date, price, tittle);
    }
}
