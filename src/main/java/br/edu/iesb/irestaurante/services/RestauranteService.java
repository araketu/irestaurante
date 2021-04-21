package br.edu.iesb.irestaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.dto.RestauDTO;
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
	
//	Metodo para incluir um restaurante 
	public Restaurante insert(Restaurante obj) {
		return repo.insert(obj);
	}
	
//	Metodo para excluir Restaurantes
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
//	Metodo para atualizar o objeto - restaurante
	public Restaurante update(Restaurante obj) {
		Restaurante newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	private void updateData(Restaurante newObj, Restaurante obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setNumero(obj.getNumero());
		newObj.setCidade(obj.getCidade());
		newObj.setBairro(obj.getBairro());
		newObj.setEndereco(obj.getEndereco());
		newObj.setTipocomida(obj.getTipocomida());
			
	}
	
//	Metodo que retorna um Restaurante com os atributos do RestauDTO
	public Restaurante fromDTO(RestauDTO objDto) {
		return new Restaurante(objDto.getId(), objDto.getNome() , null, null, objDto.getCidade(), objDto.getBairro(), null, objDto.getTipocomida());
	}

}
