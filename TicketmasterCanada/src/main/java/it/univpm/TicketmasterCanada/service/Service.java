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
	
		public abstract Venue getVenueInformationsFromAPI   (String code);
		public abstract Venue getChosenCountryEventsfromApi (String countryCode);
		public abstract JSONObject getStateEvents(String stateCode);
}


