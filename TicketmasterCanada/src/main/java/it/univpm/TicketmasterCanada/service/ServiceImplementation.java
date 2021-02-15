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

//Questa è la classe che implenta Service

@Service
public class ServiceImplementation implements it.univpm.TicketmasterCanada.service.Service {

	/**
	 * Chiave API per accedere ai servizi Ticketmaster
	 */
	private String apiKey = "Ccg2GNVOGvUUXJeAPtSSAEQZjxbFN75B";
	// private String apiKey = "WBy9EacSF1P9BRG8WENKrcXEcTHy5dMt";

	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando lo stateCode come
	 * parametro
	 * 
	 * @param stateCode dello Stato interassato
	 * @return JSONObject con gli eventi dello Stato
	 */
	@Override
	public JSONObject getStateEvents(String stateCode) {
		String request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey
				+ "&stateCode=" + stateCode;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject StateEventsObj;
		StateEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return StateEventsObj;
	}

	/**
	 * Metodo che restituisce gli eventi in Canada da Ticketmaster
	 * 
	 * @return JSONObject con gli eventi del Canada
	 */

	public JSONObject getCountryEvents() {

		String request = "https://app.ticketmaster.com/discovery/v2/events.json?size=200&apikey=" + apiKey
				+ "&countryCode=CA";
		RestTemplate rTemplate = new RestTemplate();
		JSONObject CountryEventsObj;
		CountryEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return CountryEventsObj;
	}

	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il marketID come
	 * parametro
	 * 
	 * @param marketID dello Stato interassato
	 * @return JSONObject con gli eventi del Market
	 */

