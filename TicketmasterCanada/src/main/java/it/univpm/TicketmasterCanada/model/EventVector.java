package it.univpm.TicketmasterCanada.model;

import java.util.Vector;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class EventVector {
	
	private int eventsNumber;		//numero totale di eventi 
	private int showedEvents;		//numero di eventi mostrati
	
	Vector<Event> vector = new Vector<Event>();

	/**
	 * Ritorna il vector
	 * @return the vector
	 */
	public Vector<Event> getVector() {
		return vector;
	}

	/**
	 * Setta il vector.
	 * @param vector the vector to set
	 */
	public void setVector(Vector<Event> vector) {
		this.vector = vector;
	}

	/**
	 * Costruttore con parametro:
	 * @param vector
	 */
	public EventVector(Vector<Event> vector) {
		super();
		this.vector = vector;
	}
	
	/**
	 * Costruttore vuoto.
	 */
	public EventVector() {
		super();
	}

	/**
	 * Ritorna l'eventsNumber
	 * @return eventsNumber
	 */
	public int getEventsNumber() {
		return eventsNumber;
	}

	/**
	 * Setta l'eventsNumber
	 * @param eventsNumber
	 */
	public void setEventsNumber(int eventsNumber) {
		this.eventsNumber = eventsNumber;
	}

	/**
	 * Ritorna gli showedEvents
	 * @return showedEvents
	 */
	public int getShowedEvents() {
		return showedEvents;
	}

	/**
	 * Setta showedEvents
	 * @param showedEvents
	 */
	public void setShowedEvents(int showedEvents) {
		this.showedEvents = showedEvents;
	}
	
}
