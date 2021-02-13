/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.stats.Stats;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
/**
 * Questa classe implementa period e contiene i metodi per il filtraggio degli eventi di 
 * un subGenre in base allo Stato e in funzione del periodo su cui si vuole effettuare tale ricerca
 */
public class SubGenreComparator implements FilterInterface{
Stats stats;
	

	public JSONArray period(Vector<String> subgenres, String state, int period) throws WrongValueException {
		
		JSONArray subgenreEvents = new JSONArray();
		
		Iterator<String> it = subgenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubgenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(state, it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("subgenre: ", subgenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subgenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubgenre = subgenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subgenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("Subgenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("subgenre with least events: ", minSubgenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subgenreEvents.put(maxSubGenreEvents);
		subgenreEvents.put(minSubGenreEvents);
		
		return subgenreEvents;

	}
}
