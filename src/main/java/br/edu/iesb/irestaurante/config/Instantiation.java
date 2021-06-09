package br.edu.iesb.irestaurante.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.iesb.irestaurante.domain.Cardapio;
import br.edu.iesb.irestaurante.domain.Cliente;
import br.edu.iesb.irestaurante.domain.Restaurante;
import br.edu.iesb.irestaurante.dto.AvaliacaoDTO;
import br.edu.iesb.irestaurante.dto.ClienteDTO;
import br.edu.iesb.irestaurante.repository.CardapioRepository;
import br.edu.iesb.irestaurante.repository.ClienteRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
//	instanciara o objetos no banco de dados toda vez que iniciar o projeto no banco de dados
	@Override
	public void run(String... args) throws Exception {
		
		// Limpa a minha colecao no meu banco de dados
		restauRepository.deleteAll();
		cardapioRepository.deleteAll();
		clienteRepository.deleteAll();
		
		Restaurante careca = new Restaurante(null, "Restaurante Careca", "careca@gmail.com",
				"+5561996763456","Brasilia","Asa Norte","SQN 411","Chinesa");
		Restaurante generica = new Restaurante(null, "Pizzaria Generica", "generica@gmail.com",
				"+556132646281","Brasilia","Asa Norte","SQN 207","Pizza");
		Restaurante ducheff = new Restaurante(null, "Pizzaria Du`Chef", "duchef@gmail.com",
				"+556135616284","Taguatinga","Norte","QND 17","Pizza");
		Restaurante cib = new Restaurante(null, "China in Box", "cib@gmail.com",
				"+5561996769999","Brasilia","Asa Sul","SQS 412","Chinesa");
		
		Cliente c1 = new Cliente(null, "Josafa", "jojo@gmail.com");
		Cliente c2 = new Cliente(null, "Maria", "mama@gmail.com");
		Cliente c3 = new Cliente(null, "Mohamed", "momo@gmail.com");
		
		Cardapio cardapiocareca = new Cardapio(null, "Arroz Colorido", 23.34, "Arroz Branco com legumes", careca);
		Cardapio cardapiocarec1 = new Cardapio(null, "SHop Suey - Vaca", 32.34, "Carne de Vaca com Legumes cozido", careca);
		Cardapio cardapiogenerica = new Cardapio(null, "Pizza Napolitana", 40.00, "Pizza com Legumes", generica);
		Cardapio cardapioducheff = new Cardapio(null, "Pizza Ducheff", 50.00, "Pizza a moda do Cheff", ducheff);
		Cardapio cardapiocib = new Cardapio(null, "Combo China in Box", 70.00, "Combo Arroz + Carne com Legumes", cib);
		
		
		AvaliacaoDTO a1 = new AvaliacaoDTO("Carne sem molho. Poucos legumes!!! Só veio arroz...","04/06/2021",new ClienteDTO(c1));
		AvaliacaoDTO a2 = new AvaliacaoDTO("O arroz estava muito cru","02/06/2021",new ClienteDTO(c2));
		AvaliacaoDTO a3 = new AvaliacaoDTO("Legumes velhos, mas a carne estava muito boa","03/06/2021",new ClienteDTO(c3));
		AvaliacaoDTO a4 = new AvaliacaoDTO("A melhor pizza a moda...","04/06/2021",new ClienteDTO(c1));
		AvaliacaoDTO a5 = new AvaliacaoDTO("Perfeita! só podia ser mais barata","07/06/2021",new ClienteDTO(c2));
		AvaliacaoDTO a6 = new AvaliacaoDTO("Combinação perfeita de valores","01/06/2021",new ClienteDTO(c3));
		

		
		// Salva os novos restaurantes e cardapios no banco
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		restauRepository.saveAll(Arrays.asList(careca, generica, ducheff, cib));
		cardapioRepository.saveAll(Arrays.asList(cardapiocareca, cardapiocarec1, cardapiogenerica,cardapioducheff, cardapiocib));
		
		
		careca.getCardapios().addAll(Arrays.asList(cardapiocareca,cardapiocarec1));	
		generica.getCardapios().addAll(Arrays.asList(cardapiogenerica));
		ducheff.getCardapios().addAll(Arrays.asList(cardapioducheff));
		cib.getCardapios().addAll(Arrays.asList(cardapiocib));
		
		
		cardapiocarec1.getAvaliacoes().addAll(Arrays.asList(a1,a2,a3));
		cardapioducheff.getAvaliacoes().addAll(Arrays.asList(a4,a5,a6));
		
		restauRepository.saveAll(Arrays.asList(careca, generica, ducheff, cib));
		
	}

}
