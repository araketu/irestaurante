package br.edu.iesb.irestaurante.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.repository.RestauranteRepository;

//Mostra para a biblioteca que isso se trata de uma configuracao da palicacao
@Configuration
public class Instantiation implements CommandLineRunner {

//	c=instancia a minha depedencia ao meu repository
	@Autowired
	private RestauranteRepository restauRepository;
	
	
//	instanciara o objetos no banco de dados toda vez que iniciar o projeto no banco de dados
	@Override
	public void run(String... args) throws Exception {
		
		// Limpa a minha colecao no meu banco de dados
		restauRepository.deleteAll();
		
		Restaurante careca = new Restaurante(null, "Restaurante Careca", "careca@gmail.com",
				"+5561996763456","Brasilia","Asa Norte","SQN 411","Chinesa");
		Restaurante generica = new Restaurante(null, "Pizzaria Generica", "generica@gmail.com",
				"+556132646281","Brasilia","Asa Norte","SQN 207","Pizza");
		Restaurante ducheff = new Restaurante(null, "Pizzaria Du`Chef", "duchef@gmail.com",
				"+556135616284","Taguatinga","Norte","QND 17","Pizza");
		Restaurante cib = new Restaurante(null, "China in Box", "cib@gmail.com",
				"+5561996769999","Brasilia","Asa Sul","SQS 412","Chinesa");
		
		// Salva os novos usuarios no banco
		restauRepository.saveAll(Arrays.asList(careca, generica, ducheff, cib));
		
	}

}
