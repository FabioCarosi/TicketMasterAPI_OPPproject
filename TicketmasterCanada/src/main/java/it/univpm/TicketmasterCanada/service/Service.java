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
	
		public abstract EventVector getEventsFromAPI (String code);
		
		public abstract EventVector getStateEventsFromAPI (String stateCode);
		public abstract EventVector getMarketEventsFromAPI (String marketCode);
		public abstract EventVector getSourceEventsFromAPI(String source);
		
		public abstract JSONObject getEvents(String code);
		
		public abstract JSONObject getStateEvents(String stateCode);
		public abstract JSONObject getMarketEvents(String marketID);
		public abstract JSONObject getSourceEvents(String source);
		
		public abstract Vector<Event> vectorFiller(JSONObject object);
}


