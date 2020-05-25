package br.com.cooperativa.error;

public class VotoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VotoException(String message, Throwable cause) {
		super(message, cause);
	}
}
