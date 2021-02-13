package it.univpm.TicketmasterCanada.service;



import java.io.IOException;
import java.util.Vector;
import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.TicketmasterCanada.model.*;

/**
 * Questa classe contiene il test della classe JsonCreator.
 * 
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class JsonCreatorTest {

	City city;
	Country country;
	Date date;
	Vector<Event> vector;
	Event event;
	EventVector eventVector;
	Genre genre;
	Informations informations;
	Market market;
	State state;
	Venue venue;
	JsonCreator jsonCreate;

	/**
	 * Inizializza tutti i componenti necessari per il test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		city = new City();
		country = new Country();
		date = new Date();
		vector = new Vector<Event>();
		event = new Event();
		eventVector = new EventVector();
		genre = new Genre();
		informations = new Informations();
		market = new Market();
		state = new State();
		venue = new Venue();
		jsonCreate = new JsonCreator();
	}

	/**
	 * Distrugge tutto ciò che è stato costruito dal setUp();
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test che verifica la corretta conversione in json;
	 */
	@Test
	@DisplayName("Conversione corretta.")
	void jsonCreate() throws IOException {

		city.setAddress("Pharmacy Ave");
		city.setCityName("Toronto");
		city.setVenueName("Tralf");
		venue.setCity(city);

		country.setCountryName("Canada");
		country.setCountryCode("CA");
		venue.setCountry(country);

		market.setMarketID("102");
		market.setMarketName("Hamilton & Area");
		venue.setMarket(market);

		state.setStateCode("ON");
		state.setStateName("Ontario");
		venue.setState(state);

		date.setData("2021-02-10");
		date.setOrario("20:00:00");

		event.setName("Immersive Van Gogh");
		event.setInfo("Van Gogh paintings");
		event.setId("LvZ189DYDtXAd_8ZI0Hem");
		event.setUrl(
				"https://www.universe.com/events/immersive-van-gogh-timed-walk-thru-26th-february-rescheduled-19th-mar"
						+ "-tickets-134GDR?ref=ticketmaster");
		genre.setSegmentName("Arts & Theatre");
		genre.setGenreName("Fine Art");
		genre.setSubGenreName("Fine Art");

		informations.setCurrency("Euro");
		informations.setMaxPrice(100);
		informations.setMinPrice(0);

		event.setInformations(informations);
		event.setDate(date);
		event.setVenue(venue);
		event.setGenre(genre);

		vector.add(event);
		eventVector.setVector(vector);

		JSONObject object = new JSONObject();
		JSONArray eventArray = new JSONArray();
		JSONObject eventObj = new JSONObject();
		try {

			object.put("source", (eventVector.getVector()).get(0).getInformations().getSource());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("id", (eventVector.getVector()).get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("info", (eventVector.getVector()).get(0).getInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("name", (eventVector.getVector()).get(0).getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("url", (eventVector.getVector()).get(0).getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("countryCode", (eventVector.getVector()).get(0).getVenue().getCountry().getCountryCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("countryName", (eventVector.getVector()).get(0).getVenue().getCountry().getCountryName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("stateCode", (eventVector.getVector()).get(0).getVenue().getState().getStateCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("stateName", (eventVector.getVector()).get(0).getVenue().getState().getStateName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("marketName", (eventVector.getVector()).get(0).getVenue().getMarket().getMarketName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("marketID", (eventVector.getVector()).get(0).getVenue().getMarket().getMarketID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("cityName", (eventVector.getVector()).get(0).getVenue().getCity().getCityName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("address", (eventVector.getVector()).get(0).getVenue().getCity().getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("venueName", (eventVector.getVector()).get(0).getVenue().getCity().getVenueName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			object.put("data", (eventVector.getVector()).get(0).getDate().getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("orario", (eventVector.getVector()).get(0).getDate().getOrario());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("segment", (eventVector.getVector()).get(0).getGenre().getSegmentName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("genre", (eventVector.getVector()).get(0).getGenre().getGenreName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("subgenre", (eventVector.getVector()).get(0).getGenre().getSubGenreName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("currency", (eventVector.getVector()).get(0).getInformations().getCurrency());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("maxPrice", (eventVector.getVector()).get(0).getInformations().getMaxPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("minPrice", (eventVector.getVector()).get(0).getInformations().getMinPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			object.put("source", (eventVector.getVector()).get(0).getInformations().getSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		eventArray.put(object);
		
		try {
			eventObj.put("Evento", eventArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
			
		assertEquals(eventObj.toString(), jsonCreate.jsonCreator(eventVector).toString());

	}
}
