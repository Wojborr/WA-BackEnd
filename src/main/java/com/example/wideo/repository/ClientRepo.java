package com.example.wideo.repository;

import com.example.wideo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {


    Client findByLoginAndPassword(String login, String password);


}
