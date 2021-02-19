/**
 * 
 */
package it.univpm.TicketmasterCanada.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Vector;

import org.json.*;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.files.GetImportantEvents;
import it.univpm.TicketmasterCanada.filters.Filters;
import it.univpm.TicketmasterCanada.model.*;
import it.univpm.TicketmasterCanada.service.*;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

@RestController

public class Controller {

	SummonException exc = new SummonException();

	@Autowired
	Service service;

	/**
	 * Rotta di tipo GET che mostra gli eventi che hanno luogo in CANADA
	 * 
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 */
	@GetMapping(value = "/countryEvents")
	public ResponseEntity<Object> getCountryEvent() {

		EventVector eventsArray = service.getCountryEventsFromAPI();

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	/**
	 * Rotta di tipo GET che mostra gli eventi nella Provincia Canadese inserita
	 * dall'utente
	 * 
	 * @param stateCode rappresenta il codice dello Stato di cui si vogliono
	 *                  visualizzare gli eventi (sono ammessi solo le Province
	 *                  canadesi)
	 * @return gli eventi in ordine di importanza che hanno luogo nello State scelto
	 * @throws WrongStateException se viene inserito il codice di uno State non
	 *                             canadese
	 */
	@GetMapping(value = "/stateEvents")
	public ResponseEntity<Object> getStateEvent(@RequestParam String stateCode) throws WrongStateException {

	
		EventVector eventsArray = service.getStateEventsFromAPI(stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	/**
	 * Rotta di tipo GET che mostra gli eventi nel Market inserita dall'utente
	 * 
	 * @param marketID rappresenta il codice dello Market di cui si vogliono
	 *                 visualizzare gli eventi (sono ammessi solo i market canadesi)
	 * @return gli eventi in ordine di importanza che hanno luogo nello market
	 *         scelto
	 * @throws WrongValueException se viene inserito il codice di un market non
	 *                             canadese
	 */
	@GetMapping(value = "/marketEvents")
	public ResponseEntity<Object> getMarketEvent(@RequestParam String marketID) throws WrongValueException {


		EventVector eventsArray = service.getMarketEventsFromAPI(marketID);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	/**
	 * Rotta di tipo GET che mostra gli eventi del source inserita dall'utente
	 * 
	 * @param source rappresenta il nome del source di cui si vogliono visualizzare
	 *               gli eventi (universe,frontgate, tmr e ticketmaster)
	 * @return gli eventi in ordine di importanza che hanno luogo nello State scelto
	 * @throws WrongValueException se viene inserito il codice di un source diverso
	 *                             (universe,frontgate, tmr e ticketmaster)
	 */
	@GetMapping(value = "/sourceEvents")
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source, String stateCode)
			throws WrongValueException, WrongStateException {


		EventVector eventsArray = service.getSourceEventsFromAPI(source, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	/**
	 * Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto
	 * tramite la parola chiave inserita dall'utente, con le proprie caratteristiche
	 * selezionate dallo sviluppatore
	 * 
	 * @param keyword   parola chiave
	 * @param stateCode rappresenta il codice dello State di cui si vogliono
	 *                  visualizzare gli eventi (sono ammessi solo codici gli state
	 *                  canadesi)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 *         tramite la parola chiave inserita
	 * @throws WrongStateException se stateCode diverso dal quelli canadesi
	 */
	@GetMapping(value = "/keywordEvents")
	public ResponseEntity<Object> getKeywordEvent(@RequestParam String keyword, String stateCode)
			throws WrongStateException {


		EventVector eventsArray = service.getKeywordEventsFromAPI(keyword, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

	}

	/**
	 * Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto
	 * tramiteil segment inserita dall'utente, con le proprie caratteristiche
	 * selezionate dallo sviluppatore
	 * 
	 * @param segment   tipologia dell'evento
	 * @param stateCode rappresenta il codice dello State di cui si vogliono
	 *                  visualizzare gli eventi (sono ammessi solo codici gli state
	 *                  canadesi)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 *         tramite la parola chiave inserita
	 * @throws WrongStateException se stateCode diverso dal quelli canadesi
	 */
	@GetMapping(value = "/segmentEvents")
	public ResponseEntity<Object> getSegmentEvent(@RequestParam String segment, String stateCode)
			throws WrongStateException, WrongValueException {


		EventVector eventsArray = service.getSegmentEventsFromAPI(segment, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

	}

	/**
	 * Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto
	 * tramite il genre inserita dall'utente, con le proprie caratteristiche
	 * selezionate dallo sviluppatore
	 * 
	 * @param genre:    genere dell'evento
	 * @param stateCode rappresenta il codice dello State di cui si vogliono
	 *                  visualizzare gli eventi (sono ammessi solo codici gli state
	 *                  canadesi)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 *         tramite la parola chiave inserita
	 * @throws WrongStateException se stateCode diverso dal quelli canadesi
	 */
	@GetMapping(value = "/genreEvents")
	public ResponseEntity<Object> getGenreEvent(@RequestParam String genre, String stateCode)
			throws WrongStateException, WrongValueException {


		EventVector eventsArray = service.getGenreEventsFromAPI(genre, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

	}

	/**
	 * Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto
	 * tramite il subgenre inserita dall'utente, con le proprie caratteristiche
	 * selezionate dallo sviluppatore
	 * 
	 * @param subgenre  sottogenere dell'evento
	 * @param stateCode rappresenta il codice dello State di cui si vogliono
	 *                  visualizzare gli eventi (sono ammessi solo codici gli state
	 *                  canadesi)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 *         tramite la parola chiave inserita
	 * @throws WrongStateException se stateCode diverso dal quelli canadesi
	 */
	@GetMapping(value = "/subgenreEvents")
	public ResponseEntity<Object> getSubGenreEvent(@RequestParam String subgenre, String stateCode)
			throws WrongStateException, WrongValueException {

		EventVector eventsArray = service.getSubGenreEventsFromAPI(subgenre, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

	}

	/**
	 * Rotta di tipo POST che filtra gli eventi in base alle richieste dell'utente
	 * 
	 * L'utente deve inserire un JSONObject del tipo riportato nei seguenti esempi:
	 * { 
			 "comparator": "state", 
			 "elements": [
			 {
			  		 "name": "AB" 
			   	}, 
			   	{
			   		 "name": "BC" 
			   	},
			   	{
			   		 "name": "MB" 
			   	}
		
			   ],
			   "param": "genre",
			   "value": "Pop",
			   "period": 6
		}
	 * 
	 * - oppure -
	 * 
			 { 
		  "comparator": "segment", 
		  "elements": [
		  {
		   		 "name": "Arts" 
		    	}, 
		    	{
		    		 "name": "Music" 
		    	},
		    	{
		    		 "name": "Miscellaneous" 
		    	},
		     {
		    		 "name": "Sports" 
		    	}
		
		    ],
		    "param": "state",
		    "value": "AB",
		    "period": 3
		}
	 * 
	 * PARAM - camparation: rappresenta che tipo di elementi si vogliono confrontare
	 * tra loro: si possono confrontare tra loro: state, market, segment, genre,
	 * subGenre o source. PARAM elements: sono gli elementi che si vogliono
	 * confrontare. PARAM - parameter: rappresenta il parametro su cui si vuole
	 * effettuare il confronto (è uno tra segment, genre, subGenre, source, state o
	 * market); nel caso in cui comparator sia state oppure market, allora parameter
	 * può assumere il valore total ad indicare la scelta di voler conoscere il
	 * numero totale di eventi; nel caso in cui caomparator non sia né state né
	 * market, allora parameter può assumere solamente il valore state). PARAM -
	 * value: rappresenta il valore del parametro su cui si vuole effettuare il
	 * confronto. PARAM - period: indica il periodo temporale (in mesi) su cui si
	 * vuole effettuare il confronto (può essere un valore tra 1, 3, 6 oppure 12).
	 * 
	 * @param body è un JSONObject del tipo riportato sopra
	 * @return un JSONArray di JSONObject che mostrano i vari elements con il
	 *         relativo numero di eventi e infine quali tra questi presentano il
	 *         maggiore ed il minor numero di eventi
	 * @throws WrongComparatorException se viene inserito un comparator diverso da
	 *                                  country, market, source, segment, genre o
	 *                                  subgenre
	 * @throws WrongPeriodException     se il periodo inserito non è uno tra 1, 3, 6
	 *                                  o 12
	 * @throws WrongParameterException  se il parametro inserito non è uno tra
	 *                                  country, segment, genre, subGenre, source
	 * @throws WrongValueException      se viene inserito un valore di param non
	 *                                  ammesso
	 */

	@PostMapping(value = "/statsFilter")
	public ResponseEntity<Object> filters(@RequestBody String body) throws WrongPeriodException, WrongValueException,
			WrongComparatorException, WrongStateException, WrongParameterException {

		JSONObject object = new JSONObject(body);
		JSONArray array = new JSONArray();
		String comparator;

		comparator = object.getString("comparator");
		array = object.getJSONArray("elements");

		Vector<String> elements = new Vector<String>(array.length());

		for (int i = 0; i < array.length(); i++) {

			JSONObject obj = new JSONObject();
			obj = array.getJSONObject(i);
			elements.add(obj.getString("name"));
		}

		String parameter = object.getString("param");
		String value = object.getString("value");
		int period = object.getInt("period");

		Filters filter = new Filters(comparator, elements, parameter, value, period);

		try {
			return new ResponseEntity<>(filter.filtersImplementation().toString(), HttpStatus.OK);
		} catch (WrongPeriodException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (WrongValueException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (WrongParameterException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (WrongComparatorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Rotta di tipo GET che salva gli eventi che hanno luogo nello stato inserito
	 * dall'utente
	 * 
	 * @param stateCode rappresenta il codice dello di cui si vogliono visualizzare
	 *                  gli eventi (sono ammessi solo codici di stati canadesi)
	 * @return gli eventi che hanno luogo nello stato inserito dall'utente
	 * @throws IOException se si verificano errori di output su file
	 */

	@GetMapping(value = "/saveEvents")
	public ResponseEntity<Object> saveCountryEvents(@RequestParam String stateCode)
			throws IOException, WrongStateException {


		GetImportantEvents save = new GetImportantEvents();

		String path = save.StoreStateEvents(stateCode);

		return new ResponseEntity<>(path, HttpStatus.OK);

	}

}
