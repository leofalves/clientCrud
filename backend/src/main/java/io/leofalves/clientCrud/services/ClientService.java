package io.leofalves.clientCrud.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.leofalves.clientCrud.dto.ClientDto;
import io.leofalves.clientCrud.entities.Client;
import io.leofalves.clientCrud.repositories.ClientRepository;
import io.leofalves.clientCrud.services.exceptions.DatabaseException;
import io.leofalves.clientCrud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public List<Client> findAll() {
		List<Client> list = clientRepository.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Page<ClientDto> findAllPaged(PageRequest pageRequest) {
		Page<Client> page = clientRepository.findAll(pageRequest);
		return page.map(c -> new ClientDto(c));
	}

	@Transactional(readOnly = true)
	public ClientDto findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
		return new ClientDto(client);
	}

	@Transactional
	public ClientDto insert(ClientDto dto) {
		Client client = new Client();
		client.setName(dto.getName());
		client.setIncome(dto.getIncome());
		client.setCpf(dto.getCpf());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		client = clientRepository.save(client);
		return new ClientDto(client);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public ClientDto update(Long id, ClientDto clientDto) {
		try {
			Client client = clientRepository.getOne(id); // #Question: Do we use getById(id) instead?
			client.setName(clientDto.getName());
			client.setBirthDate(clientDto.getBirthDate());
			client.setChildren(clientDto.getChildren());
			client.setCpf(clientDto.getCpf());
			client.setIncome(clientDto.getIncome());
			client = clientRepository.save(client);
			return new ClientDto(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Client not found. id = " + id);
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Client not found. id = " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Database Integrity Violation");
		}
	}
}
