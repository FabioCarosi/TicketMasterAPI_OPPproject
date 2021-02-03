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
	
	public JSONObject getMarketEvents(String marketID) {
		
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
		
		
	public EventVector getCountryInformationsFromAPI (String code) {	
		EventVector countryInfo = new EventVector();
		JSONObject countryObj = getCountryEvents(code);
		Vector<Event> countryVector = vectorFiller(countryObj);
		countryInfo.setVector(countryVector);
		return countryInfo;
}
	
	
	public Vector<Event> vectorFiller(JSONObject object)
	{
		
		JSONObject stack;
		
		JSONObject embeddedObject = object.getJSONObject("_embedded");
		JSONArray eventsArray = embeddedObject.getJSONArray("events");
		
		Vector<Event> fullVector = new Vector<Event>(eventsArray.length());
		
		for (int i = 0; i<eventsArray.length(); i++) {
			
			Event event = new Event();              		//creo un nuovo oggetto di tipo event
			stack = eventsArray.getJSONObject(i); 			//i-esimo blocco nel vettore degli eventi
			event.setName(stack.getString("name")); 		//setto il nome dell'evento con la stringa che corrisponde a "name"
			event.setId(stack.getString("id"));  			//setto l'id dell'evento con la stringa che corrisponde a "id"
			event.setUrl(stack.getString("url"));			//setto l'url dell'evento con la stringa che corrisponde a "url"
			event.setInfo(stack.getString("info"));			//setto l'info dell'evento con la stringa che corrisponde a "info"
			
	
			Date data = new Date(); 													//creo un nuovo oggetto di tipo data
			JSONObject datesObject = stack.getJSONObject("dates"); 						//creo un JSONArray che corrisponde all'array "dates"
			//JSONObject datesObject = datesObjectUpper.getJSONObject(0);						//creo un JSONObject a partire dal dataArray precedente
			JSONObject startDateObject = datesObject.getJSONObject("start");				//creo un JSONArray che corrisponde all'array "start"
			//JSONObject startDateObject = startDateArray.getJSONObject(0);				//creo un JSONObject a partire dal startDateArray precedente
			data.setData(startDateObject.getString("localDate")); 						//setto la data della data con la stringa che corrisponde a "localDate"
			data.setOrario(startDateObject.getString("localTime")); 					//setto l'orario della data con la stringa che corrisponde a "localTime"
			event.setDate(data); 														//setto la data dell'evento con l'oggetto di tipo data appena creato
			
			Informations information = new Informations(); 								//creo un ogetto di tipo informations
			JSONArray informationsArray = stack.getJSONArray("priceRanges");			//creo un JSONArray che corrisponde all'array "priceRanges"
			JSONObject informationsObject = informationsArray.getJSONObject(0); 		//creo un JSONObject a partire dal informationsArray precedente
			information.setCurrency(informationsObject.getString("currency")); 			//setto la valuta con la stringa che corrisponde a "currency"
			information.setMaxPrice(informationsObject.getDouble("max"));				//setto il prezzo massimo con la stringa che corrisponde a "max"
			information.setMinPrice(informationsObject.getDouble("min"));				//setto il prezzo minimo con la stringa che corrisponde a "min"
			event.setInformations(information); 										//setto le informations dell'evento con l'oggetto di tipo infromations appena creato
			
			Genre genre = new Genre(); 													//creo un ogetto di tipo Genre
			JSONArray classificationsArray = stack.getJSONArray("classifications");		//creo un JSONArray che corrisponde all'array "classifications"
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);	//creo un JSONObject a partire dal informationsArray precedente
			JSONObject segmentsObject = classificationsObject.getJSONObject("segment");	//creo un JSONArray che corrisponde all'array "segment"
			//JSONObject segmentsObject = segmentsArray.getJSONObject(0); 				//creo un JSONObject a partire dal segmentArray precedente
			genre.setSegmentName(segmentsObject.getString("name")); 					//setto il nome del tipologia con la stringa che corrisponde a "name"
			JSONObject genresObject = classificationsObject.getJSONObject("genre"); 		//creo un JSONArray che corrisponde all'array "genre"
			//JSONObject genresObject = genresArray.getJSONObject(0);						//creo un JSONObject a partire dal genresArray precedente
			genre.setGenreName(genresObject.getString("name")); 						//setto il nome del genre con la stringa che corrisponde a "name"
			JSONObject subGenresObject = classificationsObject.getJSONObject("subGenre");	//creo un JSONArray che corrisponde all'array "subGenre"
			//JSONObject subGenresObject = subGenresArray.getJSONObject(0);				//creo un JSONObject a partire dal subGenreArray precedente
			genre.setSubGenreName(subGenresObject.getString("name")); 					//setto il nome del sottogenere con la stringa che corrisponde a "name"
			event.setGenre(genre);														//setto il genere dell'evento con l'oggetto genre appena creato
			//
			
			JSONObject firstObject = eventsArray.getJSONObject(i);                     //creo un nuovo JSONObject che contiene l'oggetto i-esimo sul vettore di JSON
			JSONObject lowerEmbeddedObj = firstObject.getJSONObject("_embedded");      //creo un nuovo JSONObject che contiene l'oggetto l'oggetto _embedded del JSON
			JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");           //creo un nuovo JSONArray che contiene l'array "venues" del JSON
			JSONObject venuesObject = venuesArray.getJSONObject(0);                //creo un nuovo JSONObject che contiene l'oggetto i-esimo sul vettore di JSON
			
			Venue venue = new Venue();
			
			City city = new City();
			//city.setVenueName(lowerFirstObject.getString("name"));
			JSONObject cityObject = venuesObject.getJSONObject("city");                 //creo un nuovo JSONObject che contiene l'ogetto city del JSON
			//JSONObject cityNameObject = cityObject.getJSONObject("name");             //creo un nuovo JSONObject che contiene l'oggetto name della city del JSON
			city.setCityName(cityObject.getString("name"));                             //setto il nome dell'oggetto city
			JSONObject addressObject = venuesObject.getJSONObject("address");           //creo un nuovo JSONObject che contiene
			//JSONObject addressNameObject = addressObject.getJSONObject("line1");      //creo un nuovo JSONObject che contiene
			city.setAddress(addressObject.getString("line1"));                          //setto l'indirizzo di city
			venue.setCity(city);                                                        //setto la city di venue con la city creata
			
			State state = new State();
			JSONObject stateObject = venuesObject.getJSONObject("state");              //creo un nuovo JSONObject che contiene l'oggetto state del JSON
			//JSONObject stateObject = stateObject.getJSONObject("name");             //creo un nuovo JSONObject che contiene l'oggetto name dello state del JSON
			//JSONObject stateObject = stateObject.getJSONObject("stateCode");        //creo un nuovo JSONObject che contiene l'oggetto code dello state del JSON
			state.setStateName(stateObject.getString("name"));                      //setto lo stateName dello state
			state.setStateCode(stateObject.getString("stateCode"));                 //setto lo stateCode dello state
			venue.setState(state);                                                      //setto lo state di venue passandogli lo stato appena creato
			
			Country country = new Country();
			JSONObject countryObject = venuesObject.getJSONObject("country");      //creo un nuovo JSONObject che contiene l'oggetto country del JSON
			//JSONObject countryNameObject = countryObject.getJSONObject("name");        //creo un nuovo JSONObject che contiene l'oggetto name del country del JSON
			//JSONObject countryCodeObject = countryObject.getJSONObject("countryCode"); //creo un nuovo JSONObject che contiene l'oggetto code del country del JSON
			country.setCountryName(countryObject.getString("name"));               //setto il countryName del country
			country.setCountryCode(countryObject.getString("countryCode"));        //setto il countryCode del country
			venue.setCountry(country);                                                 //setto il country di venue passandogli il country appena creato
			
			Market market = new Market();
			JSONArray marketArray = venuesObject.getJSONArray("markets");          //creo un nuovo JSONArray che contiene l'array "markets" del JSON
			JSONObject marketObject = marketArray.getJSONObject(0);
			//JSONObject marketNameObject = marketObject.getJSONObject("name");          //creo un nuovo JSONObject che contiene l'oggetto name del market del JSON
			//JSONObject marketIdObject = marketObject.getJSONObject("Id");              //creo un nuovo JSONObject che contiene l'oggetto code del market del JSON
			market.setMarketName(marketObject.getString("name"));                  //setto il nome del market
			market.setMarketID(marketObject.getString("id"));                        //setto l'id del market
			venue.setMarket(market); 
			
			event.setVenue(venue);
	
			
			fullVector.add(event);
		}

		return fullVector;	
	}

	

}
