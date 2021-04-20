package br.edu.iesb.irestaurante.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iesb.irestaurante.domain.Restaurante;

// Informa que essa classe é um recurso REST
@RestController
// Informa o caminho do Endpoint
@RequestMapping(value="/restaurantes")
public class RestauranteResource {
	
//	Método que retorna uma lista de usuários
	@GetMapping
	public ResponseEntity< List<Restaurante>> findAll(){
		
		Restaurante careca = new Restaurante("1","Careca", "careca@gmail.com", "+556199999-7876","Taguatinga", "Norte", "QND 17","Chinesa");
		Restaurante cib = new Restaurante("2","China in BOX", "cib@gmail.com", "+556199999-0076","Taguatinga", "Sul", "QSA 12","Chinesa");
		List<Restaurante> list = new ArrayList<>();
		list.addAll(Arrays.asList(careca, cib));
		return ResponseEntity.ok().body(list);
	}

}
