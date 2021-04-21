package br.edu.iesb.irestaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iesb.irestaurante.domain.Cardapio;
import br.edu.iesb.irestaurante.repository.CardapioRepository;

@Service
public class CardapioService {
	
//	Instancia automaticamente meu objeto / Injeta automaticamente uma dependencia
	@Autowired
	private CardapioRepository repo;
	


//	Metoddo para busccar os restaurantes pelo id do cardapio
	public Cardapio findById(String id) {
		Optional<Cardapio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Prato nao Encontrado"));
	}
	
//	Metodo que encontra pratos pelo nome
	public List<Cardapio> findbyTitle(String text){
		return repo.findByComidaContainingIgnoreCase(text);
	}
	
}