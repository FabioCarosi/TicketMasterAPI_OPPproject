package it.univpm.TicketmasterCanada.filters;

import java.time.LocalDate;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.WrongParameterException;
import it.univpm.TicketmasterCanada.exception.WrongPeriodException;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 * La classe Filters contiene i metodi necessari per poter utilizzare i filtri.
*/
public class Filters {
	private Vector<String> states = new Vector<String>();
	private String country;
	private String parameter;
	private LocalDate data = java.time.LocalDate.now();
	private int period;
	private String value;
	
	/**
	 * Costruttore con parametri:
	 * @param states		Vector di stinghe contenente i nomi degli stati da filtrare
	 * @param country		country su cui si vuole effettuare il filtraggio
	 * @param parameter		parametro per poter effettuare il filtraggio
	 * @param data			contiene la data di oggi
	 * @param period		lasso di tempo in mesi utilizzato per filtrare
	 */
	public Filters(Vector<String> states, String country, String parameter, LocalDate data, int period, String value) {
		super();
		this.states = states;
		this.country = country;
		this.parameter = parameter;
		this.data = data;
		this.period = period;
		this.value = value;
	}
	
	public JSONArray filtersImplementation() throws WrongPeriodException, WrongParameterException{
		
		JSONArray array = new JSONArray();
		data.plusMonths(period);
		
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
			else throw new WrongParameterException(parameter + "non è accettato. Scegli tra: marketID, source, genre e market.");
		}
		else if (period == 3) {
		
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.threeMonth(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.threeMonth(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.threeMonth(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.threeMonth(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.threeMonth(states, value);	
			}
			else throw new WrongParameterException(parameter + "non è accettato. Scegli tra: marketID, source, genre e market.");
		}
		else if (period == 6) {
					
			if(parameter.equals("marketID")) {
				FilterMarketID filter = new FilterMarketID();
				array = filter.sixMonth(states, value);	
			}			
			else if(parameter.equals("source")) {
				FilterSource filter = new FilterSource();
				array = filter.sixMonth(states, value);
			} 
			else if (parameter.equals("genre")) {
				FilterGenre filter = new FilterGenre();
				array = filter.sixMonth(states, value);		
			}
			else if (parameter.equals("segment")) {
				FilterSegment filter = new FilterSegment();
				array = filter.sixMonth(states, value);	
			}
			else if (parameter.equals("subgenre")) {
				FilterSubGenre filter = new FilterSubGenre();
				array = filter.sixMonth(states, value);	
			}
			else throw new WrongParameterException(parameter + "non è accettato. Scegli tra: marketID, source, genre e market.");
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
			else throw new WrongParameterException(parameter + "non è accettato. Scegli tra: marketID, source, genre e market.");
		}
		
		else throw new WrongPeriodException(period + " non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12");
		
		return array;
		
	}
	
	
	
	
	


}
