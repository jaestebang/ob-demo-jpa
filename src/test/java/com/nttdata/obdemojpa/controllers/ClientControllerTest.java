package com.nttdata.obdemojpa.controllers;

import com.nttdata.obdemojpa.entities.Client;
import com.nttdata.obdemojpa.entities.ClientId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate((restTemplateBuilder));
    }

    /**
     * Get client
     */
    @Test
    void findByTypeDni_OK() {

        //Execute
        ResponseEntity<Client> response = testRestTemplate.getForEntity("/api/clients/findByTypeDni/C/23445322", Client.class);

        //Asserts (OK)
        assertEquals(HttpStatus.OK, response.getStatusCode());

        //Asserts (Size > 0)
        List<Client> clients = Arrays.asList(response.getBody());
        assertTrue(clients.size() > 0);
    }

    /**
     * Not get client, data doesn't exits
     */
    @Test
    void findByTypeDni_NOT_FOUND() {

        //Execute
        ResponseEntity<Client> response = testRestTemplate.getForEntity("/api/clients/findByTypeDni/J/23445322", Client.class);

        //Asserts (NOT_FOUND)
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    /**
     * Not get client, Wrong data type
     */
    @Test
    void findByTypeDni_BAD_REQUEST() {

        //Execute dni is not number
        ResponseEntity<Client> response = testRestTemplate.getForEntity("/api/clients/findByTypeDni/J/R", Client.class);

        //Asserts (BAD_REQUEST)
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}