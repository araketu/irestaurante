package br.edu.iesb.irestaurante.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.edu.iesb.irestaurante.dto.AvaliacaoDTO;
import br.edu.iesb.irestaurante.dto.ClienteDTO;


@Document
public class Cardapio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String comida;
	private double preco;
	private String body;
	private Restaurante author;
	
	private List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
	
	
	
	public Cardapio() {
		
	}


	public Cardapio(String id, String comida, double preco, String body, Restaurante author) {
		super();
		this.id = id;
		this.comida = comida;
		this.preco = preco;
		this.body = body;
		this.author = author;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getComida() {
		return comida;
	}


	public void setComida(String comida) {
		this.comida = comida;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}
	
	public Restaurante getAuthor() {
		return author;
	}

	public void setAuthor(Restaurante author) {
		this.author = author;
	}

	public List<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}


	public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}


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
		Cardapio other = (Cardapio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}






	
	

}
