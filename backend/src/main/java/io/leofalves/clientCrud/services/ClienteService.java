package io.leofalves.clientCrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.leofalves.clientCrud.dto.ClientDto;
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

	public Page<ClientDto> findAllPaged(PageRequest pageRequest) {
		Page<Client> page = clientRepository.findAll(pageRequest);
		return page.map(c -> new ClientDto(c));
	}
}
