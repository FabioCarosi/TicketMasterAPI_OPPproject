package it.univpm.TicketmasterCanada.model;

import java.util.Vector;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class EventVector {
	
	Vector<Event> vector = new Vector<Event>();
	String code;

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @param vector
	 * @param code
	 */
	public EventVector(Vector<Event> vector, String code) {
		super();
		this.vector = vector;
		this.code = code;
	}
	
	/**
	 * @param vector
	 * @param code
	 */
	public EventVector() {
		super();
		this.vector = null;
		this.code = null;
	}
	
	/**
	 * @param vector
	 */
	public EventVector(Vector<Event> vector) {
		super();
		this.vector = vector;
		this.code = null;
	}
	
	/**
	 * @param code
	 */
	public EventVector(String code) {
		super();
		this.vector = null;
		this.code = code;
	}
	
	
	
}
