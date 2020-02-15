package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer quarto;
	private Date entrada;
	private Date saida;
	
	public Reserva(Integer quarto, Date entrada, Date sa�da) {
		this.quarto = quarto;
		this.entrada = entrada;
		this.saida = sa�da;
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

	public Date getSa�da() {
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
				+ ", Sa�da: "
				+ sdf.format(saida)
				+ ", Noites: "
				+ duracao();
	}
	
}
