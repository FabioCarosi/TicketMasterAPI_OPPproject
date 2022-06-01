package it.univpm.TicketmasterCanada.stats;


import java.time.*;
import java.time.temporal.ChronoUnit;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.service.ServiceImplementation;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class StatsImplementation implements Stats {

	SummonException exc = new SummonException();
	private static LocalDateTime endDateTime = LocalDateTime.now();


	/**
	 * Chiave API per accedere ai servizi Ticketmaster
	 */
	private String apiKey = "API_KEY_TICKETMASTER";
 


	public JSONObject getStateEvents(String stateCode, int period) throws WrongStateException {

		exc.stateStringException(stateCode);

		JSONObject stateObject;
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);

		String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode + "&endDateTime="+endDateTime+ "Z&apikey=" +  apiKey;

		RestTemplate restTemplate = new RestTemplate();

		stateObject = new JSONObject(restTemplate.getForObject(url, String.class));

		JSONObject pageObject = stateObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("State", stateCode);
		finalObject.put("totalEvents", totalElements);

		return finalObject;

	}

	public JSONObject getMarketEvents(String marketId, int period) throws WrongValueException {

		exc.marketStringException(marketId);

		JSONObject marketObject;
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);
		
		String url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId + "&endDateTime="+ endDateTime +"Z&apikey=" + apiKey;
		
		RestTemplate restTemplate = new RestTemplate();

		marketObject = new JSONObject(restTemplate.getForObject(url, String.class));

		JSONObject pageObject = marketObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("Market ", marketId);
		finalObject.put("totalEvents", totalElements);

		return finalObject;

	}

	public JSONObject getSegmentEvents(String stateCode, String segment, int period)
			throws WrongStateException, WrongValueException {

		exc.segmentStringException(segment);
		exc.stateStringException(stateCode);

		JSONObject segmentObject;
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);
		
		String segmentId = segment;
		
		if (segment.equals("Arts")) segmentId = "KZFzniwnSyZfZ7v7na";
		else if (segment.equals("Sports")) segmentId = "KZFzniwnSyZfZ7v7nE";
		else if (segment.equals("Miscellaneous")) segmentId = "KZFzniwnSyZfZ7v7n1";
		else if (segment.equals("Music")) segmentId = "KZFzniwnSyZfZ7v7nJ";

		String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode + "&segmentId="
				+ segmentId + "&endDateTime="+endDateTime +"Z&apikey=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();

		segmentObject = new JSONObject(restTemplate.getForObject(url, String.class));

		JSONObject pageObject = segmentObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("State ", stateCode);
		finalObject.put("Segment", segment);
		finalObject.put("totalEvents", totalElements);

		return finalObject;

	}

	public JSONObject getGenreEvents(String stateCode, String genre, int period)
			throws WrongStateException, WrongValueException {

		exc.stateStringException(stateCode);
		exc.genreStringException(genre);
		String genreId = ServiceImplementation.genreConverter(genre);
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);


		JSONObject genreEventsObject;

		String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode + "&genreId="
				+ genreId + "&endDateTime=" + endDateTime + "Z&apikey=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();

		genreEventsObject = new JSONObject(restTemplate.getForObject(url, String.class));

		JSONObject pageObject = genreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("State ", stateCode);
		finalObject.put("totalEvents", totalElements);
		finalObject.put("Genre", genre);
		return finalObject;

	}

	public JSONObject getSubGenreEvents(String stateCode, String subGenre, int period)
			throws WrongStateException, WrongValueException {

		exc.stateStringException(stateCode);
		exc.subgenreStringException(subGenre);
		String subGenreId = subGenre;
		subGenreId = ServiceImplementation.genreConverter(subGenre);
		JSONObject subGenreEventsObject;
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);

		

		String Url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode + "&subGenreId="
				+ subGenreId + "&endDateTime=" +endDateTime + "Z&apikey=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();

		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));

		JSONObject pageObject = subGenreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("State: ", stateCode);
		finalObject.put("totalEvents", totalElements);
		finalObject.put("SubGenre", subGenre);

		return finalObject;

	}

	public JSONObject getSourceEvents(String stateCode, String source, int period)
			throws WrongStateException, WrongValueException {

		exc.stateStringException(stateCode);
		exc.sourceStringException(source);

		JSONObject sourceObject;
		
		endDateTime = endDateTime.plusMonths(period);
		endDateTime = endDateTime.truncatedTo(ChronoUnit.SECONDS);
		
		String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode + "&source=" + source
				+ "&endDateTime=" + endDateTime + "Z&apikey=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();

		sourceObject = new JSONObject(restTemplate.getForObject(url, String.class));

		JSONObject pageObject = sourceObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");

		JSONObject finalObject = new JSONObject();

		finalObject.put("State ", stateCode);
		finalObject.put("Source ", source);
		finalObject.put("totalEvents", totalElements);

		return finalObject;
	}

}
