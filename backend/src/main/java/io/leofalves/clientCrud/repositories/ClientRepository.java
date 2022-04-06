package io.leofalves.clientCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.leofalves.clientCrud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
