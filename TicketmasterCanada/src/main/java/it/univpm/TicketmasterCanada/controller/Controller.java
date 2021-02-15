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

	@Autowired
	Service service;

	@GetMapping(value = "/countryEvents")
	public ResponseEntity<Object> getCountryEvent() {

		EventVector eventsArray = service.getCountryEventsFromAPI();

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	@GetMapping(value = "/stateEvents")
	public ResponseEntity<Object> getStateEvent(@RequestParam String stateCode) {

		EventVector eventsArray = service.getStateEventsFromAPI(stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}

	@GetMapping(value = "/marketEvents")
	public ResponseEntity<Object> getMarketEvent(@RequestParam String marketID) {

		EventVector eventsArray = service.getMarketEventsFromAPI(marketID);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}


	@GetMapping(value = "/sourceEvents")
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source, String stateCode) {

		EventVector eventsArray = service.getSourceEventsFromAPI(source, stateCode);

		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();

		obj = jsonconverter.jsonCreator(eventsArray);

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto tramite la parola chiave inserita dall'utente,
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param keyword parola chiave
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto tramite la parola chiave inserita
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/keywordEvents") 
	public ResponseEntity<Object> getKeywordEvent(@RequestParam String keyword, String stateCode) {
		
		EventVector eventsArray = service.getKeywordEventsFromAPI(keyword, stateCode);		
        
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	@GetMapping(value = "/segmentEvents") 
	public ResponseEntity<Object> getSegmentEvent(@RequestParam String segment, String stateCode) {
		
		EventVector eventsArray = service.getSegmentEventsFromAPI(segment, stateCode);		
        
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	@GetMapping(value = "/genreEvents") 
	public ResponseEntity<Object> getGenreEvent(@RequestParam String genre, String stateCode) {
		
		EventVector eventsArray = service.getGenreEventsFromAPI(genre, stateCode);		
        
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	@GetMapping(value = "/subgenreEvents") 
	public ResponseEntity<Object> getSubGenreEvent(@RequestParam String subgenre, String stateCode) {
		
		EventVector eventsArray = service.getSubGenreEventsFromAPI(subgenre, stateCode);		
        
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }

	@PostMapping(value = "/filter")
	public ResponseEntity<Object> filters(@RequestBody String body)
			throws WrongPeriodException, WrongValueException, WrongComparatorException, WrongComparatorException, WrongStateException, WrongMarketCodeException {

		JSONObject object = new JSONObject(body);
		JSONArray array = new JSONArray();
		String comparator;

		comparator = object.getString("comparator");
		array = object.getJSONArray("states");

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
		} catch (WrongMarketCodeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/saveCountryEvents") 
	public ResponseEntity<Object> saveCountryEvents(@RequestParam String stateCode) throws IOException {
		
		GetImportantEvents save = new GetImportantEvents();
		
        String path = save.StoreStateEvents(stateCode);
		
		return new ResponseEntity<>(path, HttpStatus.OK);
		
    }
	
}
