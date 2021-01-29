package it.univpm.TicketmasterCanada.model;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class Event {
	
	private String id;
	private String name;
	private String url;
	private String info;
	
	private Date date;
	private Informations informations;
	private Venue venue;
	private Genre genre;

	
	/**
	 * Costruttore vuoto
	 */
	public Event() {
		super();
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.informations = null;
		this.venue = null;
		this.genre = null;
	}
	
	
	/**
	 * Costruttore completo:
	 * @param id
	 * @param name
	 * @param url
	 * @param info
	 * @param date
	 * @param informations
	 * @param venue
	 * @param genre
	 */
	public Event(String id, String name, String url, String info, Date date, Informations informations, Venue venue,
			Genre genre) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
		this.date = date;
		this.informations = informations;
		this.venue = venue;
		this.genre = genre;
	}

	
	/**
	 * Costrutture con parametro:
	 * @param name
	 */
	public Event(String name) {
		super();
		this.name = name;
		this.id = null;
		this.url = null;
		this.info = null;
	}

	
	/**
	 * Costruttore con parametri: 
	 * @param id
	 * @param name
	 */
	public Event(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.url = null;
		this.info = null;
	}


	/**
	 * Costruttore con parametri:
	 * @param id
	 * @param name
	 * @param url
	 * @param info
	 */
	public Event(String id, String name, String url, String info) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the informations
	 */
	public Informations getInformations() {
		return informations;
	}


	/**
	 * @param informations the informations to set
	 */
	public void setInformations(Informations informations) {
		this.informations = informations;
	}


	/**
	 * @return the venue
	 */
	public Venue getVenue() {
		return venue;
	}


	/**
	 * @param venue the venue to set
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
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
	 * @return the url
	 */
	
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	
	/**
	 * Override del metodo toString
	 */
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", url=" + url + ", info=" + info + ", date=" + date
				+ ", informations=" + informations + ", venue=" + venue + ", genre=" + genre;
	}

	/**
	 * Override del metodo equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (informations == null) {
			if (other.informations != null)
				return false;
		} else if (!informations.equals(other.informations))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		return true;
	}

}
