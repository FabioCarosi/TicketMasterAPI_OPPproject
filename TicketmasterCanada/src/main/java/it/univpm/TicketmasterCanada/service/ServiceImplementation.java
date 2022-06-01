/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.exception.SummonException;
import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;
import it.univpm.TicketmasterCanada.model.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 * 
 * Questa è la classe che implementa l'interfaccia Service
 */

@Service
public class ServiceImplementation implements it.univpm.TicketmasterCanada.service.Service {

	
	SummonException exc = new SummonException();
	
	/**
	 * Chiave API per accedere ai servizi Ticketmaster
	 */
	private String apiKey = "API_KEY_TICKETMASTER";


	/**
	 * Metodo che restituisce gli eventi da Ticketmaster passando lo stateCode come parametro
	 * 
	 * @param stateCode dello Stato interassato
	 * @return JSONObject con gli eventi dello Stato
	 * @throws WrongStateException	se viene inserito uno stateCode non canadese
	 */
	@Override
	public JSONObject getStateEvents(String stateCode) throws WrongStateException {
		
		exc.stateStringException(stateCode);
		String request = "";
		
		if (stateCode.equals("CA")) {
			request = "https://app.ticketmaster.com/discovery/v2/events.json?size=200&apikey=" + apiKey
					+ "&countryCode=CA";
		}
		else {
			request = "https://app.ticketmaster.com/discovery/v2/events.json?&size=200&apikey=" + apiKey
				+ "&stateCode=" + stateCode;
		}
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

	public JSONObject getCountryEvents(){

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
	 * @throws WrongValueException se viene inserito un marketID non esistente o errato
	 */

	public JSONObject getMarketEvents(String marketID) throws WrongValueException {
		
		exc.marketStringException(marketID);

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
	 * @throws WrongValueException se viene inserito un marketID non esistente o errato
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 */
	public JSONObject getSourceEvents(String source, String stateCode) throws WrongValueException, WrongStateException{
		
		exc.sourceStringException(source);
		exc.stateStringException(stateCode);
		
		String request = "";
		if (stateCode.equals("CA")) {
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 */
	public JSONObject getKeywordEvents(String keyword, String stateCode) throws WrongStateException {
		
		exc.stateStringException(stateCode);
		
		String request = "";

		if (stateCode.equals("CA")) {
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 * @throws WrongValueException se viene inserito un segment non valido
	 */
	public JSONObject getSegmentEvents(String segment, String stateCode) throws WrongStateException, WrongValueException {
		
		exc.stateStringException(stateCode);
		exc.segmentStringException(segment);
				
		String request = "";
		String segmentId = segment;
		
		if (segment.equals("Arts")) segmentId = "KZFzniwnSyZfZ7v7na";
		else if (segment.equals("Sports")) segmentId = "KZFzniwnSyZfZ7v7nE";
		else if (segment.equals("Miscellaneous")) segmentId = "KZFzniwnSyZfZ7v7n1";
		else if (segment.equals("Music")) segmentId = "KZFzniwnSyZfZ7v7nJ";
		
		if (stateCode.equals("CA")) {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&segmentId=" + segmentId
					+ "&countryCode=CA" + "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&segmentId=" + segmentId + "&stateCode="
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 * @throws WrongValueException se viene inserito un genre non valido
	 */
	public JSONObject getGenreEvents(String genre, String stateCode) throws WrongStateException, WrongValueException{
		
		exc.stateStringException(stateCode);
		exc.genreStringException(genre);
		
		String request = "";
		String genreCode = genreConverter(genre);
		if (stateCode.equals("CA")) {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&genreId=" + genreCode + "&countryCode=CA"
					+ "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&genreId=" + genreCode + "&stateCode="
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 * @throws WrongValueException se viene inserito un subgenre non valido
	 */
	public JSONObject getSubGenreEvents(String subgenre, String stateCode) throws WrongStateException, WrongValueException{
		
		exc.stateStringException(stateCode);
		exc.subgenreStringException(subgenre);
		
		String request = "";
		String subGenreCode = subGenreConverter(subgenre);

		if (stateCode.equals("CA")) {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&subGenreId=" + subGenreCode
					+ "&countryCode=CA" + "&apikey=" + apiKey;
		} else {
			request = "https://app.ticketmaster.com/discovery/v2/events?size=200&subGenreId=" + subGenreCode + "&stateCode="
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
	 * @param code codice della provincia del Canada in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono nella provincia del Canada e tutte le relative informazioni
	 * @throws WrongStateException se viene inserito un code non canadese
	 */
	public EventVector getStateEventsFromAPI(String code) throws WrongStateException {
		EventVector stateInfo = new EventVector();
		JSONObject stateObj = getStateEvents(code);
		Vector<Event> stateVector = vectorFiller(stateObj);
		stateInfo.setVector(stateVector);
		return stateInfo;
	}
	
	/**
	 * Questo metodo prende le informazioni degli eventi utilizzando il metodo getMarketEvents e il vectorFiller
	 * 
	 * @param code  ovvero il MarketId del market desiderato
	 * @return un EventVector contente tutte le informazioni utili degli eventi nel marketId selezionato
	 * @throws WrongValueException se viene inserito un code non valido
	 */
	public EventVector getMarketEventsFromAPI(String code) throws WrongValueException {
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 * @throws WrongValueException se viene inserito un source non valido
	 */
	public EventVector getSourceEventsFromAPI(String source, String stateCode) throws WrongValueException, WrongStateException {
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese
	 */
	public EventVector getKeywordEventsFromAPI(String keyword, String stateCode) throws WrongStateException {
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
	 * @throws WrongStateException se viene inserito uno stateCode non canadese 
	 */
	public EventVector getSegmentEventsFromAPI(String segment, String stateCode) throws WrongStateException, WrongValueException{
		EventVector segmentInfo = new EventVector();
		JSONObject segmentObj = getSegmentEvents(segment, stateCode);
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
	 * @throws WrongValueException se viene inserito un genre non valido
	 * @throws WrongStateException se viene inserito uno stateCode non canadese 
	 */
	public EventVector getGenreEventsFromAPI(String genre, String stateCode) throws WrongStateException, WrongValueException {
		EventVector genreInfo = new EventVector();
		JSONObject genreObj = getGenreEvents(genre, stateCode);
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
	 * @throws WrongValueException se viene inserito un subgenre non valido
	 * @throws WrongStateException se viene inserito uno stateCode non canadese 
	 */
	public EventVector getSubGenreEventsFromAPI(String subgenre, String stateCode) throws WrongStateException, WrongValueException {
		EventVector subgenreInfo = new EventVector();
		JSONObject subgenreObj = getSubGenreEvents(subgenre, stateCode);
		Vector<Event> subgenreVector = vectorFiller(subgenreObj);
		subgenreInfo.setVector(subgenreVector);
		return subgenreInfo;
	}
	
	/**
	 * Metodo che restitusce un vettore di Event con tutte le informazioni del singolo evento a partite dal JSONObject ricevuto dei metodi get*Events
	 * 
	 * @param object JSONOject creato precedentemente dai metodi get*Events (getStateEvents, getSegmentEvents, getMarketEvents...)
	 * @return fullVector cioè un vettore di Event con tutti gli eventi e le rispettive informazioni
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
	
	
	/*
	 * Metodo che converte la string genre in un'altra string corrispondente al genreId
	 * 
	 * @param la string Contenente il genre
	 * @return una String contenente il genre convertito in genreId
	 */
	public static String genreConverter(String genre) {
		
		String genreId = genre;
		
		if (genre.equals("Alternative")) genreId = "KnvZfZ7vAvv";
		else if (genre.equals("Aquatics")) genreId = "KnvZfZ7vAeI";
		else if (genre.equals("Athletic Races")) genreId = "KnvZfZ7vAet";
		else if (genre.equals("Basketball")) genreId = "KnvZfZ7vAde";
		else if (genre.equals("Blues")) genreId = "KnvZfZ7vAvd";
		else if (genre.equals("Boxing")) genreId = "KnvZfZ7vAdA";
		else if (genre.equals("Children's Theatre")) genreId = "KnvZfZ7v7na";
		else if (genre.equals("Circus & Specialty Acts")) genreId = "KnvZfZ7v7n1";
		else if (genre.equals("Classical")) genreId = "KnvZfZ7vAeJ";
		else if (genre.equals("Comedy")) genreId = "KnvZfZ7vAe1";
		else if (genre.equals("Community/Civic")) genreId = "KnvZfZ7vAAE";
		else if (genre.equals("Country")) genreId = "KnvZfZ7vAv6";
		else if (genre.equals("Cricket")) genreId = "KnvZfZ7vAdk";
		else if (genre.equals("Cycling")) genreId = "KnvZfZ7vAda";
		else if (genre.equals("Dance")) genreId = "KnvZfZ7v7nI";
		else if (genre.equals("Dance/Electronic")) genreId = "KnvZfZ7vAvF";
		else if (genre.equals("Equestrian")) genreId = "KnvZfZ7vAd1";
		else if (genre.equals("Family")) genreId = "KnvZfZ7vA1n";
		else if (genre.equals("Fashion")) genreId = "KnvZfZ7v7nn";
		else if (genre.equals("Folk")) genreId = "KnvZfZ7vAva";
		else if (genre.equals("Hip-Hop/Rap")) genreId = "KnvZfZ7vAv1";
		else if (genre.equals("Hobby/Special Interest Expos")) genreId = "KnvZfZ7vAAJ";
		else if (genre.equals("Ice Shows")) genreId = "KnvZfZ7v7lI";
		else if (genre.equals("Jazz")) genreId = "KnvZfZ7vAvE";
		else if (genre.equals("Magic & Illusion")) genreId = "KnvZfZ7v7lv";
		else if (genre.equals("Martial Arts")) genreId = "KnvZfZ7vA7d";
		else if (genre.equals("Metal")) genreId = "KnvZfZ7vAvt";
		else if (genre.equals("Miscellaneous")) genreId = "KnvZfZ7vA7A";
		else if (genre.equals("Miscellaneous Theatre")) genreId = "KnvZfZ7v7ld";
		else if (genre.equals("Motorsports/Racing")) genreId = "KnvZfZ7vA7k";
		else if (genre.equals("Performance Art")) genreId = "KnvZfZ7v7l6";
		else if (genre.equals("Pop")) genreId = "KnvZfZ7vAev";
		else if (genre.equals("Reggae")) genreId = "KnvZfZ7vAed";
		else if (genre.equals("Rock")) genreId = "KnvZfZ7vAeA";
		else if (genre.equals("Rugby")) genreId = "KnvZfZ7vA71";
		else if (genre.equals("R&B")) genreId = "KnvZfZ7vAee";
		else if (genre.equals("Spectacular")) genreId = "KnvZfZ7v7la";
		else if (genre.equals("Theatre")) genreId = "KnvZfZ7v7l1";
		else if (genre.equals("Undefined")) genreId = "KnvZfZ7v7ll";
		else if (genre.equals("Variety")) genreId = "KnvZfZ7v7lJ";
		else if (genre.equals("Volleyball")) genreId = "KnvZfZ7vAA7";
		else if (genre.equals("World")) genreId = "KnvZfZ7vAeF";
		else if (genre.equals("Wrestling")) genreId = "KnvZfZ7vAAk";
		return genreId;
		
	}
	
	/*
	 * Metodo che converte la string subGenre in un'altra string corrispondente al subGenreId
	 * 
	 * @param la string Contenente il subGenre
	 * @return una String contenente il subGenre convertito in subGenre
	 */
	public String subGenreConverter(String subGenre) {

		String subGenreId = subGenre;

		if (subGenre.equals("Adult Contemporary"))
			subGenreId = "KZazBEonSMnZfZ7vk1l";
		else if (subGenre.equals("Alternative"))
			subGenreId = "KZazBEonSMnZfZ7vAvJ";
		else if (subGenre.equals("Alternative Rock"))
			subGenreId = "KZazBEonSMnZfZ7v6dt";
		else if (subGenre.equals("Aquatics"))
			subGenreId = "KZazBEonSMnZfZ7vF1a";
		else if (subGenre.equals("Athletic Races"))
			subGenreId = "KZazBEonSMnZfZ7vF11";
		else if (subGenre.equals("Blues"))
			subGenreId = "KZazBEonSMnZfZ7vAAd";
		else if (subGenre.equals("Blues-Rock"))
			subGenreId = "KZazBEonSMnZfZ7v676";
		else if (subGenre.equals("Boxing"))
			subGenreId = "KZazBEonSMnZfZ7vFJJ";
		else if (subGenre.equals("British Folk-Rock"))
			subGenreId = "KZazBEonSMnZfZ7v671";
		else if (subGenre.equals("Burlesque"))
			subGenreId = "KZazBEonSMnZfZ7vaaE";
		else if (subGenre.equals("Cabaret"))
			subGenreId = "KZazBEonSMnZfZ7vAv7";
		else if (subGenre.equals("Children's Theatre"))
			subGenreId = "KZazBEonSMnZfZ7v7na";
		else if (subGenre.equals("Circus"))
			subGenreId = "KZazBEonSMnZfZ7v7n1";
		else if (subGenre.equals("Classical/Vocal"))
			subGenreId = "KZazBEonSMnZfZ7vF1A";
		else if (subGenre.equals("Club Dance"))
			subGenreId = "KZazBEonSMnZfZ7vAJ1";
		else if (subGenre.equals("Comedy"))
			subGenreId = "KZazBEonSMnZfZ7vF17";
		else if (subGenre.equals("Community/Civic"))
			subGenreId = "KZazBEonSMnZfZ7vFlv";
		else if (subGenre.equals("Country"))
			subGenreId = "KZazBEonSMnZfZ7vAFa";
		else if (subGenre.equals("Cricket"))
			subGenreId = "KZazBEonSMnZfZ7vFJE";
		else if (subGenre.equals("Cycling"))
			subGenreId = "KZazBEonSMnZfZ7vFEv";
		else if (subGenre.equals("Dance"))
			subGenreId = "KZazBEonSMnZfZ7v7nl";
		else if (subGenre.equals("Disco"))
			subGenreId = "KZazBEonSMnZfZ7vAJn";
		else if (subGenre.equals("Drama"))
			subGenreId = "KZazBEonSMnZfZ7v7lt";
		else if (subGenre.equals("Dressage"))
			subGenreId = "KZazBEonSMnZfZ7vFEe";
		else if (subGenre.equals("Equestrian"))
			subGenreId = "KZazBEonSMnZfZ7vFEd";
		else if (subGenre.equals("European Pop"))
			subGenreId = "KZazBEonSMnZfZ7v6At";
		else if (subGenre.equals("Fashion"))
			subGenreId = "KZazBEonSMnZfZ7v7le";
		else if (subGenre.equals("Folk"))
			subGenreId = "KZazBEonSMnZfZ7vAn7";
		else if (subGenre.equals("French Rap"))
			subGenreId = "KZazBEonSMnZfZ7vaa1";
		else if (subGenre.equals("Hard Rock"))
			subGenreId = "KZazBEonSMnZfZ7v6kl";
		else if (subGenre.equals("Heavy Metal"))
			subGenreId = "KZazBEonSMnZfZ7vkFd";
		else if (subGenre.equals("Hobby/Special Interest Expos"))
			subGenreId = "KZazBEonSMnZfZ7vFnl";
		else if (subGenre.equals("Ice Shows"))
			subGenreId = "KZazBEonSMnZfZ7vAv6";
		else if (subGenre.equals("Indie Pop"))
			subGenreId = "KZazBEonSMnZfZ7vkEk";
		else if (subGenre.equals("Indie Rock"))
			subGenreId = "KZazBEonSMnZfZ7vAde";
		else if (subGenre.equals("Jazz"))
			subGenreId = "KZazBEonSMnZfZ7vkda";
		else if (subGenre.equals("Latin"))
			subGenreId = "KZazBEonSMnZfZ7vFdJ";
		else if (subGenre.equals("Magic"))
			subGenreId = "KZazBEonSMnZfZ7v7l7";
		else if (subGenre.equals("Men Professional"))
			subGenreId = "KZazBEonSMnZfZ7vFJ6";
		else if (subGenre.equals("Metalcore"))
			subGenreId = "KZazBEonSMnZfZ7vaJk";
		else if (subGenre.equals("Miscellaneous"))
			subGenreId = "KZazBEonSMnZfZ7vFIt";
		else if (subGenre.equals("Miscellaneous Theatre"))
			subGenreId = "KZazBEonSMnZfZ7v7lk";
		else if (subGenre.equals("Mixed Martial Arts"))
			subGenreId = "KZazBEonSMnZfZ7vFIE";
		else if (subGenre.equals("Musical"))
			subGenreId = "KnvZfZ7v7l1";
		else if (subGenre.equals("Nu-Metal"))
			subGenreId = "KZazBEonSMnZfZ7vaJ6";
		else if (subGenre.equals("Other"))
			subGenreId = "KZazBEonSMnZfZ7vaav";
		else if (subGenre.equals("Performance Art"))
			subGenreId = "KZazBEonSMnZfZ7v7l1";
		else if (subGenre.equals("Pop"))
			subGenreId = "KZazBEonSMnZfZ7v6F1";
		else if (subGenre.equals("Rap-Rock"))
			subGenreId = "KZazBEonSMnZfZ7vkel";
		else if (subGenre.equals("Reggae"))
			subGenreId = "KZazBEonSMnZfZ7vknl";
		else if (subGenre.equals("Rugby Union"))
			subGenreId = "KZazBEonSMnZfZ7vFtJ";
		else if (subGenre.equals("Rock"))
			subGenreId = "KZazBEonSMnZfZ7v6da";
		else if (subGenre.equals("Rock & Roll"))
			subGenreId = "KZazBEonSMnZfZ7v6an";
		else if (subGenre.equals("R&B"))
			subGenreId = "KZazBEonSMnZfZ7vkIt";
		else if (subGenre.equals("Scandinavia"))
			subGenreId = "KZazBEonSMnZfZ7vF6E";
		else if (subGenre.equals("Soul"))
			subGenreId = "KZazBEonSMnZfZ7vknE";
		else if (subGenre.equals("Southern Rock"))
			subGenreId = "KZazBEonSMnZfZ7v61J";
		else if (subGenre.equals("Spectacular"))
			subGenreId = "KZazBEonSMnZfZ7v7lE";
		else if (subGenre.equals("Undefined"))
			subGenreId = "KZazBEonSMnZfZ7vAv1";
		else if (subGenre.equals("Urban"))
			subGenreId = "KZazBEonSMnZfZ7vkdA";
		else if (subGenre.equals("Variety"))
			subGenreId = "KZazBEonSMnZfZ7vAvA";
		else if (subGenre.equals("Volleyball"))
			subGenreId = "KZazBEonSMnZfZ7vFn6";
		else if (subGenre.equals("Witchstep"))
			subGenreId = "KZazBEonSMnZfZ7va1k";
		else if (subGenre.equals("World"))
			subGenreId = "KZazBEonSMnZfZ7v6Jt";
		else if (subGenre.equals("Wrestling"))
			subGenreId = "KZazBEonSMnZfZ7vFna";
		return subGenreId;

	}

}
