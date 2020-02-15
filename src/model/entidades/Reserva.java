package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecao.ExcessaoDominio;

public class Reserva {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer quarto;
	private Date entrada;
	private Date saida;
	
	public Reserva(Integer quarto, Date entrada, Date saida) {
		if (!saida.after(entrada)) {
			throw new ExcessaoDominio ("Check-out date must be after check-in date.");
		} 
		this.quarto = quarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaída() {
		return saida;
	}

	public long duracao () {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void atualizacao (Date entrada, Date saida) {
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			throw new ExcessaoDominio ("Reservation data for update must be future dates.");
		} 
		if (!saida.after(entrada)) {
			throw new ExcessaoDominio ("Check-out date must be after check-in date.");
		} 
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override 
	public String toString () {
		return "Quarto: "
				+ quarto
				+ ", Entrada: "
				+ sdf.format(entrada)
				+ ", Saída: "
				+ sdf.format(saida)
				+ ", Noites: "
				+ duracao();
	}
	
}
