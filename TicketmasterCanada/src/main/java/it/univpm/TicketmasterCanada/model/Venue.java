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

	
	private String name; //rappresenta il nome della località
	private String address; //rappresenta l'indirizzo dove si svolge l'evento
	private String stateCode; //rappresenta l'abbreviazione del territorio (es. AB, MB...)
	private String stateName; //rappresenta il nome del territorio (es. Alberta, Manitoba...)
	private String cityName; //rappresenta il nome della città (es. Edmonton, Winnipeg)
	private String countryName; //rappresenta il nome dello Stato (es. Canada)
	private String countryCode; //rappresenta l'abbreviazione dello Stato (es. CA)
	private Vector<Event> eventArray = new Vector<Event>(); //contiene le informazioni essenziali di un evento in ua città
	
	
	/**
	 * Metodo che restituisce il nome della località;
	 * @return String name;
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo che setta il nome della località.
	 * @param String name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo che restituisce il nome dell'indirizzo.
	 * @return String address;
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Metodo che setta il nome dell'indirizzo.
	 * @param String address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Metodo che restituisce l'abbreviazione dello Stato;
	 * @return String stateCode;
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Metodo che setta l'abbreviazione del Territorio.
	 * @param String stateCode.
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Metodo che restituisce il nome del Territorio;
	 * @return String stateName;
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Metodo che setta il nome dello Stato.
	 * @param String segmentName.
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Metodo che restituisce il nome della citta';
	 * @return String cityName;
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Metodo che setta il nome della citta'.
	 * @param String cityName.
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * Metodo che restituisce il nome dello Stato;
	 * @return String countryName;
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Metodo che setta il nome dello Stato.
	 * @param String cuntryName.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Metodo che restituisce l'abbreviazione dello Stato;
	 * @return String countryCode;
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Metodo che setta l'abbreviazione dello Stato.
	 * @param String countryCode.
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	/**
	 * Metodo che restituisce il vettore di eventi;
	 * @return the vector
	 */
	public Vector<Event> getVector() {
		return eventArray;
	}

	/**
	 * Metodo che setta il vettore di eventi. 
	 * @param vector the vector to set
	 */
	public void setVector(Vector<Event> vector) {
		this.eventArray = vector;
	}
	
	
	/**
	 * Costruttore vuoto
	 */
	public Venue() {
		super();
		this.name = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.cityName = null;
		this.countryCode = null;
		this.countryName = null;
		//this.eventArray = null;
	}

	

	/**
	 * Construttore con tutti i parametri:
	 * @param name
	 * @param address
	 * @param stateCode
	 * @param stateName
	 * @param cityName
	 * @param countryName
	 * @param countryCode
	 */
	public Venue(String name, String address, String stateCode, String stateName, String cityName, String countryName,
			String countryCode) {
		super();
		this.name = name;
		this.address = address;
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.cityName = cityName;
		this.countryName = countryName;
		this.countryCode = countryCode;
	}

	/**
	 * Costruttore con parametro:
	 * @param cityName
	 */
	public Venue(String cityName) {
		super();
		this.cityName = cityName;
		this.name = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.countryCode = null;
		this.countryName = null;
		//this.eventArray = null;
	}

	/**
	 * Costruttore con parametri: 
	 * @param stateName
	 * @param cityName
	 */
	public Venue(String stateName, String cityName) {
		super();
		this.stateName = stateName;
		this.cityName = cityName;
		this.name = null;
		this.address = null;
		this.stateCode = null;
		this.countryCode = null;
		this.countryName = null;
		//this.eventArray = null;
	}

	/**
	 * Costruttore con parametri:
	 * @param stateName
	 * @param cityName
	 * @param countryName
	 */
	public Venue(String stateName, String cityName, String countryName) {
		super();
		this.stateName = stateName;
		this.cityName = cityName;
		this.countryName = countryName;
		this.name = null;
		this.address = null;
		this.stateCode = null;
		this.countryCode = null;
		//this.eventArray = null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		
		return true;
	}
	
	/**
     * Metodo che scrive il vettore come una stringa.
     * @return String toReturn che rappresenta gli eventi.
     */
	public String toStringVector() {
		String toReturn="";
		for (int i=0; i<eventArray.size(); i++)
			toReturn += eventArray.get(i).toString();
		return toReturn;
	}

	/**
	 * Override del metodo toString.
	 * @return String che rappresenta l'evento.
	 */
	@Override
	public String toString() {
		return "cityName= " + cityName +", name= " + name + ", address= " + address + ", stateName= " + stateName + ", stateCode= " + stateCode
				+ ", countryName= " + countryName + ", countryCode= " + countryCode + ", eventArray=" + toStringVector()+ ""; 
	}

}