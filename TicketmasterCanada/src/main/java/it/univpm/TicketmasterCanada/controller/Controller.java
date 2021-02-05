/**
 * 
 */
package it.univpm.TicketmasterCanada.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.json.*;

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
		
		EventVector eventsArray = service.getEventsFromAPI(countryCode);
		
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
	
	
}
