package br.edu.iesb.irestaurante.services;

//Ao pesquisar o Restuarante por ID e não encontrar será utilizado essa classe
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
