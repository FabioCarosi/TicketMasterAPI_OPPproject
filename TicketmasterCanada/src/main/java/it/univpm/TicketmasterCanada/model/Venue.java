package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class Venue {
	
	City city;
	State state;
	Market market;
	Country country;


	/**
	 * Ritorna la città
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Setta la citta'
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Ritorna lo Stato
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Setta lo Stato
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Ritorna il Market
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}

	/**
	 * Setta il Market
	 * @param market the market to set
	 */
	public void setMarket(Market market) {
		this.market = market;
	}

	/**
	 * Ritorna il paese
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Setta il paese
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Costruttore vuoto
	 */
	public Venue() {
		super();
	}

	/**
	 * Costruttore con parametro citta'
	 * @param city
	 */
	public Venue(City city) {
		super();
		this.city = city;
	}

	/**
	 * Costruttore con parametro:
	 * @param state
	 */
	public Venue(State state) {
		super();
		this.state = state;
	}

	/**
	 * Costruttore con parametro:
	 * @param market
	 */
	public Venue(Market market) {
		super();
		this.market = market;
	}

	/**
	 * Costruttore con parametro:
	 * @param country
	 */
	public Venue(Country country) {
		super();
		this.country = country;
	}


	/**
	 * Costruttore con tutti i parametri
	 * @param city
	 * @param state
	 * @param market
	 * @param country
	 */
	public Venue(City city, State state, Market market, Country country) {
		super();
		this.city = city;
		this.state = state;
		this.market = market;
		this.country = country;
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
		return true;
	}

	/**
	 * Override del metodo toString
	 */
	@Override
	public String toString() {
		return "city=" + city + ", state=" + state + ", market=" + market + ", country=" + country;
	}
	
	

	

}