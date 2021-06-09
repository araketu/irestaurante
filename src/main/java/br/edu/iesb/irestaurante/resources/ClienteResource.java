package br.edu.iesb.irestaurante.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iesb.irestaurante.domain.Cliente;
import br.edu.iesb.irestaurante.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	
	@Autowired
	private ClienteService service;
	

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}	
