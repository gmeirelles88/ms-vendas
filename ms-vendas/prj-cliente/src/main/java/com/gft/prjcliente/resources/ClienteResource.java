package com.gft.prjcliente.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.prjcliente.entities.Cliente;
import com.gft.prjcliente.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos() throws Exception {
		return clienteService.findAll();

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) throws Exception {
		return clienteService.findByID(id);
	}
}