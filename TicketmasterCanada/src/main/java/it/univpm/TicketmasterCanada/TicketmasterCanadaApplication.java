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

		Booster save = new Booster();
		save.salvaBooster();
	}

}
