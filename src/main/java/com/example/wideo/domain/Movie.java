package com.example.wideo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public int quantity;

    public String moviename;

    public String director;

    public Double payment;

    public LocalDate productionYear;

    public MovieType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return quantity == movie.quantity &&
                Objects.equals(id, movie.id) &&
                Objects.equals(moviename, movie.moviename) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(payment, movie.payment) &&
                Objects.equals(productionYear, movie.productionYear) &&
                type == movie.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, moviename, director, payment, productionYear, type);
    }
}
