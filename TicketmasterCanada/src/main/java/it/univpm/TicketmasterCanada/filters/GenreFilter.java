/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;
/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class GenreFilter {
	
	Stats stats = new StatsImplementation();
	
	public JSONArray Period(Vector<String> states, String genre, int period) {
JSONArray genreEvents = new JSONArray();
		
		Iterator<String> it = states.iterator();
		
		int i = 0;
		
		String maxState = null;
		String minState = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(it.next(), genre, period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("country: ", states.get(i));
			couple.put("totalEvents: ", totalElements);
			genreEvents.put(couple);
			
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
		maxStateEvents.put("Country with most events: ", maxState);
		maxStateEvents.put("totalEvents: ", maxEvent);
		JSONObject minStateEvents = new JSONObject();
		minStateEvents.put("Country with least events: ", minState);
		minStateEvents.put("totalEvents: ", minEvent);
		
		genreEvents.put(maxStateEvents);
		genreEvents.put(minStateEvents);
		
		return genreEvents;
	}
	
}
