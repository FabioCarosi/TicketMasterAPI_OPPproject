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

	private String venueName; //rappresenta il nome della località
	private String address; //rappresenta l'indirizzo dove si svolge l'evento
	private String stateCode; //rappresenta l'abbreviazione del territorio (es. AB, MB...)
	private String stateName; //rappresenta il nome del territorio (es. Alberta, Manitoba...)
	private String cityName; //rappresenta il nome della città (es. Edmonton, Winnipeg)
	private int marketID; //rappresenta l'id di un ampio raggruppamento geografico
	private String marketName; //rappresenta il nome di un ampio raggruppamento geografico
	
	private Vector<Event> eventArray = new Vector<Event>(); //contiene le informazioni essenziali di un evento in una città
	

	/**
	 * Costruttore vuoto
	 */
	public Venue() {
		super();
		this.venueName = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.cityName = null;
		this.marketName = null;
		this.marketID = 0;
		//this.eventArray = null;
	}
	
	

	/**
	 * Costruttore con parametro:
	 * @param marketID
	 */
	public Venue(int marketID) {
		super();
		this.marketID = marketID;
		this.venueName = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.cityName = null;
		this.marketName = null;
		//this.eventArray = null;
	}



	/**
	 * Costruttore con parametri:
	 * @param marketID
	 * @param marketName
	 */
	public Venue(int marketID, String marketName) {
		super();
		this.marketID = marketID;
		this.marketName = marketName;
		this.venueName = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.cityName = null;
		//this.eventArray = null;
	}

	/**
	 * Costruttore con parametro:
	 * @param cityName
	 */
	public Venue(String cityName) {
		super();
		this.cityName = cityName;
		this.venueName = null;
		this.address = null;
		this.stateCode = null;
		this.stateName = null;
		this.marketName = null;
		this.marketID = 0;
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
		this.venueName = null;
		this.address = null;
		this.stateCode = null;
		this.marketName = null;
		this.marketID = 0;
		//this.eventArray = null;
	}
	



	/**
	 * Costruttore con tutti i paramentri
	 * @param venueName
	 * @param address
	 * @param stateCode
	 * @param stateName
	 * @param cityName
	 * @param marketID
	 * @param marketName
	 * @param eventArray
	 */
	public Venue(String venueName, String address, String stateCode, String stateName, String cityName,
			int marketID, String marketName, Vector<Event> eventArray) {
		super();
		this.venueName = venueName;
		this.address = address;
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.cityName = cityName;
		this.marketID = marketID;
		this.marketName = marketName;
		this.eventArray = eventArray;
	}



	/**
	 * Metodo che restituisce il nome della località;
	 * @return String venueName;
	 */
	public String getVenueName() {
		return venueName;
	}

	/**
	 * Metodo che setta il nome della località.
	 * @param String venueName.
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
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
	 * @return the marketID
	 */
	public int getMarketID() {
		return marketID;
	}

	/**
	 * @param marketID the marketID to set
	 */
	public void setMarketID(int marketID) {
		this.marketID = marketID;
	}

	/**
	 * @return the marketName
	 */
	public String getMarketName() {
		return marketName;
	}

	/**
	 * @param marketName the marketName to set
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (eventArray == null) {
			if (other.eventArray != null)
				return false;
		} else if (!eventArray.equals(other.eventArray))
			return false;
		if (marketID != other.marketID)
			return false;
		if (marketName == null) {
			if (other.marketName != null)
				return false;
		} else if (!marketName.equals(other.marketName))
			return false;
		if (venueName == null) {
			if (other.venueName != null)
				return false;
		} else if (!venueName.equals(other.venueName))
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
		return "cityName= " + cityName +", venueName= " + venueName + ", address= " + address + ", stateName= " + stateName + ", stateCode= " + stateCode
				 + ", marketID= " + marketID + ", marketName= " + marketName+ ", eventArray=" + toStringVector()+ ""; 
	}

}