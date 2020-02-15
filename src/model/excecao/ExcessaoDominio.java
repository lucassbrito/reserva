package model.excecao;

public class ExcessaoDominio extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ExcessaoDominio (String msg) {
		super(msg);
	}
}
