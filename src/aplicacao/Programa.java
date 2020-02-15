package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecao.ExcessaoDominio;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Enter number room: ");
		int quarto = sc.nextInt();
		System.out.print("Date check-in (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Date check-out (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		
		Reserva reserva = new Reserva (quarto, entrada, saida);
		System.out.println("Reservation: " + reserva);
		
		System.out.println();
		System.out.print("Date check-in (dd/MM/yyyy): ");
		entrada = sdf.parse(sc.next());
		System.out.print("Date check-out (dd/MM/yyyy): ");
		saida = sdf.parse(sc.next());
					
		reserva.atualizacao(entrada, saida);
		}
		catch (ParseException e) {
			System.out.println("Invalid date!");
		}
		catch (ExcessaoDominio e) {
			System.out.println("Erro in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected erro!");
		}		
		
		sc.close();
	}

}
