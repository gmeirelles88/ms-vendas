package com.gft.prjcliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gft.prjcliente.entities.Cliente;
import com.gft.prjcliente.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ResponseEntity<List<Cliente>> findAll() throws Exception {
		List<Cliente> listClientes = clienteRepository.findAll();

		if (listClientes.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listClientes);
	}

	public ResponseEntity<Cliente> findByID(Long id) throws Exception {
		
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if (cliente != null) {
			return ResponseEntity.ok().body(cliente);

		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
