package br.edu.iesb.irestaurante.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.iesb.irestaurante.domain.Cardapio;

@Repository
//Por onde é possível alterar, deletar ou criar no Mongodb
public interface CardapioRepository extends MongoRepository<Cardapio, String>{
	
	List<Cardapio> findByComidaContainingIgnoreCase(String text);

}
