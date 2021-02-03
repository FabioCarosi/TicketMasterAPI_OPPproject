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
	
	
	/**
	 * Passato un oggetto Venue restituisce il JSONObject
	 * 
	 * @param venue che si vuole trasformare in JSONObject.
	 * @return JSONObject del venue.
	 */
	
	public JSONObject jsonCreator(EventVector eventVector) {
		
		JSONObject object = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject evento = new JSONObject();
		
		for(int i=0 ; i < (eventVector.getVector()).size(); i++) {
			
			object.put("id", (eventVector.getVector()).get(i).getId());
			//object.put("info", (eventVector.getVector()).get(i).getInfo());
			object.put("name", (eventVector.getVector()).get(i).getName());
			object.put("url", (eventVector.getVector()).get(i).getUrl());
			
			object.put("countryCode", (eventVector.getVector()).get(i).getVenue().getCountry().getCountryCode());
			object.put("countryName", (eventVector.getVector()).get(i).getVenue().getCountry().getCountryName());
			
			object.put("stateCode", (eventVector.getVector()).get(i).getVenue().getState().getStateCode());
			object.put("stateName", (eventVector.getVector()).get(i).getVenue().getState().getStateName());
			
			//object.put("marketName", (eventVector.getVector()).get(i).getVenue().getMarket().getMarketName());
			//object.put("marketID", (eventVector.getVector()).get(i).getVenue().getMarket().getMarketID());
			
			object.put("cityName", (eventVector.getVector()).get(i).getVenue().getCity().getCityName());
			object.put("address", (eventVector.getVector()).get(i).getVenue().getCity().getAddress());
			object.put("venueName", (eventVector.getVector()).get(i).getVenue().getCity().getVenueName());
			
			object.put("data", (eventVector.getVector()).get(i).getDate().getData());
			object.put("orario", (eventVector.getVector()).get(i).getDate().getOrario());
			
			object.put("segment", (eventVector.getVector()).get(i).getGenre().getSegmentName());
			object.put("genre", (eventVector.getVector()).get(i).getGenre().getGenreName());
			object.put("subgenre", (eventVector.getVector()).get(i).getGenre().getSubGenreName());
			
			//object.put("currency", (eventVector.getVector()).get(i).getInformations().getCurrency());
			//object.put("maxPrice", (eventVector.getVector()).get(i).getInformations().getMaxPrice());
			//object.put("minPrice", (eventVector.getVector()).get(i).getInformations().getMinPrice());
			//object.put("source", (eventVector.getVector()).get(i).getInformations().getSource());
			
			arr.put(object);
		}
		
		evento.put("Evento", arr );		
		return evento;
	}

}
