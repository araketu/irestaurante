package br.edu.iesb.irestaurante.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.dto.RestauDTO;
import br.edu.iesb.irestaurante.services.RestauranteService;

// Informa que essa classe é um recurso REST
@RestController
// Informa o caminho do Endpoint
@RequestMapping(value="/restaurantes")
public class RestauranteResource {
	
	//Faz o requisistos requesitarem o servico para trazer todos os objetos	
	@Autowired
	private RestauranteService service;
	
	//	Método que retorna uma lista de usuários
	@GetMapping
	public ResponseEntity< List<Restaurante>> findAll(){
		
		List<Restaurante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<RestauDTO> findById(@PathVariable String id){
		
		
		Restaurante obj = service.findById(id);
		return ResponseEntity.ok().body(new RestauDTO(obj));
		
	}

}
