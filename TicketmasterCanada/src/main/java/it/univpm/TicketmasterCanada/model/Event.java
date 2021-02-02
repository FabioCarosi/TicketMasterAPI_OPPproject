package it.univpm.TicketmasterCanada.model;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class Event {
	
	private String id;			//codice che identifica univocamente l'evento
	private String name;		//nome dell'evento
	private String url;			//url Ticketmaster corrispondente all'evento
	private String info;		//informazioni sull'evento
	
	private Date date;
	private Informations informations;
	private Genre genre;
	private Venue venue;

	
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
		this.genre = null;
		this.venue = null;
	}
	
	
	
	/**
	 * Costruttore completo con parametri:
	 * @param id
	 * @param name
	 * @param url
	 * @param info
	 * @param date
	 * @param informations
	 * @param genre
	 * @param venue
	 */
	public Event(String id, String name, String url, String info, Date date, Informations informations, Genre genre,
			Venue venue) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
		this.date = date;
		this.informations = informations;
		this.genre = genre;
		this.venue = venue;
	}
	
	

	/**
	 * Costruttore con parametro:
	 * @param venue
	 */
	public Event(Venue venue) {
		super();
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.informations = null;
		this.genre = null;
		this.venue = venue;
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
	 * Costruttore con parametri:
	 * @param date
	 * @param informations
	 * @param genre
	 */
	public Event(Date date, Informations informations, Genre genre) {
		super();
		this.date = date;
		this.informations = informations;
		this.genre = genre;
		this.venue = null;
	}
	
	/**
	 * Metodo che ritorna il:
	 * @return the venue
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Metodo che setta il:
	 * @param venue the venue to set
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * Metodo che restituisce la data.
	 * @return Date date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * Metodo che setta la data.
	 * @param Date date 
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Metodo che restituisce le informazioni.
	 * @return Informations informations
	 */
	public Informations getInformations() {
		return informations;
	}

	/**
	 * Metodo che setta le informazioni.
	 * @param Informations informations
	 */
	public void setInformations(Informations informations) {
		this.informations = informations;
	}


	/**
	 * Metodo che restituisce il genere
	 * @return Genre genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Metodo che setta il genere.
	 * @param Genre genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * Metodo che restituisce l'ID
	 * @return String id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Metodo che setta l'id
	 * @param Id id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Metodo che restituisce il nome.
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo che setta il name dell'evento.
	 * @param Name name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo che restituisce l'url.
	 * @return String url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Metodo che setta l'url.
	 * @param Url url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Metodo che restituisce le informazioni.
	 * @return String info
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * Metodo che setta le info.
	 * @param Info info
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
				+ ", informations=" + informations + ", genre=" + genre + ", venue=" + venue ;
	}

	/**
	 * Override del metodo equals.
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
