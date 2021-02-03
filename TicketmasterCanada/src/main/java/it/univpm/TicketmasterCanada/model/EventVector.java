package it.univpm.TicketmasterCanada.model;

import java.util.Vector;

import org.json.JSONObject;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class EventVector {
	
	Vector<Event> vector = new Vector<Event>();
	String code;
	JSONObject object;

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
	 * @return the object
	 */
	public JSONObject getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(JSONObject object) {
		this.object = object;
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

	/**
	 * @param object
	 */
	public EventVector(JSONObject object) {
		super();
		this.object = object;
	}

	/**
	 * @param vector
	 * @param code
	 * @param object
	 */
	public EventVector(Vector<Event> vector, String code, JSONObject object) {
		super();
		this.vector = vector;
		this.code = code;
		this.object = object;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventVector other = (EventVector) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "vector=" + vector + ", code=" + code + ", object=" + object;
	}

	
	
	
	
	
	
}
