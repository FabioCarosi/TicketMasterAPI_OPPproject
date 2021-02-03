package it.univpm.TicketmasterCanada.model;

import java.util.Vector;

import org.json.JSONObject;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class EventVector {
	
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
	@Override
	public String toString() {
		return "" + vector;
	}
*/	
	
	
	
	

	
}
