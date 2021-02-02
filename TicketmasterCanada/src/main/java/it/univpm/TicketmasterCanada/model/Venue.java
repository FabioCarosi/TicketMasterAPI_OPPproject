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
	
	City city;
	State state;
	Market market;
	Country country;
	
	private Vector<Event> vectorEvent = new Vector<Event>();

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}

	/**
	 * @param market the market to set
	 */
	public void setMarket(Market market) {
		this.market = market;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the vectorEvent
	 */
	public Vector<Event> getVectorEvent() {
		return vectorEvent;
	}

	/**
	 * @param vectorEvent the vectorEvent to set
	 */
	public void setVectorEvent(Vector<Event> vectorEvent) {
		this.vectorEvent = vectorEvent;
	}

	/**
	 * 
	 */
	public Venue() {
		super();
	}

	/**
	 * @param city
	 */
	public Venue(City city) {
		super();
		this.city = city;
	}

	/**
	 * @param state
	 */
	public Venue(State state) {
		super();
		this.state = state;
	}

	/**
	 * @param market
	 */
	public Venue(Market market) {
		super();
		this.market = market;
	}

	/**
	 * @param country
	 */
	public Venue(Country country) {
		super();
		this.country = country;
	}

	/**
	 * @param vectorEvent
	 */
	public Venue(Vector<Event> vectorEvent) {
		super();
		this.vectorEvent = vectorEvent;
	}

	/**
	 * @param city
	 * @param state
	 * @param market
	 * @param country
	 * @param vectorEvent
	 */
	public Venue(City city, State state, Market market, Country country, Vector<Event> vectorEvent) {
		super();
		this.city = city;
		this.state = state;
		this.market = market;
		this.country = country;
		this.vectorEvent = vectorEvent;
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (vectorEvent == null) {
			if (other.vectorEvent != null)
				return false;
		} else if (!vectorEvent.equals(other.vectorEvent))
			return false;
		return true;
	}
	/**
     * Metodo che scrive il vettore come una stringa.
     * @return String toReturn che rappresenta le previsioni meteo.
     */
	public String VectorString() {
		String Stringa="";
		for (int i=0; i<vectorEvent.size(); i++)
			Stringa += vectorEvent.get(i).toString();
		return Stringa;
	}

	@Override
	public String toString() {
		return "Venue [city=" + city + ", state=" + state + ", market=" + market + ", country=" + country
				+ ", vectorEvent=" + VectorString() + "]";
	}
	
	

	

}