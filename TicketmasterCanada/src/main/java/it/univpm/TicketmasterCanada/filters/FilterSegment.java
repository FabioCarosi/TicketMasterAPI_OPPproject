/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;
import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.stats.StateStats;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class FilterSegment {
	
	StateStats stats = new StateStats();
	
	public JSONArray oneMonth(Vector<String> states, String value) {
		return filterFiller(states, value);
	}
	
	public JSONArray threeMonth(Vector<String> states, String value) {
		return filterFiller(states, value);
	}
	
	public JSONArray sixMonth(Vector<String> states, String value) {
		return filterFiller(states, value);
	}
	
	public JSONArray oneYear(Vector<String> states, String value) {
		return filterFiller(states, value);
	}
	
	public JSONArray filterFiller(Vector<String> states, String value) {
		
		JSONArray array = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> coupleObject = new Vector<JSONObject>();
		
		Iterator<String> iter = states.iterator();
		
		int j = 0;
		String max = null;
		String min = null;
		int maxevent = 0;
		int minevent = 9999;
		

		while(iter.hasNext()) {
			JSONObject obj = new JSONObject();
			obj = stats.totalGenreEvents(iter.next(), value);
			countryVector.add(obj);	
			int totalElements = obj.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("State: ", states.get(j));
			couple.put("Total elements: ", totalElements);
			coupleObject.add(couple);
			array.put(couple);
			if(totalElements <= minevent) {
				minevent = totalElements;
				min = states.get(j);
			}
			if(totalElements >= maxevent) {
				maxevent = totalElements;
				max = states.get(j);
			}
			
			j++;
		}
		
		JSONObject highest = new JSONObject();
		JSONObject lower = new JSONObject();
		highest.put("Stato con il maggior numero di eventi: ", max);
		highest.put("Numero di eventi: ", maxevent);
		lower.put("Stato con il minor numero di eventi: ", min);
		lower.put("Numero di eventi: ", minevent);
		array.put(highest);
		array.put(lower);
			
		return array;
		
	}
}
