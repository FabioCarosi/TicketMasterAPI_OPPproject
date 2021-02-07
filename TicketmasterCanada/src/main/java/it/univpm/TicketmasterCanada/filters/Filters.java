package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.WrongParameterException;
import it.univpm.TicketmasterCanada.exception.WrongPeriodException;
import it.univpm.TicketmasterCanada.stats.StateStats;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 * La classe Filters contiene i metodi necessari per poter utilizzare i filtri.
*/
public class Filters {
	private Vector<String> states = new Vector<String>();
	private String country;
	private String parameter;
	private int period;
	private String value;
	
	
	
	/**
	 * Costruttore vuoto
	 */
	public Filters() {
		super();
	}


	StateStats stats = new StateStats();
	
	
	
	/**
	 * Costruttore con parametri:
	 * @param states		Vector di stinghe contenente i nomi degli stati da filtrare
	 * @param country		country su cui si vuole effettuare il filtraggio
	 * @param parameter		parametro per poter effettuare il filtraggio
	 * @param data			contiene la data di oggi
	 * @param period		lasso di tempo in mesi utilizzato per filtrare
	 * @param value			valore assunto dal parametro
	 */
	public Filters(Vector<String> states, String country, String parameter, int period, String value) {
		super();
		this.states = states;
		this.country = country;
		this.parameter = parameter;
		this.period = period;
		this.value = value;
	}
	
	public JSONArray filtersImplementation() throws WrongPeriodException, WrongParameterException{
		
		JSONArray array = new JSONArray();
		
		if(period == 1) {
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.oneMonth(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.oneMonth(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.oneMonth(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.oneMonth(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.oneMonth(states, value);	
			}
			else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
		}
		else if (period == 3) {
		
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.threeMonths(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.threeMonths(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.threeMonths(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.threeMonths(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.threeMonths(states, value);	
			}
			else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
		}
		else if (period == 6) {
					
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.sixMonths(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.sixMonths(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.sixMonths(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.sixMonths(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.sixMonths(states, value);	
			}
			else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
		}
		else if (period == 12) {
			
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.oneYear(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.oneYear(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.oneYear(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.oneYear(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.oneYear(states, value);	
			}
			else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
		}
		
		else throw new WrongPeriodException(period + " non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12");
		
		return array;
		
	}
	
	
	public JSONArray filterFiller(Vector<String> states, String value) {
		
		JSONArray array = new JSONArray();
		
		Vector<JSONObject> countryVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> coupleObject = new Vector<JSONObject>();
		
		Iterator<String> iter = states.iterator();
		
		int j = 0;
		String max = null;
		String min = null;
		int maxevent = 0;
		int minevent = 9999;
		

		while(iter.hasNext()) {
			JSONObject obj = new JSONObject();
			obj = stats.totalGenreEvents(iter.next(), value);
			countryVector.add(obj);	
			int totalElements = obj.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("State: ", states.get(j));
			couple.put("Total elements: ", totalElements);
			coupleObject.add(couple);
			array.put(couple);
			if(totalElements <= minevent) {
				minevent = totalElements;
				min = states.get(j);
			}
			if(totalElements >= maxevent) {
				maxevent = totalElements;
				max = states.get(j);
			}
			
			j++;
		}
		
		JSONObject highest = new JSONObject();
		JSONObject lower = new JSONObject();
		highest.put("Stato con il maggior numero di eventi: ", max);
		highest.put("Numero di eventi: ", maxevent);
		lower.put("Stato con il minor numero di eventi: ", min);
		lower.put("Numero di eventi: ", minevent);
		array.put(highest);
		array.put(lower);
			
		return array;
	}
}
