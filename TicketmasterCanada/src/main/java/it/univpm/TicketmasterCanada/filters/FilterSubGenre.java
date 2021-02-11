/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;

import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;
/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class FilterSubGenre {

	Stats stats = new StatsImplementation();	
	
	public JSONArray oneMonth(Vector<String> states, String value, int period) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value, 1);
	}
	
	public JSONArray threeMonths(Vector<String> states, String value, int period) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value, 3);
	}
	
	public JSONArray sixMonths(Vector<String> states, String value, int period) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value, 6);
	}
	
	public JSONArray oneYear(Vector<String> states, String value, int period) {
		Filters filters = new Filters();
		return filters.filterFiller(states, value, 12);
	}
	
}
