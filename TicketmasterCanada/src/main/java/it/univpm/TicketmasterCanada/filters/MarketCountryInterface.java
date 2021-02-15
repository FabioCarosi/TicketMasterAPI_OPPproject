/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;

import it.univpm.TicketmasterCanada.exception.WrongStateException;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

/**
 * Interfaccia che contiene i metodi per il filtraggio deli eventi per country o per market
 */
public interface MarketCountryInterface {
	
	public abstract JSONArray periodMarketCountry(Vector<String> market_country, int period) throws WrongStateException;
	
}
