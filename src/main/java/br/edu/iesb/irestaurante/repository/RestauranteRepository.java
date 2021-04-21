package br.edu.iesb.irestaurante.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.iesb.irestaurante.domain.Restaurante;

@Repository
//Por onde é possível alterar, deletar ou criar no Mongodb
public interface RestauranteRepository extends MongoRepository<Restaurante, String>{

}
