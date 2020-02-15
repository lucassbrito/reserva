package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer quarto;
	private Date entrada;
	private Date saida;
	
	public Reserva(Integer quarto, Date entrada, Date saída) {
		this.quarto = quarto;
		this.entrada = entrada;
		this.saida = saída;
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
	
	public String atualizacao (Date entrada, Date saida) {
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			return "Reservation data for update must be future dates.";
		} 
		if (!saida.after(entrada)) {
			return "Check-out date must be after check-in date.";
		} 
		this.entrada = entrada;
		this.saida = saida;
		return null;
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
