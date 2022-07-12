package br.com.alticciservice.exception;

public class NumeroInvalidoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NumeroInvalidoException(String mensagem) {
		super (mensagem);
	}
	
	public NumeroInvalidoException(String mensagem, Throwable causa) {
		super (mensagem, causa);
	}
	
	 

}
