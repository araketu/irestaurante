package br.edu.iesb.irestaurante.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.iesb.irestaurante.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente,String> {

}
