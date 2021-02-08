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
 * @author mgiro
 *
 */
public class SubGenreComparator implements FilterInterface{
	Stats stats;
	

	public JSONArray OneMonth(Vector<String> subGenres, String country) throws WrongValueException {
		
		JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> subGenreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 1);
			subGenreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;

    }
	

	public JSONArray ThreeMonths(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> subGenreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 3);
			subGenreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
	
	}
	

	public JSONArray SixMonths(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> subGenreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 6);
			subGenreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
		
	}
	

	public JSONArray OneYear(Vector<String> subGenres, String country) throws WrongValueException {
		
        JSONArray subGenreEvents = new JSONArray();
		
		Vector<JSONObject> subGenreVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = subGenres.iterator();
		
		int i = 0;
		
		String maxSubGenre = null;
		String minSubGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(country, it.next(), 12);
			subGenreVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", subGenres.get(i));
			couple.put("totalEvents: ", totalElements);
			subGenreEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSubGenre = subGenres.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subGenres.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("SubGenre with most events: ", maxSubGenre);
		maxSubGenreEvents.put("totalEvents: ", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("SubGenre with least events: ", minSubGenre);
		minSubGenreEvents.put("totalEvents: ", minEvent);
		
		subGenreEvents.put(maxSubGenreEvents);
		subGenreEvents.put(minSubGenreEvents);
		
		return subGenreEvents;
		
	}
 

}
