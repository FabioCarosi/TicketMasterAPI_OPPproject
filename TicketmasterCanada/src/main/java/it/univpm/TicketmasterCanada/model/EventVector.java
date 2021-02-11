package it.univpm.TicketmasterCanada.model;

import java.util.Vector;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class EventVector {
	
	private int eventsNumber;
	private int showedEvents;
	
	Vector<Event> vector = new Vector<Event>();

	/**
	 * @return the vector
	 */
	public Vector<Event> getVector() {
		return vector;
	}

	/**
	 * @param vector the vector to set
	 */
	public void setVector(Vector<Event> vector) {
		this.vector = vector;
	}

	/**
	 * @param vector
	 */
	public EventVector(Vector<Event> vector) {
		super();
		this.vector = vector;
	}
	
	/**
	 * @param vector
	 */
	public EventVector() {
		super();
	}

	/**
	 * @return the eventsNumber
	 */
	public int getEventsNumber() {
		return eventsNumber;
	}

	/**
	 * @param eventsNumber the eventsNumber to set
	 */
	public void setEventsNumber(int eventsNumber) {
		this.eventsNumber = eventsNumber;
	}

	/**
	 * @return the showedEvents
	 */
	public int getShowedEvents() {
		return showedEvents;
	}

	/**
	 * @param showedEvents the showedEvents to set
	 */
	public void setShowedEvents(int showedEvents) {
		this.showedEvents = showedEvents;
	}

	
	
	

	
}
