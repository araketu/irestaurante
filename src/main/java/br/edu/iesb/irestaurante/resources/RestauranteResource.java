package br.edu.iesb.irestaurante.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<RestauDTO> findById(@PathVariable String id){
		
		Restaurante obj = service.findById(id);
		return ResponseEntity.ok().body(new RestauDTO(obj));		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody RestauDTO objDto){
		
		Restaurante obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
//		Vai me dar o endereco do no objeto que foi inserido
		URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("?{id}").buildAndExpand(obj.getId()).toUri();
//		Retorna uma Entidade vazia no CODE 201 HEADERs com endereço de ciracao
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody RestauDTO objDto, @PathVariable String id ){
		
		Restaurante obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();	
		
	}
	
	
	

}
