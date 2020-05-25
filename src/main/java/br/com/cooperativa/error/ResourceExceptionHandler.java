package br.com.cooperativa.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
//@EnableWebMvc
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErroGeralException> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		ErroGeralException err = new ErroGeralException(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(AssociadoException.class)
	public ResponseEntity<ErroGeralException> erroAssociado(AssociadoException e, HttpServletRequest request) {
		ErroGeralException err = new ErroGeralException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(PautaException.class)
	public ResponseEntity<ErroGeralException> erroPauta(PautaException e, HttpServletRequest request) {
		ErroGeralException err = new ErroGeralException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(VotoException.class)
	public ResponseEntity<ErroGeralException> erroVoto(VotoException e, HttpServletRequest request) {
		ErroGeralException err = new ErroGeralException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}