	public JSONObject getMarketEvents(String marketID) {

		String request = "https://app.ticketmaster.com/discovery/v2/events.json?size=200&apikey=" + apiKey
				+ "&marketId=" + marketID;
		RestTemplate rTemplate = new RestTemplate();
		JSONObject MarketEventsObj;
		MarketEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return MarketEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il source come
	 * parametro e lo stateCode dello Stato 
	 * 
	 * @param source desiderato
	 * @param stateCode dello Stato desiderato
	 * @return JSONObject con gli eventi del source all'interno dello Stato indicato
	 */
	public JSONObject getSourceEvents(String source, String stateCode) {
		String request = "";
		if (stateCode == "CA") {
			request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey
					+ "&countryCode=CA&source=" + source;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey + "&source="
					+ source + "&stateCode=" + stateCode;
		}

		RestTemplate rTemplate = new RestTemplate();
		JSONObject SourceEventsObj;
		SourceEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return SourceEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando la keyword come
	 * parametro e lo stateCode dello Stato 
	 * 
	 * @param keyword desiderato
	 * @param stateCode dello Stato desiderato
	 * @return JSONObject con gli eventi della keyword all'interno dello Stato indicato
	 */
	public JSONObject getKeywordEvents(String keyword, String stateCode) {
		String request = "";

		if (stateCode == "CA") {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&keyword=" + keyword + "&countryCode=CA"
					+ "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&keyword=" + keyword + "&stateCode="
					+ stateCode + "&apikey=" + apiKey;
		}
		RestTemplate rTemplate = new RestTemplate();
		JSONObject KeywordEventsObj;
		KeywordEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return KeywordEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il segment come
	 * parametro e lo stateCode dello Stato 
	 * 
	 * @param segment desiderato
	 * @param stateCode dello Stato desiderato
	 * @return JSONObject con gli eventi del segment all'interno dello Stato indicato
	 */
	public JSONObject getSegmentEvents(String segment, String stateCode) {
		String request = "";

		if (stateCode == "CA") {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&segmentName=" + segment
					+ "&countryCode=CA" + "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&segmentName=" + segment + "&stateCode="
					+ stateCode + "&apikey=" + apiKey;
		}
		RestTemplate rTemplate = new RestTemplate();
		JSONObject segmentEventsObj;
		segmentEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return segmentEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il genre come
	 * parametro e lo stateCode dello Stato 
	 * 
	 * @param genre desiderato
	 * @param stateCode dello Stato desiderato
	 * @return JSONObject con gli eventi del genre all'interno dello Stato indicato
	 */
	public JSONObject getGenreEvents(String genre, String stateCode) {
		String request = "";

		if (stateCode == "CA") {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&genreId=" + genre + "&countryCode=CA"
					+ "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&genreId=" + genre + "&stateCode="
					+ stateCode + "&apikey=" + apiKey;
		}
		RestTemplate rTemplate = new RestTemplate();
		JSONObject genreEventsObj;
		genreEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return genreEventsObj;
	}
	
	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando il subgenre come
	 * parametro e lo stateCode dello Stato 
	 * 
	 * @param subgenre desiderato
	 * @param stateCode dello Stato desiderato
	 * @return JSONObject con gli eventi del subgenre all'interno dello Stato indicato
	 */
	public JSONObject getSubGenreEvents(String subgenre, String stateCode) {
		String request = "";

		if (stateCode == "CA") {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&subGenreId=" + subgenre
					+ "&countryCode=CA" + "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&subGenreId=" + subgenre + "&stateCode="
					+ stateCode + "&apikey=" + apiKey;
		}
		RestTemplate rTemplate = new RestTemplate();
		JSONObject subgenreEventsObj;
		subgenreEventsObj = new JSONObject(rTemplate.getForObject(request, String.class));

		return subgenreEventsObj;
	}
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in Canada, utilizzando il getCountryEvents e il vectorFiller
	 * 
	 * @return un JSONObject con tutti gli eventi che si svolgono in Canada e tutte le relative informazioni
	 */
	public EventVector getCountryEventsFromAPI() {
		EventVector countryInfo = new EventVector();
		JSONObject countryObj = getCountryEvents();
		Vector<Event> countryVector = vectorFiller(countryObj);
		countryInfo.setVector(countryVector);
		return countryInfo;
	}
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in una Provincia del Canada tramite il codice di tale state, utilizzando il getStateEvents e il vectorFiller
	 * 
	 * @param stateCode codice della provincia del Canada in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono nella provincia del Canada e tutte le relative informazioni
	 */
	public EventVector getStateEventsFromAPI(String code) {
		EventVector stateInfo = new EventVector();
		JSONObject stateObj = getStateEvents(code);
		Vector<Event> stateVector = vectorFiller(stateObj);
		stateInfo.setVector(stateVector);
		return stateInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getMarketEvents e il vectorFiller
	 * 
	 * @param code : cioe' il MarketId del market desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi nel marketId selezionato
	 */
	public EventVector getMarketEventsFromAPI(String code) {
		EventVector marketInfo = new EventVector();
		JSONObject marketObj = getMarketEvents(code);
		Vector<Event> marketVector = vectorFiller(marketObj);
		marketInfo.setVector(marketVector);
		return marketInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getSourceEvents e il vectorFiller
	 * 
	 * @param source desiderato
	 * @param stateCode, codice dello state (o intero Canada) desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi nel source e state selezionati
	 */
	public EventVector getSourceEventsFromAPI(String source, String stateCode) {
		EventVector sourceInfo = new EventVector();
		JSONObject sourceObj = getSourceEvents(source, stateCode);
		Vector<Event> sourceVector = vectorFiller(sourceObj);
		sourceInfo.setVector(sourceVector);
		return sourceInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getKeywordEvents e il vectorFiller
	 * 
	 * @param keyword, parola chiave ricercata
	 * @param stateCode, codice dello state (o intero Canada) desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi con la keyword e state selezionati
	 */
	public EventVector getKeywordEventsFromAPI(String keyword, String stateCode) {
		EventVector keywordInfo = new EventVector();
		JSONObject keywordObj = getKeywordEvents(keyword, stateCode);
		Vector<Event> keywordVector = vectorFiller(keywordObj);
		keywordInfo.setVector(keywordVector);
		return keywordInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getSegmentEvents e il vectorFiller
	 * 
	 * @param segment, tipologia di evento ricercata
	 * @param stateCode, codice dello state (o intero Canada) desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi con il segment e state selezionati
	 */
	public EventVector getSegmentEventsFromAPI(String segment, String stateCode) {
		EventVector segmentInfo = new EventVector();
		JSONObject segmentObj = getKeywordEvents(segment, stateCode);
		Vector<Event> segmentVector = vectorFiller(segmentObj);
		segmentInfo.setVector(segmentVector);
		return segmentInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getGenreEvents e il vectorFiller
	 * 
	 * @param genre, genere dell'evento ricercato
	 * @param stateCode, codice dello state (o intero Canada) desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi con il genre e state selezionati
	 */
	public EventVector getGenreEventsFromAPI(String genre, String stateCode) {
		EventVector genreInfo = new EventVector();
		JSONObject genreObj = getKeywordEvents(genre, stateCode);
		Vector<Event> genreVector = vectorFiller(genreObj);
		genreInfo.setVector(genreVector);
		return genreInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getSubGenreEvents e il vectorFiller
	 * 
	 * @param subgenre, sottogenere dell'evento
	 * @param stateCode, codice dello state (o intero Canada) desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi con il sottogenere e state selezionati
	 */
	public EventVector getSubGenreEventsFromAPI(String subgenre, String stateCode) {
		EventVector subgenreInfo = new EventVector();
		JSONObject subgenreObj = getKeywordEvents(subgenre, stateCode);
		Vector<Event> subgenreVector = vectorFiller(subgenreObj);
		subgenreInfo.setVector(subgenreVector);
		return subgenreInfo;
	}
	
	/**
	 * Metodo che restitusce un vettore di Event con tutte le informazioni del singolo evento a partite dal JSONObject ricevuto dei metodi get*Events
	 * 
	 * @param JSONOject creato precedentemente dai metodi get*Events (getStateEvents, getSegmentEvents, getMarketEvents...)
	 *@return fullVector cioè un vettore di Event con tutti gli eventi e le rispettive informazioni
	 */
	public Vector<Event> vectorFiller(JSONObject object) {

		JSONObject stack;

		JSONObject pageObject = object.getJSONObject("page");
		JSONObject embeddedObject = object.getJSONObject("_embedded");
		JSONArray eventsArray = embeddedObject.getJSONArray("events");
		Vector<Event> fullVector = new Vector<Event>(eventsArray.length());

		int totalElements = pageObject.getInt("totalElements");
		int dimMax = 0;

		if (totalElements < 200)
			dimMax = totalElements;
		else
			dimMax = 200;

		for (int i = 0; i < dimMax; i++) {

			Event event = new Event(); // creo un nuovo oggetto di tipo event
			stack = eventsArray.getJSONObject(i); // i-esimo blocco nel vettore degli eventi

			try {
				event.setName(stack.getString("name")); // setto il nome dell'evento con la stringa che corrisponde a
														// "name"
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				event.setId(stack.getString("id")); // setto l'id dell'evento con la stringa che corrisponde a "id"
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				event.setUrl(stack.getString("url")); // setto l'url dell'evento con la stringa che corrisponde a "url"
			} catch (Exception e) {
				e.printStackTrace();
			}

			Informations information = new Informations(); // creo un ogetto di tipo informations
			String url = stack.getString("url");
			String source = null;
			if (url.contains("universe"))
				source = "universe";
			else if (url.contains("ticketmaster"))
				source = "ticketmaster";
			else if (url.contains("ticketsnow"))
				source = "tmr";
			else if (url.contains("frontgate"))
				source = "frontgate";
			// else throw new
			information.setSource(source);

			try {
				event.setInfo(stack.getString("info")); // setto l'info dell'evento con la stringa che corrisponde a
														// "info"
			} catch (Exception e) {
				e.printStackTrace();
			}

			Date data = new Date(); // creo un nuovo oggetto di tipo data

			try {
				JSONObject datesObject = stack.getJSONObject("dates"); // creo un JSONArray che corrisponde all'array
																		// "dates"
				JSONObject startDateObject = datesObject.getJSONObject("start"); // creo un JSONArray che corrisponde
																					// all'array "start"
				data.setData(startDateObject.getString("localDate")); // setto la data della data con la stringa che
																		// corrisponde a "localDate"
				data.setOrario(startDateObject.getString("localTime")); // setto l'orario della data con la stringa che
																		// corrisponde a "localTime"
			} catch (Exception e) {
				e.printStackTrace();
			}

			event.setDate(data); // setto la data dell'evento con l'oggetto di tipo data appena creato

			try {
				JSONArray informationsArray = stack.getJSONArray("priceRanges"); // creo un JSONArray che corrisponde
																					// all'array "priceRanges"
				JSONObject informationsObject = informationsArray.getJSONObject(0); // creo un JSONObject a partire dal
																					// informationsArray precedente
				information.setCurrency(informationsObject.getString("currency")); // setto la valuta con la stringa che
																					// corrisponde a "currency"
				information.setMaxPrice(informationsObject.getDouble("max")); // setto il prezzo massimo con la stringa
																				// che corrisponde a "max"
				information.setMinPrice(informationsObject.getDouble("min")); // setto il prezzo minimo con la stringa
																				// che corrisponde a "min"
				event.setInformations(information); // setto le informations dell'evento con l'oggetto di tipo
													// infromations appena creato
			} catch (Exception e) {
				e.printStackTrace();
			}

			Genre genre = new Genre(); // creo un ogetto di tipo Genre
			try {
				JSONArray classificationsArray = stack.getJSONArray("classifications"); // creo un JSONArray che
																						// corrisponde all'array
																						// "classifications"
				JSONObject classificationsObject = classificationsArray.getJSONObject(0); // creo un JSONObject a
																							// partire dal
																							// informationsArray
																							// precedente
				JSONObject segmentsObject = classificationsObject.getJSONObject("segment"); // creo un JSONArray che
																							// corrisponde all'array
																							// "segment"
				genre.setSegmentName(segmentsObject.getString("name")); // setto il nome del tipologia con la stringa
																		// che corrisponde a "name"
				JSONObject genresObject = classificationsObject.getJSONObject("genre"); // creo un JSONArray che
																						// corrisponde all'array "genre"
				genre.setGenreName(genresObject.getString("name")); // setto il nome del genre con la stringa che
																	// corrisponde a "name"
				JSONObject subGenresObject = classificationsObject.getJSONObject("subGenre"); // creo un JSONArray che
																								// corrisponde all'array
																								// "subGenre"
				genre.setSubGenreName(subGenresObject.getString("name")); // setto il nome del sottogenere con la
																			// stringa che corrisponde a "name"
			} catch (Exception e) {
				e.printStackTrace();
			}

			event.setGenre(genre); // setto il genere dell'evento con l'oggetto genre appena creato

			JSONObject firstObject = eventsArray.getJSONObject(i); // creo un nuovo JSONObject che contiene l'oggetto
																	// i-esimo sul vettore di JSON
			JSONObject lowerEmbeddedObj = firstObject.getJSONObject("_embedded"); // creo un nuovo JSONObject che
																					// contiene l'oggetto l'oggetto
																					// _embedded del JSON
			JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues"); // creo un nuovo JSONArray che contiene
																				// l'array "venues" del JSON
			JSONObject venuesObject = venuesArray.getJSONObject(0); // creo un nuovo JSONObject che contiene l'oggetto
																	// i-esimo sul vettore di JSON

			Venue venue = new Venue();
			try {
				City city = new City();
				try {
					JSONObject cityObject = venuesObject.getJSONObject("city"); // creo un nuovo JSONObject che contiene
																				// l'ogetto city del JSON
					city.setCityName(cityObject.getString("name")); // setto il nome dell'oggetto city
					JSONObject addressObject = venuesObject.getJSONObject("address"); // creo un nuovo JSONObject che
																						// contiene
					city.setAddress(addressObject.getString("line1")); // setto l'indirizzo di city
				} catch (Exception e) {
					e.printStackTrace();
				}

				venue.setCity(city); // setto la city di venue con la city creata

				State state = new State();

				try {
					JSONObject stateObject = venuesObject.getJSONObject("state"); // creo un nuovo JSONObject che
																					// contiene l'oggetto state del JSON
					state.setStateName(stateObject.getString("name")); // setto lo stateName dello state
					state.setStateCode(stateObject.getString("stateCode")); // setto lo stateCode dello state
				} catch (Exception e) {
					e.printStackTrace();
				}

				venue.setState(state); // setto lo state di venue passandogli lo stato appena creato

				Country country = new Country();

				try {
					JSONObject countryObject = venuesObject.getJSONObject("country"); // creo un nuovo JSONObject che
																						// contiene l'oggetto country
																						// del JSON
					country.setCountryName(countryObject.getString("name")); // setto il countryName del country
					country.setCountryCode(countryObject.getString("countryCode")); // setto il countryCode del country
				} catch (Exception e) {
					e.printStackTrace();
				}

				venue.setCountry(country); // setto il country di venue passandogli il country appena creato

				Market market = new Market();
				try {
					JSONArray marketArray = venuesObject.getJSONArray("markets"); // creo un nuovo JSONArray che
																					// contiene l'array "markets" del
																					// JSON
					JSONObject marketObject = marketArray.getJSONObject(0);
					market.setMarketName(marketObject.getString("name")); // setto il nome del market
					market.setMarketID(marketObject.getString("id")); // setto l'id del market
				} catch (Exception e) {
					e.printStackTrace();
				}
				venue.setMarket(market);
			} catch (Exception e) {
				e.printStackTrace();
			}

			event.setVenue(venue);

			fullVector.add(event);
		}

		return fullVector;
	}

}
