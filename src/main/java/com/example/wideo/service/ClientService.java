package com.example.wideo.service;


import com.example.wideo.domain.Client;
import com.example.wideo.domain.Movie;
import com.example.wideo.exception.UnAutorizeException;
import com.example.wideo.repository.ClientRepo;
import com.example.wideo.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    @Autowired
    public ClientService(ClientRepo repository, MovieRepo repositoryM) {
        this.repository = repository;
        this.repositoryM = repositoryM;
    }

    public final ClientRepo repository;
    public final MovieRepo repositoryM;




    public Client  LoginToShpop(String login, String password)
    {
        Client client = repository.findByLoginAndPassword(login, password);

        if(client == null)
        {
            throw new UnAutorizeException("Bad credencial");
        }
        return client;
    }

    public Client descreseWallet(Long clientId, Double amount)
    {
        Client client = repository.findById(clientId).get();
        client.wallet = client.wallet - amount;
        return client;
    }

    public Client increseWallet(Long clientId, Double amount)
    {
        Client client = repository.findById(clientId).get();
        client.wallet = client.wallet + amount;
        return repository.save(client);
    }

    public Client buyMovie(Long clientId ,Movie movie)
    {
        Client client = repository.findById(clientId).get();
        client.movies.add(movie);
        client = descreseWallet(clientId, movie.payment);
        movie.quantity = movie.quantity - 1;
        repositoryM.save(movie);
        repository.save(client);
        return repository.findById(clientId).get();
    }

    public Client refoundMovie(Long clientId ,Movie movie)
    {
        Client client = repository.findById(clientId).get();
        client.movies.remove(movie);
        client = increseWallet(clientId, movie.payment);
        movie.quantity = movie.quantity + 1;
        repositoryM.save(movie);
        repository.save(client);
        return repository.findById(clientId).get();
    }






}
