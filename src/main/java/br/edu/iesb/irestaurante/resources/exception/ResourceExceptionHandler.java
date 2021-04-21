package br.edu.iesb.irestaurante.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.iesb.irestaurante.services.ObjectNotFoundException;


// Avisa ao Spring Boot que essa classe vai tratar possive erros
@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado",e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
