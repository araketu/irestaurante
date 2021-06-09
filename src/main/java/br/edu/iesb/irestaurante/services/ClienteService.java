package br.edu.iesb.irestaurante.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iesb.irestaurante.domain.Cliente;
import br.edu.iesb.irestaurante.repository.ClienteRepository;

@Service	
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}

}
