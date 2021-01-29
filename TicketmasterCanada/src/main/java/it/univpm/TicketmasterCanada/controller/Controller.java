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
import it.univpm.TicketmasterCanada.service.Service;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

@RestController

public class Controller{
	
	@Autowired
	Service service;
	
	@GetMapping(value = "/events")
	public ResponseEntity<Object> getStateEvents(@RequestParam String stateName){
		Venue venue = service.getStateEventsfromApi(stateName);
		
		JSONObject obj = new JSONObject();
		
		return new ResponseEntity<> (obj.toString(), HttpStatus.OK);
	}
}
