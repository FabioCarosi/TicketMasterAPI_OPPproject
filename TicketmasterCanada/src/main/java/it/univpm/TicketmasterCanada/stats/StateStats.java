/**
 * 
 */
package it.univpm.TicketmasterCanada.stats;

import org.json.JSONObject;
import it.univpm.TicketmasterCanada.service.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class StateStats {

	ServiceImplementation serviceImplementation;
	StatsImplementation stats; 

	public String totalStateEvents(String stateCode) {

		JSONObject stateObj = serviceImplementation.getStateEvents(stateCode);
		JSONObject pageObject = stateObj.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		return "Eventi totali in " + stateCode + ": " + totalElements;
	}

/*	public String totalSourceEvents(String stateCode, String param) {

		JSONObject stateObj = serviceImplementation.getStateEvents(stateCode);
		// Il JSONObject va filtrato qui
		JSONObject pageObject = stateObj.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		return "Eventi in " + stateCode + "per il  source " + param + ": " + totalElements;
	}
*/
	
	/**
	 * public String totalGenreEvents(String stateCode, String param) {
	 * 
	 * JSONObject stateObj = serviceImplementation.getStateEvents(stateCode); // Il
	 * JSONObject va filtrato qui JSONObject pageObject =
	 * stateObj.getJSONObject("page"); int totalElements =
	 * pageObject.getInt("totalElements");
	 * 
	 * return "Eventi in " + stateCode + "per il genere " + param + ": " +
	 * totalElements; }
	 */
	
	public JSONObject totalGenreEvents(String stateCode, String param) {

		JSONObject stateObj = stats.getGenreEvents(stateCode, param, 1);
	    JSONObject pageObject = stateObj.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		return stateObj;
	}

}
