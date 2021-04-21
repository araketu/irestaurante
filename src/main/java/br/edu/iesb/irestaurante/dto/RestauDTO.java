package br.edu.iesb.irestaurante.dto;

import java.io.Serializable;

import br.edu.iesb.irestaurante.domain.Restaurante;

public class RestauDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	private String email;
	private String numero;
	private String cidade;
	private String bairro;
	private String endereco;
	private String tipocomida;
	
	public RestauDTO() {
		
	}
	
//	Instancia um Restaurante Padrao DTO por meio de um objeto classe Restaurante - poli 
	public RestauDTO(Restaurante obj) {
		id = obj.getId();
		nome = obj.getNome();
		cidade = obj.getCidade();
		bairro = obj.getBairro();
		tipocomida = obj.getTipocomida();
	}

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

	public String getTipocomida() {
		return tipocomida;
	}

	public void setTipocomida(String tipocomida) {
		this.tipocomida = tipocomida;
	}

	
	
}
