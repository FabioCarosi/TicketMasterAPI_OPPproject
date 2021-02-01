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
	
/*
	
public Venue getVenueInformationsFromAPI (String code) {
		JSONObject Object = getCountryEvents(code);
		
		Venue venue = new Venue(code);
		
		JSONArray venueArray = Object.getJSONArray("_embedded");
		JSONObject stack;
		
		Vector<Venue> vector = new Vector<Venue>(venueArray.length());
		
		
		for (int i = 0; i<venueArray.length(); i++) {
			
			stack = venueArray.getJSONObject(i);  // i-esimo blocco nel vettore degli eventi
			JSONArray venueInfoArray = stack.getJSONArray("venues"); //creo un JSONArray che corrisponde all'array "dates"
			JSONObject venueInfoObject = venueInfoArray.getJSONObject(0); //creo un JSONObject a partire dal dataArray precedente
			venue.setVenueName(venueInfoObject.getString("name"));
			
			
			JSONArray cityArray = venueInfoObject.getJSONArray("city");//creo un JSONArray che corrisponde all'array "start"
			JSONObject cityObject = cityArray.getJSONObject(0);//creo un JSONObject a partire dal startDateArray precedente
			venue.setCityName(cityObject.getString("name")); //setto la data della data con la stringa che corrisponde a "localDate"


			JSONArray countryArray = venueInfoObject.getJSONArray("country");//creo un JSONArray che corrisponde all'array "start"
			JSONObject countryObject = countryArray.getJSONObject(0);//creo un JSONObject a partire dal startDateArray precedente
			venue.setCountryName(countryObject.getString("name")); //setto la data della data con la stringa che corrisponde a "localDate"
			venue.setCountryCode(countryObject.getString("name")); //setto la data della data con la stringa che corrisponde a "localDate"
		}
		return venue;	
	}
*/		
		
	public Venue getVenueInformationsFromAPI (String code) {	
		
		JSONObject stack = getCountryEvents(code);
		Venue venue = new Venue(code);
	
		try {
			JSONObject embeddedObject = stack.getJSONObject("_embedded");
			JSONObject venuesObject = embeddedObject.getJSONObject("venues");
			String venueName = (String) venuesObject.get("name");
			JSONObject cityObject = venuesObject.getJSONObject("city");
			String cityName = (String) cityObject.get("name");
			JSONObject countryObject = venuesObject.getJSONObject("country");
			String countryName = (String) countryObject.get("name");
			String countryCode = (String) countryObject.get("countryCode");
			JSONObject stateObject = venuesObject.getJSONObject("state");
			String stateName = (String) stateObject.get("name");
			String stateCode = (String) stateObject.get("stateCode");
			JSONObject addressObject = venuesObject.getJSONObject("address");
			String addressName = (String) addressObject.get("line1");
			JSONObject marketObject = venuesObject.getJSONObject("markets");
			String marketName = (String) marketObject.get("name");
			int marketID = (int) marketObject.get("id");
			venue.setAddress(addressName);
			venue.setCityName(cityName);
			venue.setCountryCode(countryCode);
			venue.setCountryName(countryName);
			venue.setStateCode(stateCode);
			venue.setStateName(stateName);
			venue.setMarketName(marketName);
			venue.setMarketID(marketID);
			venue.setVenueName(venueName);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return venue;
}
	


	public Venue getChosenCountryEventsfromApi(String countryCode) {
		
		JSONObject countryAPIObj = getCountryEvents(countryCode);
		
		Venue venue = new Venue(countryCode);
		
		venue = getVenueInformationsFromAPI(countryCode);
		
		JSONArray eventsArray = countryAPIObj.getJSONArray("events");
		JSONObject stack;
		
		Vector<Event> vector = new Vector<Event>(eventsArray.length());
		
		
		for (int i = 0; i<eventsArray.length(); i++) {
			
			Event event = new Event();              //creo un nuovo oggetto di tipo event
			stack = eventsArray.getJSONObject(i);  // i-esimo blocco nel vettore degli eventi
			event.setName(stack.getString("name")); //setto il nome dell'evento con la stringa che corrisponde a "name"
			event.setId(stack.getString("id"));  //setto l'id dell'evento con la stringa che corrisponde a "id"
			event.setUrl(stack.getString("url")); //setto l'url dell'evento con la stringa che corrisponde a "url"
			event.setInfo(stack.getString("info")); //setto l'inof dell'evento con la stringa che corrisponde a "info"
			
	
			Date data = new Date(); //creo un nuovo oggetto di tipo data
			JSONArray datesArray = stack.getJSONArray("dates"); //creo un JSONArray che corrisponde all'array "dates"
			JSONObject datesObject = datesArray.getJSONObject(0); //creo un JSONObject a partire dal dataArray precedente
			JSONArray startDateArray = datesObject.getJSONArray("start");//creo un JSONArray che corrisponde all'array "start"
			JSONObject startDateObject = startDateArray.getJSONObject(0);//creo un JSONObject a partire dal startDateArray precedente
			data.setData(startDateObject.getString("localDate")); //setto la data della data con la stringa che corrisponde a "localDate"
			data.setOrario(startDateObject.getString("localTime")); //setto l'orario della data con la stringa che corrisponde a "localTime"
			event.setDate(data); //setto la data dell'evento con l'oggetto di tipo data appena creato
			
			Informations information = new Informations(); //creo un ogetto di tipo informations
			JSONArray informationsArray = stack.getJSONArray("priceRanges");//creo un JSONArray che corrisponde all'array "priceRanges"
			JSONObject informationsObject = informationsArray.getJSONObject(0); //creo un JSONObject a partire dal informationsArray precedente
			information.setCurrency(informationsObject.getString("currency")); //setto la valuta con la stringa che corrisponde a "currency"
			information.setMaxPrice(informationsObject.getDouble("max")); //setto il prezzo massimo con la stringa che corrisponde a "max"
			information.setMinPrice(informationsObject.getDouble("min")); //setto il prezzo minimo con la stringa che corrisponde a "min"
			event.setInformations(information); //setto le informations dell'evento con l'oggetto di tipo infromations appena creato
			
			Genre genre = new Genre(); //creo un ogetto di tipo Genre
			JSONArray classificationsArray = stack.getJSONArray("classifications"); //creo un JSONArray che corrisponde all'array "classifications"
			JSONObject classificationsObject = classificationsArray.getJSONObject(0); //creo un JSONObject a partire dal informationsArray precedente
			JSONArray segmentsArray = classificationsObject.getJSONArray("segment"); //creo un JSONArray che corrisponde all'array "segment"
			JSONObject segmentsObject = segmentsArray.getJSONObject(0); //creo un JSONObject a partire dal segmentArray precedente
			genre.setSegmentName(segmentsObject.getString("name")); //setto il nome del tipologia con la stringa che corrisponde a "name"
			JSONArray genresArray = classificationsObject.getJSONArray("genre"); //creo un JSONArray che corrisponde all'array "genre"
			JSONObject genresObject = genresArray.getJSONObject(0);//creo un JSONObject a partire dal genresArray precedente
			genre.setGenreName(genresObject.getString("name")); //setto il nome del genre con la stringa che corrisponde a "name"
			JSONArray subGenresArray = classificationsObject.getJSONArray("subGenre"); //creo un JSONArray che corrisponde all'array "subGenre"
			JSONObject subGenresObject = subGenresArray.getJSONObject(0);//creo un JSONObject a partire dal subGenreArray precedente
			genre.setSubGenreName(subGenresObject.getString("name")); //setto il nome del sottogenere con la stringa che corrisponde a "name"
			event.setGenre(genre); //setto il genere dell'evento con l'oggetto genre appena creato
			vector.add(event); 
		}
		
		venue.setVector(vector);
		
		return venue;
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
