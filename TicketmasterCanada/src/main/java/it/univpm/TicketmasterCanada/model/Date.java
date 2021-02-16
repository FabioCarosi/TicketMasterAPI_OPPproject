package it.univpm.TicketmasterCanada.model;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class Date {
	
	private String data;
	private String orario;
	
	
	/**
	 * Costruttore con parametri:
	 * @param data
	 * @param orario
	 */
	public Date(String data, String orario) {
		super();
		this.data = data;
		this.orario = orario;
	}
	
	/**
	 * Costruttore vuoto.
	 */
	public Date() {
		super();
	}

	/*
	 * Ritorna la data.
	 */
	public String getData() {
		return data;
	}


	/*
	 * Setta la data.
	 */
	public void setData(String data) {
		this.data = data;
	}


	/*
	 * Ritorna l'orario.
	 */
	public String getOrario() {
		return orario;
	}

	/*
	 * Setta l'orario.
	 */
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	/*
	 * Override del metodo toString:
	 */
	@Override
	public String toString() {
		return data +  "  " + orario;
	}
	
	/*
	 * Override del metodo equals:  
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date date = (Date) obj;
		if (data == null) {
			if (date.data != null)
				return false;
		} else if (!data.equals(date.data))
			return false;
		if (orario == null) {
			if (date.orario != null)
				return false;
		} else if (!orario.equals(date.orario))
			return false;
		
		return true;
	}
}