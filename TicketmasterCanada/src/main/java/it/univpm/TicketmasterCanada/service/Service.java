/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import org.json.JSONObject;

import it.univpm.TicketmasterCanada.model.Venue;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public interface Service {

		public abstract JSONObject getStateEvents(String stateCode);
		public abstract JSONObject getCountryEvents(String countryCode);
		public abstract JSONObject getMarketEvents(int marketID);
		public abstract Venue getStateEventsfromApi(String venue);




}


