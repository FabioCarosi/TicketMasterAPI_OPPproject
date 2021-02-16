package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class City {

	private String venueName; //rappresenta il nome della località
	private String address;   //rappresenta l'indirizzo dove si svolge l'evento
	private String cityName;  //rappresenta il nome della città (es. Edmonton, Winnipeg)
	
	/**
	 * Metodo che restituisce il nome del posto dell'evento
	 * @return the venueName
	 */
	public String getVenueName() {
		return venueName;
	}
	/**
	 * Setta il nome del posto dell'evento
	 * @param venueName the venueName to set
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	/**
	 * Metodo che restituisce l'indirizzo dell'evento
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Setta l'indirizzo dell'evento
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Metodo che restituisce il nome della città dell'evento
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * Setta il nome della citta' dell'evento
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * Costruttore vuoto
	 */
	public City() {
		super();
		this.venueName = null;
		this.address = null;
		this.cityName = null;
	}
	/**
	 * Costruttore con parametro il nome della citta'
	 * @param cityName
	 */
	public City(String cityName) {
		super();
		this.cityName = cityName;
		this.venueName = null;
		this.address = null;
	}
	/**
	 * Cosrtuttore con parametro nome della citta' e indirizzo
	 * @param address
	 * @param cityName
	 */
	public City(String cityName, String address) {
		super();
		this.address = address;
		this.cityName = cityName;
		this.venueName = null;
	}
	/**
	 * costruttore con tutti e tre i parametri
	 * @param venueName
	 * @param address
	 * @param cityName
	 */
	public City(String cityName, String address, String venueName) {
		super();
		this.venueName = venueName;
		this.address = address;
		this.cityName = cityName;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
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
		if (venueName == null) {
			if (other.venueName != null)
				return false;
		} else if (!venueName.equals(other.venueName))
			return false;
		return true;
	}
	
	
	//Ritorna una stringa con tutti gli attributi
	@Override
	public String toString() {
		return "City [venueName=" + venueName + ", address=" + address + ", cityName=" + cityName + "]";
	}
	
	
	
	

}
