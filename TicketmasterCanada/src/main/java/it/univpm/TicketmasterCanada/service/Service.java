/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import org.json.JSONObject;

import it.univpm.TicketmasterCanada.model.*;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public interface Service {
	
		public abstract EventVector getCountryInformationsFromAPI   (String code);
		public abstract Venue getChosenCountryEventsfromApi (String countryCode);
		public abstract JSONObject getStateEvents(String stateCode);
		public abstract Venue getStateEventsfromApi(String stateCode);
}


