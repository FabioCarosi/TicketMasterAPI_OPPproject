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
public class Country {
	
	private String countryCode;
	private String countryName;
	
	private Vector<Venue> venuesArray = new Vector<Venue>(); //contiene le informazioni del posto

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the venuesArray
	 */
	public Vector<Venue> getVenuesArray() {
		return venuesArray;
	}

	/**
	 * @param venuesArray the venuesArray to set
	 */
	public void setVenuesArray(Vector<Venue> venuesArray) {
		this.venuesArray = venuesArray;
	}

	/**
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
	 * 
	 */
	public Country() {
		super();
	}

	/**
	 * @param countryCode
	 */
	public Country(String countryCode) {
		super();
		this.countryCode = countryCode;
	}

	/**
	 * @param countryCode
	 * @param countryName
	 */
	public Country(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
	}
	
	


}
