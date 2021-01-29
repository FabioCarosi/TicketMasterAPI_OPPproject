/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

/**
 * @author caros
 *
 */
public class Genre {

	/**
	 * 
	 */
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
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}

}
