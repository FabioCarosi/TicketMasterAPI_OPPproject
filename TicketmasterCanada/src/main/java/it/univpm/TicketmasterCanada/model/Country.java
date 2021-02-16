package it.univpm.TicketmasterCanada.model;

import java.util.Vector;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class Country {
	
	private String countryCode;
	private String countryName;
	
	private Vector<Venue> venuesArray = new Vector<Venue>(); 	//contiene le informazioni del posto in cui si svolge l'evento

	/**
	 * Ritorna il countryCode
	 * @return countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Setta il countryCode
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Ritorna il countryName
	 * @return countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Setta il countryName
	 * @param countryName
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Ritorna il venuesArray
	 * @return venuesArray
	 */
	public Vector<Venue> getVenuesArray() {
		return venuesArray;
	}

	/**
	 * Setta il venuesArray
	 * @param venuesArray 
	 */
	public void setVenuesArray(Vector<Venue> venuesArray) {
		this.venuesArray = venuesArray;
	}

	/**
	 * Costruttore con parametri:
	 * @param countryCode
	 * @param countryName
	 * @param venuesArray
	 */
	public Country(String countryCode, String countryName, Vector<Venue> venuesArray) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.venuesArray = venuesArray;
	}

	/**
	 * Costruttore vuoto
	 */
	public Country() {
		super();
	}

	/**
	 * Costruttore con parametro:
	 * @param countryCode
	 */
	public Country(String countryCode) {
		super();
		this.countryCode = countryCode;
	}

	/**
	 * Costruttore con parametri:
	 * @param countryCode
	 * @param countryName
	 */
	public Country(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
	}
	
	


}
