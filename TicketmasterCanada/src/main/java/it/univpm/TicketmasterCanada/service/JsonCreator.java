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
		
		
		JSONArray arr = new JSONArray();
		JSONObject evento = new JSONObject();
		
		for(int i=0 ; i < (eventVector.getVector()).size(); i++) {
			JSONObject object = new JSONObject();
			
			try {
				try {
					object.put("id", (eventVector.getVector()).get(i).getId());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("info", (eventVector.getVector()).get(i).getInfo());
				}  catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("name", (eventVector.getVector()).get(i).getName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
				try {
					object.put("url", (eventVector.getVector()).get(i).getUrl());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("countryCode", (eventVector.getVector()).get(i).getVenue().getCountry().getCountryCode());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("countryName", (eventVector.getVector()).get(i).getVenue().getCountry().getCountryName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("stateCode", (eventVector.getVector()).get(i).getVenue().getState().getStateCode());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("stateName", (eventVector.getVector()).get(i).getVenue().getState().getStateName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("marketName", (eventVector.getVector()).get(i).getVenue().getMarket().getMarketName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("marketID", (eventVector.getVector()).get(i).getVenue().getMarket().getMarketID());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("cityName", (eventVector.getVector()).get(i).getVenue().getCity().getCityName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("address", (eventVector.getVector()).get(i).getVenue().getCity().getAddress());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("venueName", (eventVector.getVector()).get(i).getVenue().getCity().getVenueName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					object.put("data", (eventVector.getVector()).get(i).getDate().getData());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("orario", (eventVector.getVector()).get(i).getDate().getOrario());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {	
					object.put("segment", (eventVector.getVector()).get(i).getGenre().getSegmentName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("genre", (eventVector.getVector()).get(i).getGenre().getGenreName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("subgenre", (eventVector.getVector()).get(i).getGenre().getSubGenreName());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("currency", (eventVector.getVector()).get(i).getInformations().getCurrency());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("maxPrice", (eventVector.getVector()).get(i).getInformations().getMaxPrice());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("minPrice", (eventVector.getVector()).get(i).getInformations().getMinPrice());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					object.put("source", (eventVector.getVector()).get(i).getInformations().getSource());
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			 } catch(Exception e) {
					e.printStackTrace();
				}
			arr.put(object);
		}
		
		evento.put("Evento", arr );		
		return evento;
	}

}
