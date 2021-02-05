/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.model.*;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

@Service
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
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey + "&stateCode="+ stateCode;
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
		
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?size=200&apikey=" + apiKey + "&countryCode="+ countryCode;
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
	
	public JSONObject getMarketEvents(String marketID) {
		
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?size=200&apikey=" + apiKey + "&marketId="+ marketID;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject MarketEventsObj;
		MarketEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return MarketEventsObj;
	}
	
	@Override
	public JSONObject getSourceEvents(String source) {
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey + "&source="+ source;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject SourceEventsObj;
		SourceEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));
		
		return SourceEventsObj;
	}


	
	public EventVector getCountryEventsFromAPI (String code) {	
		EventVector countryInfo = new EventVector();
		JSONObject countryObj = getCountryEvents(code);
		Vector<Event> countryVector = vectorFiller(countryObj);
		countryInfo.setVector(countryVector);
		return countryInfo;
	}
	
	public EventVector getStateEventsFromAPI (String code) {	
		EventVector stateInfo = new EventVector();
		JSONObject stateObj = getCountryEvents(code);
		Vector<Event> stateVector = vectorFiller(stateObj);
		stateInfo.setVector(stateVector);
		return stateInfo;
	}
	public EventVector getMarketEventsFromAPI (String code) {	
		EventVector marketInfo = new EventVector();
		JSONObject marketObj = getCountryEvents(code);
		Vector<Event> marketVector = vectorFiller(marketObj);
		marketInfo.setVector(marketVector);
		return marketInfo;
	}
	public EventVector getSourceEventsFromAPI (String code) {	
		EventVector sourceInfo = new EventVector();
		JSONObject sourceObj = getCountryEvents(code);
		Vector<Event> sourceVector = vectorFiller(sourceObj);
		sourceInfo.setVector(sourceVector);
		return sourceInfo;
	}
	
	
	
	public Vector<Event> vectorFiller(JSONObject object) {
		
		JSONObject stack;
		
		JSONObject pageObject = object.getJSONObject("page");
		JSONObject embeddedObject = object.getJSONObject("_embedded");
		JSONArray eventsArray = embeddedObject.getJSONArray("events");
		Vector<Event> fullVector = new Vector<Event>(eventsArray.length());
        
		int totalElements = pageObject.getInt("totalElements");
		int dimMax = 0;
		
		if(totalElements < 200) dimMax = totalElements;
		else dimMax = 200;
		
		for (int i = 0; i<dimMax; i++) {
			
			Event event = new Event();							//creo un nuovo oggetto di tipo event
			stack = eventsArray.getJSONObject(i);				//i-esimo blocco nel vettore degli eventi
			
			try {
				event.setName(stack.getString("name"));			//setto il nome dell'evento con la stringa che corrisponde a "name"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				event.setId(stack.getString("id"));				//setto l'id dell'evento con la stringa che corrisponde a "id"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				event.setUrl(stack.getString("url"));			//setto l'url dell'evento con la stringa che corrisponde a "url"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
			Informations information = new Informations();			//creo un ogetto di tipo informations
			String url = stack.getString("url");
			String source = null;
			if(url.contains("universe")) source = "universe";
			else if(url.contains("ticketmaster")) source = "ticketmaster";
			else if(url.contains("tmr")) source = "tmr";
			else if(url.contains("frontgate")) source = "frontgate";
			//else throw new 
			information.setSource(source);			
			
			try {
				event.setInfo(stack.getString("info"));			//setto l'info dell'evento con la stringa che corrisponde a "info"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
			Date data = new Date(); 							//creo un nuovo oggetto di tipo data
			
			try {
				JSONObject datesObject = stack.getJSONObject("dates"); 						//creo un JSONArray che corrisponde all'array "dates"
				JSONObject startDateObject = datesObject.getJSONObject("start");			//creo un JSONArray che corrisponde all'array "start"
				data.setData(startDateObject.getString("localDate")); 						//setto la data della data con la stringa che corrisponde a "localDate"
				data.setOrario(startDateObject.getString("localTime")); 					//setto l'orario della data con la stringa che corrisponde a "localTime"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setDate(data);									//setto la data dell'evento con l'oggetto di tipo data appena creato													
			
			
		
			try {
				JSONArray informationsArray = stack.getJSONArray("priceRanges");		//creo un JSONArray che corrisponde all'array "priceRanges"
				JSONObject informationsObject = informationsArray.getJSONObject(0);		//creo un JSONObject a partire dal informationsArray precedente
				information.setCurrency(informationsObject.getString("currency"));		//setto la valuta con la stringa che corrisponde a "currency"
				information.setMaxPrice(informationsObject.getDouble("max"));			//setto il prezzo massimo con la stringa che corrisponde a "max"
				information.setMinPrice(informationsObject.getDouble("min"));			//setto il prezzo minimo con la stringa che corrisponde a "min"
				event.setInformations(information); 									//setto le informations dell'evento con l'oggetto di tipo infromations appena creato
			}
			catch(Exception e) {
				e.printStackTrace();
			} 
			
			
			Genre genre = new Genre(); 													//creo un ogetto di tipo Genre
			try {
				JSONArray classificationsArray = stack.getJSONArray("classifications");			//creo un JSONArray che corrisponde all'array "classifications"
				JSONObject classificationsObject = classificationsArray.getJSONObject(0);		//creo un JSONObject a partire dal informationsArray precedente
				JSONObject segmentsObject = classificationsObject.getJSONObject("segment");		//creo un JSONArray che corrisponde all'array "segment"
				genre.setSegmentName(segmentsObject.getString("name"));							//setto il nome del tipologia con la stringa che corrisponde a "name"
				JSONObject genresObject = classificationsObject.getJSONObject("genre");			//creo un JSONArray che corrisponde all'array "genre"
				genre.setGenreName(genresObject.getString("name"));								//setto il nome del genre con la stringa che corrisponde a "name"
				JSONObject subGenresObject = classificationsObject.getJSONObject("subGenre");	//creo un JSONArray che corrisponde all'array "subGenre"
				genre.setSubGenreName(subGenresObject.getString("name"));						//setto il nome del sottogenere con la stringa che corrisponde a "name"
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setGenre(genre);														//setto il genere dell'evento con l'oggetto genre appena creato
	
			
			JSONObject firstObject = eventsArray.getJSONObject(i);						//creo un nuovo JSONObject che contiene l'oggetto i-esimo sul vettore di JSON
			JSONObject lowerEmbeddedObj = firstObject.getJSONObject("_embedded");		//creo un nuovo JSONObject che contiene l'oggetto l'oggetto _embedded del JSON
			JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");			//creo un nuovo JSONArray che contiene l'array "venues" del JSON
			JSONObject venuesObject = venuesArray.getJSONObject(0);						//creo un nuovo JSONObject che contiene l'oggetto i-esimo sul vettore di JSON
			
			Venue venue = new Venue();
			try {
				City city = new City();
				try {
					JSONObject cityObject = venuesObject.getJSONObject("city");					//creo un nuovo JSONObject che contiene l'ogetto city del JSON
					city.setCityName(cityObject.getString("name"));                             //setto il nome dell'oggetto city
					JSONObject addressObject = venuesObject.getJSONObject("address");           //creo un nuovo JSONObject che contiene
					city.setAddress(addressObject.getString("line1"));                          //setto l'indirizzo di city
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				venue.setCity(city);			//setto la city di venue con la city creata
				
				State state = new State();
				
				try {
					JSONObject stateObject = venuesObject.getJSONObject("state");			//creo un nuovo JSONObject che contiene l'oggetto state del JSON
					state.setStateName(stateObject.getString("name"));						//setto lo stateName dello state
					state.setStateCode(stateObject.getString("stateCode"));					//setto lo stateCode dello state
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				venue.setState(state);				//setto lo state di venue passandogli lo stato appena creato
				
				Country country = new Country();
				
				try {
					JSONObject countryObject = venuesObject.getJSONObject("country");      //creo un nuovo JSONObject che contiene l'oggetto country del JSON
					country.setCountryName(countryObject.getString("name"));               //setto il countryName del country
					country.setCountryCode(countryObject.getString("countryCode"));        //setto il countryCode del country
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				venue.setCountry(country);                                                 //setto il country di venue passandogli il country appena creato
				
				
				Market market = new Market();
				try {
					JSONArray marketArray = venuesObject.getJSONArray("markets");	//creo un nuovo JSONArray che contiene l'array "markets" del JSON
					JSONObject marketObject = marketArray.getJSONObject(0);
					market.setMarketName(marketObject.getString("name"));			//setto il nome del market
					market.setMarketID(marketObject.getString("id"));				//setto l'id del market
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				venue.setMarket(market);
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		
			event.setVenue(venue);
	
			fullVector.add(event);
		}

		return fullVector;	
	}
}
