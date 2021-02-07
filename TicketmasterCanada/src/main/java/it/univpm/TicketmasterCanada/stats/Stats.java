/**
 * 
 */
package it.univpm.TicketmasterCanada.stats;

import org.json.JSONObject;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public interface Stats {
	
	public abstract JSONObject getSegmentEvents (String countryCode);
	public abstract JSONObject getGenreEvents (String countryCode);
	public abstract JSONObject getSubGenreEvents (String countryCode);
	public abstract JSONObject getSourceEvents (String countryCode);
	public abstract JSONObject getMarketEvents (String marketID);
	

	
}
