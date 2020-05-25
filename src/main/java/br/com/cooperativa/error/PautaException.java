package br.com.cooperativa.error;

public class PautaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PautaException(String message, Throwable cause) {
		super(message, cause);
	}
}
