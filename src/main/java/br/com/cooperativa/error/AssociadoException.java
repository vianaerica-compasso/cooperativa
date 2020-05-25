package br.com.cooperativa.error;

public class AssociadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AssociadoException(String message, Throwable cause) {
		super(message, cause);
	}
}
