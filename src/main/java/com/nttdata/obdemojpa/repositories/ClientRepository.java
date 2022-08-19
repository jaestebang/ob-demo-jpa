package com.nttdata.obdemojpa.repositories;

import com.nttdata.obdemojpa.entities.Client;
import com.nttdata.obdemojpa.entities.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, ClientId> { }
