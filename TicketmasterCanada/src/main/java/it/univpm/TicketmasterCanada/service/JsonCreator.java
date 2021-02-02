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
	 * Passato un oggetto Venue restituisce il JSONObject
	 * 
	 * @param venue che si vuole trasformare in JSONObject.
	 * @return JSONObject del venue.
	 */
	
	public JSONObject jsonCreator(Venue venue) {
		
		JSONObject object = new JSONObject();
		object.put("address", venue.getAddress());
		object.put("cityName", venue.getCityName());
		object.put("countryCode", venue.getCountryCode());
		object.put("countryName", venue.getCountryName());
		object.put("venueName", venue.getVenueName());
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
			evento.put("minPrice", (venue.getVector()).get(i).getInformations().getMinPrice());
			evento.put("source", (venue.getVector()).get(i).getInformations().getSource());
			evento.put("id", (venue.getVector()).get(i).getId());
			evento.put("info", (venue.getVector()).get(i).getInfo());
			evento.put("name", (venue.getVector()).get(i).getName());
			evento.put("url", (venue.getVector()).get(i).getUrl());
			arr.put(evento);
		}
		
		object.put("Evento", arr );		
		return object;
	}

}
