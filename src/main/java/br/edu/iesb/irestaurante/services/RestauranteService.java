package br.edu.iesb.irestaurante.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
//	Instancia automaticamente meu objeto / Injeta automaticamente uma dependencia
	@Autowired
	private RestauranteRepository repo;
	
//	Metodo que me retornará todos obejetos da classe restaurante
	public List<Restaurante> findAll(){
		return repo.findAll();
	}

}
