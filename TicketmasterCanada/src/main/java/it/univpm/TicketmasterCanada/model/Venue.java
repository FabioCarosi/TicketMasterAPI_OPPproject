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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	 * @return the vector
	 */
	public Vector<Event> getVector() {
		return eventArray;
	}

	/**
	 * @param vector the vector to set
	 */
	public void setVector(Vector<Event> vector) {
		this.eventArray = vector;
	}
	
	
	
	public Venue() {
		// TODO Auto-generated constructor stub
	}

	

	/**
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
	 * @param cityName
	 */
	public Venue(String cityName) {
		super();
		this.cityName = cityName;
	}

	/**
	 * @param stateName
	 * @param cityName
	 */
	public Venue(String stateName, String cityName) {
		super();
		this.stateName = stateName;
		this.cityName = cityName;
	}

	/**
	 * @param stateName
	 * @param cityName
	 * @param countryName
	 */
	public Venue(String stateName, String cityName, String countryName) {
		super();
		this.stateName = stateName;
		this.cityName = cityName;
		this.countryName = countryName;
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