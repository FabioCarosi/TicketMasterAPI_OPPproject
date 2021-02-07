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
	
	public abstract JSONObject getCountryEvents(String countryCode, int period);
	public abstract JSONObject getStateEvents(String stateCode, int period);
	public abstract JSONObject getMarketEvents(String stateCode, int period);
	public abstract JSONObject getSourceEvents(String stateCode, String source, int period);
	public abstract JSONObject getSegmentEvents(String stateCode, String segment, int period);
	public abstract JSONObject getGenreEvents(String stateCode, String genre, int period);
	public abstract JSONObject getSubGenreEvents(String stateCode, String subgenre, int period);

	
}
