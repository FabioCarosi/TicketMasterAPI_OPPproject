package it.univpm.TicketmasterCanada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.TicketmasterCanada.files.*;

/**
 * 
 * @author Mattia Girolami
 * @author Fabio Carosi
 * 
 */
@SpringBootApplication
public class TicketmasterCanadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketmasterCanadaApplication.class, args);
		

		/* Una volta avviato il programma, salverà su una serie di file gli eventi più rilevanti per tipologia relativi
		 * a tutti i paesi del Canada, richiamando il metodo salvaBooster della classe Booster.
		 */	
		Booster save = new Booster();
		save.salvaBooster();
	}

}
