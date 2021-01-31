/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.model.*;


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
		JSONObject CountryEventsObj;
		CountryEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return CountryEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il marketID come parametro
	 * @param marketID dello Stato interassato
	 * @return JSONObject con gli eventi del Market
	 */
	
	public JSONObject getMarketEvents(int marketID) {
		
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=" + apiKey + "&marketId="+ marketID;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject MarketEventsObj;
		MarketEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return MarketEventsObj;
	}


	public Venue getStateEventsfromApi(String stateCode) {
		// TODO Auto-generated method stub
		return null;
	}


	public Venue getChosenCountryEventsfromApi(String countryCode) {
		
		JSONObject countryAPIObj = getCountryEvents(countryCode);
		
		Venue country = new Venue(countryCode);
		
		country = getCountryFromAPI(countryCode);
		
		JSONArray eventsArray = countryAPIObj.getJSONArray("events");
		JSONObject stack;
		
		Vector<Event> vector = new Vector<Event>(eventsArray.length());
		
		
		for (int i = 0; i<eventsArray.length(); i++) {
			
			Event event = new Event();
			stack = eventsArray.getJSONObject(i);
			event.setName(stack.getString("name"));
			event.setId(stack.getString("id"));
			event.setUrl(stack.getString("url"));
			event.setInfo(stack.getString("info"));
			
	
			Date data = new Date();
			JSONArray datesArray = stack.getJSONArray("dates");
			JSONObject datesObject = datesArray.getJSONObject(0);
			JSONArray startDateArray = datesObject.getJSONArray("start");
			JSONObject startDateObject = startDateArray.getJSONObject(0);
			data.setData(startDateObject.getString("localDate"));
			data.setOrario(startDateObject.getString("localTime"));
			event.setDate(data);
			
			Informations information = new Informations();
			JSONArray informationsArray = stack.getJSONArray("priceRanges");
			JSONObject informationsObject = informationsArray.getJSONObject(0);
			information.setCurrency(informationsObject.getString("currency"));
			information.setMaxPrice(informationsObject.getDouble("max"));
			information.setMinPrice(informationsObject.getDouble("min"));
			event.setInformations(information);
			
			Genre genre = new Genre();
			JSONArray classificationsArray = stack.getJSONArray("classifications");
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);
			JSONArray segmentsArray = classificationsObject.getJSONArray("segment");
			JSONObject segmentsObject = segmentsArray.getJSONObject(0);
			genre.setSegmentName(segmentsObject.getString("name"));
			JSONArray genresArray = classificationsObject.getJSONArray("genre");
			JSONObject genresObject = genresArray.getJSONObject(0);
			genre.setGenreName(genresObject.getString("name"));
			JSONArray subGenresArray = classificationsObject.getJSONArray("subGenre");
			JSONObject subGenresObject = subGenresArray.getJSONObject(0);
			genre.setSubGenreName(subGenresObject.getString("name"));	
			event.setGenre(genre);

	
		}
		
		
		return null;
	}


	public Venue getMarketEventsfromApi(int marketID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue getCountryEventsfromApi(String contryCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
