package com.example.wideo.controler;


import com.example.wideo.domain.Client;
import com.example.wideo.domain.LoginRequest;
import com.example.wideo.domain.Movie;
import com.example.wideo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "client")
public class ClientControler {


    @Autowired
    public ClientService clientService;


    @PostMapping("login")
    public Client login(@RequestBody LoginRequest loginRequest)
    {
        return clientService.LoginToShpop(loginRequest.login, loginRequest.password);
    }

    @PostMapping("{id}/money/add")
    public ResponseEntity addMoney(@RequestParam(name = "amount") Double amount, @PathVariable(name = "id") Long clientId)
    {
        clientService.increseWallet(clientId, amount);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("{id}/movie/add")
    public Client addMovie(@RequestBody Movie movie, @PathVariable(name = "id") Long clientId)
    {
        return clientService.buyMovie(clientId, movie);
    }


    @PostMapping("{id}/movie/remove")
    public Client removeMovie(@RequestBody Movie movie, @PathVariable(name = "id") Long clientId)
    {
        return clientService.refoundMovie(clientId, movie);
    }




}
