package io.leofalves.clientCrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leofalves.clientCrud.entities.Client;
import io.leofalves.clientCrud.repositories.ClientRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> findAll() {
		List<Client> list = clientRepository.findAll();
		return list;
	}

}
