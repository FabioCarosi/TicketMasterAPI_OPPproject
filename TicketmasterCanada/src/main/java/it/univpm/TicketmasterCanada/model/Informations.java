/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class Informations {

	private String currency;   		//valuta del pagamento
	private double minPrince;   	//prezzo minimo del biglietto
	private double maxPrice;    	//prezzo massimo del biglietto
	private String segmentName;		//tipologia dell'evento(es. Sport)
	private String genreName;		//nome del genere dell'evento(es. Golf)
	private String subGenreName;	//nome della manifestazione (es. Red Cup)
	private String source;			//azienda che si occupa della vendita dei biglietti
	
	
	/**
	 * Metodo che restituisce la valuta.
	 * @return String currency.
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Metodo che setta la valuta.
	 * @param String currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Metodo che restituisce il prezzo minimo.
	 * @return double minPrince.
	 */
	public double getMinPrince() {
		return minPrince;
	}
	
	/**
	 * Metodo che setta il prezzo minimo.
	 * @param double minPrice.
	 */
	public void setMinPrince(double minPrince) {
		this.minPrince = minPrince;
	}
	
	/**
	 * Metodo che restituisce il prezzo massimo.
	 * @return double maxPrice.
	 */
	public double getMaxPrice() {
		return maxPrice;
	}
	
	/**
	 * Metodo che setta il prezzo massimo.
	 * @param double maxPrice. 
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	/**
	 * Metodo che restituisce il nome della categoria;
	 * @return String segmentName;
	 */
	public String getSegmentName() {
		return segmentName;
	}
	
	/**
	 * Metodo che setta il nome della categoria.
	 * @param String segmentName.
	 */
	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}
	
	/**
	 * Metodo che restituisce il genere dell'evento.
	 * @return String genreName.
	 */
	public String getGenreName() {
		return genreName;
	}
	
	/**
	 * Metodo che setta il genere dell'evento.
	 * @param String genreName.
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	/**
	 * Metodo che restituisce il sottogenere dell'evento.
	 * @return String subGenreName.
	 */
	public String getSubGenreName() {
		return subGenreName;
	}
	
	/**
	 * Metodo che setta il sottogenere dell'evento.
	 * @param String subGenreName.
	 */
	public void setSubGenreName(String subGenreName) {
		this.subGenreName = subGenreName;
	}
	
	/**
	 * Metodo che restituisce il rivenditore dei biglietti;
	 * @return String source;
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Metodo che setta il rivenditore dei biglietti;
	 * @param String source;
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Costruttore completo con parametri:
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 * @param source
	 */
	public Informations(String currency, double minPrince, double maxPrice, String segmentName, String genreName,
			String subGenreName, String source) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
		this.source = source;
	}

	/**
	 * Costruttore vuoto
	 */
	public Informations() {
		super();
		this.currency = null;
		this.minPrince = 0.0;
		this.maxPrice = 0.0;
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = null;
		this.source = null;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 */
	public Informations(String currency, double minPrince, double maxPrice) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = null;
		this.source = null;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Informations(String segmentName, String genreName, String subGenreName) {
		super();
		this.currency = null;
		this.minPrince = 0.0;
		this.maxPrice = 0.0;
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
		this.source = null;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param genreName
	 * @param subGenreName
	 */
	public Informations(String genreName, String subGenreName) {
		super();
		this.currency = null;
		this.minPrince = 0.0;
		this.maxPrice = 0.0;
		this.segmentName = null;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
		this.source = null;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param subGenreName
	 */
	public Informations(String subGenreName) {
		super();
		this.currency = null;
		this.minPrince = 0.0;
		this.maxPrice = 0.0;
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = subGenreName;
		this.source = null;
	}
	
	/**
	 * Override del metodo toString.
	 * @return una String con tutte le informazioni dell'evento.
	 */
	@Override
	public String toString() {
		return "currency=" + currency + ", minPrince=" + minPrince + ", maxPrice=" + maxPrice
				+ ", segmentName=" + segmentName + ", genreName=" + genreName + ", subGenreName=" 
				+ subGenreName + ", source=" + source;
	}
	
	/**
	Override del metodo equals.
	 * @param oggetto Informations da confrontare.
	 * @return true se i due oggetti siano uguali, false altrimenti.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Informations other = (Informations) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrince) != Double.doubleToLongBits(other.minPrince))
			return false;
		if (segmentName == null) {
			if (other.segmentName != null)
				return false;
		} else if (!segmentName.equals(other.segmentName))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (subGenreName == null) {
			if (other.subGenreName != null)
				return false;
		} else if (!subGenreName.equals(other.subGenreName))
			return false;
		return true;
	}
	
	
	
	
	
}
