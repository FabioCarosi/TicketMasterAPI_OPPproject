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
 */

/** 
 *Implementa MarketCountryInterface e contiene i metodi per filtrare gli eventi in 
 *un paese in funzione del periodo su cui si vuole effettuare tale ricerca
 */
public class CountryFilter implements MarketCountryInterface{
	Stats stats;
	
	public JSONArray periodMarketCountry(Vector<String> countries, int period) {
	
        JSONArray countryEvents = new JSONArray();
				
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
				
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getCountryEvents(it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			
			countryEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		countryEvents.put(maxCountryEvents);
		countryEvents.put(minCountryEvents);
		
		return countryEvents;
		
	 }

}