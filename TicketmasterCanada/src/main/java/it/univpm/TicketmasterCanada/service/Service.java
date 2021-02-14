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
		public abstract EventVector getStateSourceEventsFromAPI(String source, String countryCode);
		public abstract EventVector getKeywordEventsFromAPI(String keyword, String stateCode);
		public abstract EventVector getSegmentEventsFromAPI(String segment, String stateCode);
		public abstract EventVector getGenreEventsFromAPI(String genre, String stateCode);
		public abstract EventVector getSubGenreEventsFromAPI(String subgenre, String stateCode);
		
		
		public abstract JSONObject getCountryEvents(String countryCode);
		public abstract JSONObject getStateEvents(String stateCode);
		public abstract JSONObject getMarketEvents(String marketID);
		public abstract JSONObject getSourceEvents(String source);
		public abstract JSONObject getStateSourceEvents(String source, String countryCode);
		public abstract JSONObject getKeywordEvents(String keyword, String stateCode);
		public abstract JSONObject getSegmentEvents(String segment, String stateCode);
		public abstract JSONObject getGenreEvents(String genre, String stateCode);
		public abstract JSONObject getSubGenreEvents(String subgenre, String stateCode);
		
		public abstract Vector<Event> vectorFiller(JSONObject object);
		
}


