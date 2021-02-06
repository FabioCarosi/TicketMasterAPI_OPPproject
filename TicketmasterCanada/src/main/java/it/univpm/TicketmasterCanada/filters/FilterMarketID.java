/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;

import it.univpm.TicketmasterCanada.stats.StateStats;
/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class FilterMarketID {
	
	StateStats stats = new StateStats();
	
	public JSONArray oneMonth(Vector<String> states, String value) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value);
	}
	
	public JSONArray threeMonth(Vector<String> states, String value) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value);
	}
	
	public JSONArray sixMonth(Vector<String> states, String value) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value);
	}
	
	public JSONArray oneYear(Vector<String> states, String value) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value);
	}
	
}
