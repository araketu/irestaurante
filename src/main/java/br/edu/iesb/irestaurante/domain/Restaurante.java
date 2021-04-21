package br.edu.iesb.irestaurante.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


//  Criando a Classe Restaurante e seus respectivos atributos 
//  Serializable permitea covnersão da informacao em bits

@Document(collection = "POO")
//Mostra para o banco qual a colecao no banco voce esta referenciando
public class Restaurante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String email;
	private String numero;
	private String cidade;
	private String bairro;
	private String endereco;
	private String tipocomida;
	
	@DBRef (lazy=true) // Ao carregar um restaurante garante que nao carregara automaticamente o cardapio só quando acessa-los
	private List<Cardapio> cardapios = new ArrayList<>();
	

// Constrututor - Um método com o mesmo nome da classe
 	
	public Restaurante() {
	}

// Constrututor - Que recebe os atributos citados na classe
 
	public Restaurante(String id, String nome, String email, String numero, String cidade,
		String bairro, String endereco, String tipocomida) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.endereco = endereco;
		this.tipocomida = tipocomida;
	}
	
	 
//	 Método de acesso dos atributos da classe

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTipocomida() {
		return tipocomida;
	}
	public void setTipocomida(String tipocomida) {
		this.tipocomida = tipocomida;
	}	
	public List<Cardapio> getCardapios() {
		return cardapios;
	}
	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
	
	
//	 Método de comparacao dos obejetos pelo atributo ID



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


		
}	
	
	
	
	
	
