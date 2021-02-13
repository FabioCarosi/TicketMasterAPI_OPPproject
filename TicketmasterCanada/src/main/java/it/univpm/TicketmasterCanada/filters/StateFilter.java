/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.stats.Stats;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class StateFilter implements MarketCountryInterface{
	Stats stats;
	
	public JSONArray periodMarketCountry(Vector<String> states, int period) {
	
        JSONArray stateEvents = new JSONArray();
				
		Iterator<String> it = states.iterator();
		
		int i = 0;
		
		String maxState = null;
		String minState = null;
		int maxEvent = 0;
		int minEvent = 999999;
				
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getStateEvents(it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("state: ", states.get(i));
			couple.put("totalEvents: ", totalElements);
			
			stateEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minState = states.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;
				
			}
		
		JSONObject maxStateEvents = new JSONObject();
		maxStateEvents.put("State with most events: ", maxState);
		maxStateEvents.put("totalEvents: ", maxEvent);
		JSONObject minStateEvents = new JSONObject();
		minStateEvents.put("State with least events: ", minState);
		minStateEvents.put("totalEvents: ", minEvent);
		
		stateEvents.put(maxStateEvents);
		stateEvents.put(minStateEvents);
		
		return stateEvents;
		
	 }

}