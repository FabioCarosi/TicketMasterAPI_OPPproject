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


import org.json.JSONObject;

import it.univpm.TicketmasterCanada.model.*;
import it.univpm.TicketmasterCanada.service.JsonCreator;
import it.univpm.TicketmasterCanada.service.*;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

@RestController

public class Controller{
	
	@Autowired
	Service service;
	
	/**
	@GetMapping(value = "/events")
	public ResponseEntity<Object> getStateEvents(@RequestParam String stateCode){
		Venue venue = service.getStateEventsfromApi(stateCode);
		
		JSONObject obj = new JSONObject();
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
	*/
	/**	
	@GetMapping(value = "/pacca")
	public ResponseEntity<Object> getCountryInformationsFromAPI(@RequestParam String stateCode){
			
	JSONObject obj = new JSONObject();
			
	return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
	}
	*/
	
	
	@GetMapping(value = "/events") 
	public ResponseEntity<Object> getCountryEvent(@RequestParam String countryCode) {
		
		EventVector eventsArray = service.getCountryInformationsFromAPI(countryCode);
		
		JSONObject obj = new JSONObject();
		JsonCreator jsonconverter = new JsonCreator();
		
		obj = jsonconverter.jsonCreator(eventsArray);
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
    }
}
