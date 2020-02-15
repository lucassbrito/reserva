package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter number room: ");
		int quarto = sc.nextInt();
		System.out.print("Date check-in (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Date check-out (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro in reservation: Check-ou date must be after check-in date.");
		} else {
			Reserva reserva = new Reserva (quarto, entrada, saida);
			System.out.println("Reservation: " + reserva);
			
			System.out.println();
			System.out.print("Date check-in (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Date check-out (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			Date now = new Date();
			if (entrada.before(now) || saida.before(now)) {
				System.out.println("Erro in reservation: Reservation data for update must be future dates.");
			} else if (!saida.after(entrada)) {
				System.out.println("Erro in reservation: Check-out date must be aftet check-in date.");
			} else {
				reserva.atualizacao(entrada, saida);
				System.out.println("Reservation: " + reserva);
			}
		}
		
		sc.close();
	}

}
