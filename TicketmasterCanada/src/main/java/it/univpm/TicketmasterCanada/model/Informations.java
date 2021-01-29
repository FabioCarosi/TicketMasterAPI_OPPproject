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
	 * @param source
	 */
	public Informations(String currency, double minPrince, double maxPrice, String source) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
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
		this.source = null;
	}

	/**
	 * Override del metodo toString.
	 * @return una String con tutte le informazioni dell'evento.
	 */
	@Override
	public String toString() {
		return "currency=" + currency + ", minPrince=" + minPrince + ", maxPrice=" + maxPrice
				+ ", source=" + source;
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
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrince) != Double.doubleToLongBits(other.minPrince))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	/**
	 * Costruttore con paremetro:
	 * @param source
	 */
	public Informations(String source) {
		super();
		this.currency = null;
		this.minPrince = 0.0;
		this.maxPrice = 0.0;
		this.source = source;
	}
	
}
