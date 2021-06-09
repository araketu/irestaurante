package br.edu.iesb.irestaurante.dto;

import java.io.Serializable;
import java.util.List;

import br.edu.iesb.irestaurante.domain.Restaurante;

public class AvaliacaoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String comentario;
	private String data;
	private ClienteDTO cliente;	
	
	
	public AvaliacaoDTO() {
		
	}


	public AvaliacaoDTO(String comentario, String data, ClienteDTO clienteDTO) {
		super();
		this.comentario = comentario;
		this.data = data;
		this.cliente = (ClienteDTO) clienteDTO;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	

}
