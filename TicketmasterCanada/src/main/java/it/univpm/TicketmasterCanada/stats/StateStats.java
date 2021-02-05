/**
 * 
 */
package it.univpm.TicketmasterCanada.stats;

import org.json.JSONObject;
import it.univpm.TicketmasterCanada.service.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */

public class StateStats {
	
	ServiceImplementation serviceImplementation;
	
	public String TotalStateEvents(String stateCode) {
		
		JSONObject stateObj = serviceImplementation.getStateEvents(stateCode);
		JSONObject pageObject = stateObj.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		return "Eventi totali:" + totalElements;
	}
	
	
	



	public StateStats() {
		// TODO Auto-generated constructor stub
	}

}
