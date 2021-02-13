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

public class MarketIdFilter {
	Stats stats;

	public JSONArray periodMarketCountry(Vector<String> markets, int period) {
		
        JSONArray marketEvents = new JSONArray();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
			marketEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minMarket = markets.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;
				
			}
		
		JSONObject maxMarketEvents = new JSONObject();
		maxMarketEvents.put("Market with most events: ", maxMarket);
		maxMarketEvents.put("totalEvents: ", maxEvent);
		JSONObject minMarketEvents = new JSONObject();
		minMarketEvents.put("Market with least events: ", minMarket);
		minMarketEvents.put("totalEvents: ", minEvent);
		
		marketEvents.put(maxMarketEvents);
		marketEvents.put(minMarketEvents);
		
		return marketEvents;

    }
	
}


