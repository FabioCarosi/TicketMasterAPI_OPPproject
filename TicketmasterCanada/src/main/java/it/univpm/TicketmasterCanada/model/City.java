/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

/**
 * @author caros
 *
 */
public class City {

	private String venueName; //rappresenta il nome della località
	private String address;   //rappresenta l'indirizzo dove si svolge l'evento
	private String cityName;  //rappresenta il nome della città (es. Edmonton, Winnipeg)
	/**
	 * @return the venueName
	 */
	public String getVenueName() {
		return venueName;
	}
	/**
	 * @param venueName the venueName to set
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
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
	 * 
	 */
	public City() {
		super();
	}
	/**
	 * @param cityName
	 */
	public City(String cityName) {
		super();
		this.cityName = cityName;
	}
	/**
	 * @param address
	 * @param cityName
	 */
	public City(String address, String cityName) {
		super();
		this.address = address;
		this.cityName = cityName;
	}
	/**
	 * @param venueName
	 * @param address
	 * @param cityName
	 */
	public City(String venueName, String address, String cityName) {
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
	
	

	@Override
	public String toString() {
		return "City [venueName=" + venueName + ", address=" + address + ", cityName=" + cityName + "]";
	}
	
	
	
	

}
