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

public class FilterMarketID {
	Stats stats;

	public JSONArray OneMonthCountryMarket(Vector<String> market_country) {
		JSONArray oneMonth = marketFiller(market_country, 1);
		return oneMonth;
	}

	public JSONArray ThreeMonthsCountryMarket(Vector<String> market_country) {
		JSONArray threeMonths = marketFiller(market_country, 3);
		return threeMonths;
	}


	public JSONArray SixMonthsCountryMarket(Vector<String> market_country) {
		JSONArray sixMonths = marketFiller(market_country, 6);
		return sixMonths;
	}
	
	public JSONArray NineMonthsCountryMarket(Vector<String> market_country) {
		JSONArray nineMonths = marketFiller(market_country, 9);
		return nineMonths;
	}
	
	public JSONArray OneYearCountryMarket(Vector<String> market_country) {
		JSONArray OneYear = marketFiller(market_country, 12);
		return OneYear;
	}

	

	public JSONArray marketFiller(Vector<String> countries, int period) {
		
		JSONArray countryEvents = new JSONArray();
	
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> country_totalEvents = new Vector<JSONObject>();
	
		Iterator<String> it = countries.iterator();
	
		int i = 0;
	
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
	
		while(it.hasNext()) {
	
			JSONObject object = new JSONObject();
			object = stats.getCountryEvents(it.next(), period);
			countryVector.add(object);
			int totalElements = object.getInt("totalEvents");
			totalEvents.add(totalElements);
	
			JSONObject couple = new JSONObject();
			couple.put("Country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			country_totalEvents.add(couple);
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


