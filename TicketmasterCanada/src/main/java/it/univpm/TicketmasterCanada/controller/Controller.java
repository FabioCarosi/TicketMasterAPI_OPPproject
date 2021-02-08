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

import ch.qos.logback.core.spi.FilterAttachableImpl;

import java.util.Vector;

import org.json.*;

import it.univpm.TicketmasterCanada.exception.WrongComparatorException;
import it.univpm.TicketmasterCanada.exception.WrongParameterException;
import it.univpm.TicketmasterCanada.exception.WrongPeriodException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;
import it.univpm.TicketmasterCanada.filters.Filters;
import it.univpm.TicketmasterCanada.model.*;
import it.univpm.TicketmasterCanada.service.*;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

@RestController

public class Controller{
	
	@Autowired
	Service service;
	
	@GetMapping(value = "/countryEvents") 
	public ResponseEntity<Object> getCountryEvent(@RequestParam String countryCode) {
		
		EventVector eventsArray = service.getCountryEventsFromAPI(countryCode);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/stateEvents") 
	public ResponseEntity<Object> getStateEvent(@RequestParam String stateCode) {
		
		EventVector eventsArray = service.getStateEventsFromAPI(stateCode);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/marketEvents") 
	public ResponseEntity<Object> getMarketEvent(@RequestParam String marketID) {
		
		EventVector eventsArray = service.getMarketEventsFromAPI(marketID);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/sourceEvents") 
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source) {
		
		EventVector eventsArray = service.getSourceEventsFromAPI(source);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/country-sourceEvents") 
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source, String countryCode) {
		
		EventVector eventsArray = service.getCountrySourceEventsFromAPI(source, countryCode);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
	
	@PostMapping(value = "/filter")
	public ResponseEntity<Object> filters(@RequestBody String body) throws WrongPeriodException, WrongValueException, WrongComparatorException, WrongComparatorException {
		
		JSONObject object = new JSONObject(body);
		JSONArray array = new JSONArray();
		String comparator;
		
		comparator = object.getString("comparator");
		array = object.getJSONArray("states");
		
		Vector<String> elements = new Vector<String>(array.length());		
		
		for(int i = 0; i < array.length(); i++) {
				
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
		}
		catch(WrongPeriodException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(WrongValueException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(WrongParameterException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(WrongComparatorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
}
}
