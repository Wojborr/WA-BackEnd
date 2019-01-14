package com.example.wideo.domain;


//Encja to reprezentacja bazy danych za pomoca kodu

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String login;

    public String password;

    public String username;

    public String usersurname;

    @OneToMany
    public List<Movie> movies;

    public Double wallet;




}
