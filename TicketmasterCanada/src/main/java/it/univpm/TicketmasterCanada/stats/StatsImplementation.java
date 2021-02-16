package it.univpm.TicketmasterCanada.stats;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.service.ServiceImplementation;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class StatsImplementation implements Stats{
	
	SummonException exc = new SummonException();
	private static LocalDate datanow = java.time.LocalDate.now();
	
	LocalDateTime nunc = LocalDateTime.now();
	
	int hour = nunc.getHour();
	int minute = nunc.getMinute();
	int second = nunc.getSecond();
	
	String tempus = "T" + hour + ":" + minute + ":" + second + "Z";
	


	/**
	 * Chiave API per accedere ai servizi Ticketmaster
	 */
	private String apiKey = "Ccg2GNVOGvUUXJeAPtSSAEQZjxbFN75B";
	
	
	public JSONObject getCountryEvents(int period){

		JSONObject countryObject;

        String url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=CA" 
        		 + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apiKey="+ apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryObject = new JSONObject(restTemplate.getForObject(url, String.class));
		
		JSONObject pageObject = countryObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject finalObject = new JSONObject();
		
		finalObject.put("Country ", "CA");
		finalObject.put("totalEvents", totalElements);

		return finalObject;
		
	}
	
	public JSONObject getStateEvents(String stateCode, int period) throws WrongStateException{

		exc.stateStringException(stateCode);
		
		JSONObject stateObject;
		
        String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode=" + stateCode 
        		 + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey="+ apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		stateObject = new JSONObject(restTemplate.getForObject(url, String.class));
		
		JSONObject pageObject = stateObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject finalObject = new JSONObject();
		
		finalObject.put("State", stateCode);
		finalObject.put("totalEvents", totalElements);

		return finalObject;
		
	}
	
	
	public JSONObject getMarketEvents(String marketId, int period) throws WrongValueException{
		
		exc.marketStringException(marketId);

		JSONObject marketObject;
		
		String url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId 
				 + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey="+ apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketObject = new JSONObject(restTemplate.getForObject(url, String.class));
		
		JSONObject pageObject = marketObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject finalObject = new JSONObject();
		
		finalObject.put("Market ", marketId);
		finalObject.put("totalEvents", totalElements);

		return finalObject;

	}
	
	
	public JSONObject getSegmentEvents(String stateCode, String segment, int period) throws WrongStateException, WrongValueException {

		exc.segmentStringException(segment);
		exc.stateStringException(stateCode);

		JSONObject segmentObject;

		String url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=" + stateCode + "&segmentName="
				+ segment + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey=" + apiKey;

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
	
	
	public JSONObject getGenreEvents(String stateCode, String genre, int period) throws WrongStateException, WrongValueException{
		
		exc.stateStringException(stateCode);
		exc.genreStringException(genre);
		String genreId = ServiceImplementation.genreConverter(genre);
		
		JSONObject genreEventsObject;
		
		String url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + stateCode + "&genreId="+ genreId  + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey="+ apiKey;
		
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


	public JSONObject getSubGenreEvents(String stateCode, String subGenre, int period) throws WrongStateException, WrongValueException{

		exc.stateStringException(stateCode);
		exc.subgenreStringException(subGenre);
        String subGenreId = subGenre;
		subGenreId = ServiceImplementation.genreConverter(subGenre);		
		JSONObject subGenreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + stateCode + "&subGenreId="+ subGenreId + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey="+ apiKey;
		
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

	public JSONObject getSourceEvents(String stateCode, String source, int period) throws WrongStateException, WrongValueException{
		
		exc.stateStringException(stateCode);
		exc.sourceStringException(source);
		
		JSONObject sourceObject;
		
		String url = "https://app.ticketmaster.com/discovery/v2/events?&stateCode="
	              + stateCode + "&source="+ source  + "&endDateTime=" + datanow.plusMonths(period) + tempus + "&apikey="+ apiKey;
		
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
