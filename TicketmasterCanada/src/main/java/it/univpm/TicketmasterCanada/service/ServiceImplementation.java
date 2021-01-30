/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.model.Venue;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class ServiceImplementation implements it.univpm.TicketmasterCanada.service.Service {

	/**
	 * Chiave API per accedere ai servizi Ticketmaster
	 */
	private String apiKey = "Ccg2GNVOGvUUXJeAPtSSAEQZjxbFN75B";
	//private String apiKey = "WBy9EacSF1P9BRG8WENKrcXEcTHy5dMt";
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando lo stateCode come parametro
	 * @param stateCode dello Stato interassato
	 * @return JSONObject con gli eventi dello Stato
	 */
	@Override
	public JSONObject getStateEvents(String stateCode) {
		
		
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=" + apiKey + "&stateCode="+ stateCode;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject StateEventsObj;
		StateEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return StateEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il countryCode come parametro
	 * @param countryCode dello Stato interassato
	 * @return JSONObject con gli eventi del Paese
	 */
	
	public JSONObject getCountryEvents(String countryCode) {
		
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=" + apiKey + "&countryCode="+ countryCode;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject StateEventsObj;
		StateEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return StateEventsObj;
	}

	@Override
	public Venue getStateEventsfromApi(String venue) {
		
		return null;
	}
}
