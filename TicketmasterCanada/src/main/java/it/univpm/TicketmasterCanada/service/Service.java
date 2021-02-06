/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import java.util.Vector;

import org.json.JSONObject;

import it.univpm.TicketmasterCanada.model.*;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public interface Service {
	
		public abstract EventVector getCountryEventsFromAPI (String countryCode);
		public abstract EventVector getStateEventsFromAPI (String stateCode);
		public abstract EventVector getMarketEventsFromAPI (String marketCode);
		public abstract EventVector getSourceEventsFromAPI(String source);
		public abstract EventVector getCountrySourceEventsFromAPI(String source, String countryCode);
		
		public abstract JSONObject getCountryEvents(String countryCode);
		public abstract JSONObject getStateEvents(String stateCode);
		public abstract JSONObject getMarketEvents(String marketID);
		public abstract JSONObject getSourceEvents(String source);
		public abstract JSONObject getCountrySourceEvents(String source, String countryCode);
		
		public abstract Vector<Event> vectorFiller(JSONObject object);
}


