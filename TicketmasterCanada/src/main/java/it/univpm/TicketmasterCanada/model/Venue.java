/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

import java.util.Vector;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class Venue {

	private String venueName; //rappresenta il nome della località
	private String address; //rappresenta l'indirizzo dove si svolge l'evento
	
	private String cityName; //rappresenta il nome della città (es. Edmonton, Winnipeg)
	
	
	private Vector<Event> eventArray = new Vector<Event>(); //contiene le informazioni essenziali di un evento in una città
	

}