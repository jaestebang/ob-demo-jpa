package com.nttdata.obdemojpa.controllers;

import com.nttdata.obdemojpa.entities.Client;
import com.nttdata.obdemojpa.entities.ClientId;
import com.nttdata.obdemojpa.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clients")
@Slf4j
public class ClientController {

    private final ClientRepository clientRepository;

    /**
     * Constructor init
     *
     * @param clientRepository Repository
     */
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/findById")
    public ResponseEntity<Client> findById(@RequestBody ClientId clientId) {
        log.info("Client DTO: " + clientId.toString());
        Optional<Client> optionalClient = clientRepository.findById(new ClientId(clientId.getTypeDni(), clientId.getDni()));
        return optionalClient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByTypeDni/{typeDni}/{dni}")
    public ResponseEntity<Client> findByTypeDni(@PathVariable String typeDni, @PathVariable int dni) {
        Optional<Client> optionalClient = clientRepository.findById(new ClientId(typeDni, dni));
        return optionalClient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find")
    public List<Client> findAll(){
        log.info("find");
        return clientRepository.findAll();
    }
}
