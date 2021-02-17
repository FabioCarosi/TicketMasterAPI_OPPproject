package it.univpm.TicketmasterCanada.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.exception.SummonException;
import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;
import it.univpm.TicketmasterCanada.model.*;
import it.univpm.TicketmasterCanada.service.JsonCreator;
import it.univpm.TicketmasterCanada.service.ServiceImplementation;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 * 
 *         La classe GetImportantEvents crea una directory con all'interno i
 *         file di testo contenenti le informazioni sui primi 5 eventi (per
 *         importanza) per ciascun segment per ogni stato Canadese.
 */

public class GetImportantEvents {

	SummonException exc = new SummonException();

	private String apikey = "Ccg2GNVOGvUUXJeAPtSSAEQZjxbFN75B";

	public JSONObject ImportantEvents(String stateCode, String segment) {

		JSONObject importantObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?stateCode=" + stateCode + "&segmentName="
				+ segment + "&apikey=" + apikey;

		RestTemplate restTemplate = new RestTemplate();

		importantObject = new JSONObject(restTemplate.getForObject(Url, String.class));

		return importantObject;
	}

	/**
	 * Questo metodo utilizza ImportantEvents della stessa classe per andare a
	 * selezionare le informazioni desiderate relative ad un evento
	 * 
	 * @param stateCode codice dello Stato desiderato
	 * @param segment   categoria dell'evento
	 * @return un vettore contenente le informazioni sui primi 5 eventi per
	 *         importanza per lo stato e categoria desiderati
	 * 
	 * @throws WrongValueException se viene inserita una tipologia di evento non
	 *                             ammessa
	 * @throws WrongStateException se viene inserito il codice di uno stato non
	 *                             canadese
	 */
	public EventVector getSelectedImportantEventsFromAPI(String stateCode, String segment)
			throws WrongStateException, WrongValueException {

		JSONObject selectedImportantEventsOBJ = ImportantEvents(stateCode, segment);
		EventVector sourceInfo = new EventVector();


		JSONObject embeddedObject = selectedImportantEventsOBJ.getJSONObject("_embedded");
		JSONArray eventsArray = embeddedObject.getJSONArray("events");
		JSONObject stack;

		int dimMax = 5;
		Vector<Event> fullVector = new Vector<Event>(dimMax);

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
		sourceInfo.setVector(fullVector);

		return sourceInfo;

	}

	/**
	 * Questo metodo permette di scrivere 5 eventi in base al paese e alla tipologia
	 * scelta all'interno di un file (se non esiste viene creato) che è contenuto a
	 * sua volta all'interno di una directory (se non esiste viene creata).
	 * 
	 * @param stateCode il codice dello stato desiderato
	 * @param segment   il segment desiderato
	 * @return una string contenente il path del file
	 * 
	 * @throws IOException         se si verificano errori in fase di input/output
	 * @throws WrongStateException se si immette uno stateCode non canadese
	 * @throws WrongValueException se si immette un segment non ammesso
	 */
	public String SaveImportantStateEvents(String stateCode, String segment)
			throws WrongStateException, WrongValueException, IOException {

		EventVector eventsArray = getSelectedImportantEventsFromAPI(stateCode, segment);

		JSONObject object = new JSONObject();
		JsonCreator jsonCreator = new JsonCreator();

		object = jsonCreator.jsonCreator(eventsArray);

		String nomeDirectory = "MostImportantEvent";

		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;

		String nomeFile = stateCode + "_MostImportantEvent";

		String path = pathDirectory + "/" + nomeFile + ".txt";

		File directory = new File(pathDirectory);

		if (!directory.isDirectory()) {

			directory.mkdir();

		}

		File file = new File(path);

		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(object.toString());
			bufferedWriter.write("\n");
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		return path;

	}

	/**
	 * Questo metodo permette di scrivere 5 eventi in base al paese scelto
	 * all'interno di un file che è contenuto a sua volta all'interno di una
	 * directory (se non esistono vengono creati).
	 * 
	 * @param stateCode lo stateCode dello stato di cui si vogliono salvare i file
	 * @return una String che riporta il path del file salvato
	 * @throws IOException         se si verificano errori in fase di input/output
	 * @throws WrongStateException se si immette uno stateCode non canadese
	 */
	public String StoreStateEvents(String stateCode) throws IOException, WrongStateException {

		exc.stateStringException(stateCode);

		ServiceImplementation service = new ServiceImplementation();

		EventVector eventVector = service.getStateEventsFromAPI(stateCode);

		JSONObject object = new JSONObject();
		JsonCreator jsonCreator = new JsonCreator();

		object = jsonCreator.jsonCreator(eventVector);

		String nomeDirectory = "Important_events";

		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;

		String nomeFile = stateCode + "_most_important_events";

		String path = pathDirectory + "/" + nomeFile + ".txt";

		File directory = new File(pathDirectory);

		if (!directory.isDirectory()) {

			directory.mkdir();

		}

		File file = new File(path);

		try {
			if (file.exists()) {
				file.delete();
			} else
				file.createNewFile();

			FileWriter fileWriter = new FileWriter(file, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(object.toString());
			bufferedWriter.write("\n");
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		return "Il file è stato salvato in " + path;

	}

}
