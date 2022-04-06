package io.leofalves.clientCrud.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.leofalves.clientCrud.entities.Client;
import io.leofalves.clientCrud.services.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	ClienteService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}
}