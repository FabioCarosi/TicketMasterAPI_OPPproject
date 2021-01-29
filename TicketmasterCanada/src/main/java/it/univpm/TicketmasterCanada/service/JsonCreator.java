/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import org.json.JSONObject;
import org.json.JSONArray;
import it.univpm.TicketmasterCanada.model.*;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class JsonCreator {
	
	Venue venue = new Venue();
	
	/**
	 * Questo metodo restituisce il JSONObject corrispondente all'oggetto City passato in ingresso.
	 * 
	 * @param city città che si vuole come un JSONObject.
	 * @return il JSONObject che rappresenta la città.
	 */
	
	public JSONObject jsonCreator(Venue venue) {
		
		JSONObject object = new JSONObject();
		object.put("address", venue.getAddress());
		object.put("cityName", venue.getCityName());
		object.put("countryCode", venue.getCountryCode());
		object.put("countryName", venue.getCountryName());
		object.put("name", venue.getName());
		object.put("stateCode", venue.getStateCode());
		object.put("stateName", venue.getStateName());
		
		JSONArray arr = new JSONArray();
		
		for(int i=0 ; i < (venue.getVector()).size(); i++) {
			
			JSONObject evento = new JSONObject();
			evento.put("data", (venue.getVector()).get(i).getDate().getData());
			
			
		}
		
		 return object;
	}

}
