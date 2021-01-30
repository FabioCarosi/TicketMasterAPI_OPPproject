/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import org.json.JSONObject;
import org.json.JSONArray;
import it.univpm.TicketmasterCanada.model.*;

/**
 * Questa classe ci permette di scrivere un oggetto Venue all'interno di un JSONObject. 
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
		object.put("marketName", venue.getMarketName());
		object.put("marketID", venue.getMarketID());
		
		JSONArray arr = new JSONArray();
		
		for(int i=0 ; i < (venue.getVector()).size(); i++) {
			
			JSONObject evento = new JSONObject();
			evento.put("data", (venue.getVector()).get(i).getDate().getData());
			evento.put("orario", (venue.getVector()).get(i).getDate().getOrario());
			evento.put("segment", (venue.getVector()).get(i).getGenre().getSegmentName());
			evento.put("genre", (venue.getVector()).get(i).getGenre().getGenreName());
			evento.put("subgenre", (venue.getVector()).get(i).getGenre().getSubGenreName());
			evento.put("currency", (venue.getVector()).get(i).getInformations().getCurrency());
			evento.put("maxPrice", (venue.getVector()).get(i).getInformations().getMaxPrice());
			evento.put("minPrice", (venue.getVector()).get(i).getInformations().getMinPrince());
			evento.put("source", (venue.getVector()).get(i).getInformations().getSource());
			arr.put(evento);
		}
		
		object.put("Evento", arr );		
		return object;
	}

}
