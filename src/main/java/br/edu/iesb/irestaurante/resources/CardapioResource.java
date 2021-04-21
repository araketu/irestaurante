package br.edu.iesb.irestaurante.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iesb.irestaurante.domain.Cardapio;
import br.edu.iesb.irestaurante.resources.util.URL;
import br.edu.iesb.irestaurante.services.CardapioService;

// Informa que essa classe é um recurso REST
@RestController
// Informa o caminho do Endpoint
@RequestMapping(value="/cardapios")
public class CardapioResource {
	
	//Faz o requisistos requesitarem o servico para trazer todos os objetos	
	@Autowired
	private CardapioService service;
	

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cardapio> findById(@PathVariable String id){
		
		Cardapio obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value="/buscaporcomida", method=RequestMethod.GET)
	public ResponseEntity<List<Cardapio>> findByComida(@RequestParam(value="text", defaultValue="") String text){
		
//		Decodifica o text passado como parametro para o formato URL java
		text = URL.decodeParam(text);
		List<Cardapio> list = service.findbyTitle(text);
		return ResponseEntity.ok().body(list);		
	}
	
	

}
