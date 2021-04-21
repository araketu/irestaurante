package br.edu.iesb.irestaurante.services;

import java.util.List;
import java.util.Optional;

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
//	Metoddo para busccar os restaurantes pelo id deles
	public Restaurante findById(String id) {
		Optional<Restaurante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Restaurante nao Encontrado"));
	}

}
