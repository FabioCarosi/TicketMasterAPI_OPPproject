/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class Genre {


	private String segmentName;		//tipologia dell'evento(es. Sport)
	private String genreName;		//nome del genere dell'evento(es. Golf)
	private String subGenreName;	//nome della manifestazione (es. Red Cup)
	
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
	 * Costruttore completo.
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre(String segmentName, String genreName, String subGenreName) {
		super();
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}

	/**
	 * Costruttore vuoto.
	 */
	public Genre() {
		super();
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = null;
	}

	/**
	 * Costruttore con parametro:
	 * @param segmentName
	 */
	public Genre(String segmentName) {
		super();
		this.segmentName = segmentName;
		this.genreName = null;
		this.subGenreName = null;
	}

	/**
	 * Costruttore con parametri:
	 * @param segmentName
	 * @param genreName
	 */
	public Genre(String segmentName, String genreName) {
		super();
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = null;
	}
	
	/**
	 * Override del metodo toString.
	 * @return una String con tutte le informazioni dell'evento.
	 */
	@Override
	public String toString() {
		return "segmentName=" + segmentName + ", genreName=" + genreName + ", subGenreName=" 
				+ subGenreName + "";
	}
	
	
	/**
	 * Override del metodo equals.		
	 * @param oggetto Genre da confrontare.
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
		Genre other = (Genre) obj;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (segmentName == null) {
			if (other.segmentName != null)
				return false;
		} else if (!segmentName.equals(other.segmentName))
			return false;
		if (subGenreName == null) {
			if (other.subGenreName != null)
				return false;
		} else if (!subGenreName.equals(other.subGenreName))
			return false;
		return true;
	}

}
