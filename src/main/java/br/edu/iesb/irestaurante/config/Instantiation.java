package br.edu.iesb.irestaurante.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.iesb.irestaurante.domain.Cardapio;
import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.repository.CardapioRepository;
import br.edu.iesb.irestaurante.repository.RestauranteRepository;

//Mostra para a biblioteca que isso se trata de uma configuracao da palicacao
@Configuration
public class Instantiation implements CommandLineRunner {

//	Instancia a minha depedencia ao meu repository
	@Autowired
	private RestauranteRepository restauRepository;
	
//	Instancia o cardapio ao repositorio
	@Autowired
	private CardapioRepository cardapioRepository;
	
	
//	instanciara o objetos no banco de dados toda vez que iniciar o projeto no banco de dados
	@Override
	public void run(String... args) throws Exception {
		
		// Limpa a minha colecao no meu banco de dados
		restauRepository.deleteAll();
		cardapioRepository.deleteAll();
		
		Restaurante careca = new Restaurante(null, "Restaurante Careca", "careca@gmail.com",
				"+5561996763456","Brasilia","Asa Norte","SQN 411","Chinesa");
		Restaurante generica = new Restaurante(null, "Pizzaria Generica", "generica@gmail.com",
				"+556132646281","Brasilia","Asa Norte","SQN 207","Pizza");
		Restaurante ducheff = new Restaurante(null, "Pizzaria Du`Chef", "duchef@gmail.com",
				"+556135616284","Taguatinga","Norte","QND 17","Pizza");
		Restaurante cib = new Restaurante(null, "China in Box", "cib@gmail.com",
				"+5561996769999","Brasilia","Asa Sul","SQS 412","Chinesa");
		
		Cardapio cardapiocareca = new Cardapio(null, "Arroz Colorido", 23.34, "Arroz Branco com legumes", careca);
		Cardapio cardapiocarec1 = new Cardapio(null, "SHop Suey - Vaca", 32.34, "Carne de Vaca com Legumes cozido", careca);
		Cardapio cardapiogenerica = new Cardapio(null, "Pizza Napolitana", 40.00, "Pizza com Legumes", generica);
		Cardapio cardapioducheff = new Cardapio(null, "Pizza Ducheff", 50.00, "Pizza a moda do Cheff", ducheff);
		Cardapio cardapiocib = new Cardapio(null, "Combo China in Box", 70.00, "Combo Arroz + Carne com Legumes", cib);
		
		
		// Salva os novos restaurantes e cardapios no banco
		restauRepository.saveAll(Arrays.asList(careca, generica, ducheff, cib));
		cardapioRepository.saveAll(Arrays.asList(cardapiocareca, cardapiocarec1, cardapiogenerica,cardapioducheff, cardapiocib));
		
	}

}
