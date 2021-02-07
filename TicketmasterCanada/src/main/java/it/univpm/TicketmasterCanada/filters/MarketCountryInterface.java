/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public interface MarketCountryInterface {
	
	public abstract JSONArray OneMonthCountryMarket(Vector<String> market_country);
	public abstract JSONArray ThreeMonthsCountryMarket(Vector<String> market_country);
	public abstract JSONArray SixMonthsCountryMarket(Vector<String> market_country);
	public abstract JSONArray NineMonthsCountryMarket(Vector<String> market_country);
	public abstract JSONArray OneYearCountryMarket(Vector<String> market_country);
}
