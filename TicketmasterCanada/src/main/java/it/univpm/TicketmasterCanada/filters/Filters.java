package it.univpm.TicketmasterCanada.filters;

import java.time.LocalDate;
import java.util.Vector;

import org.json.JSONObject;

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
	
	/**
	 * Costruttore con parametri:
	 * @param states		Vector di stinghe contenente i nomi degli stati da filtrare
	 * @param country		country su cui si vuole effettuare il filtraggio
	 * @param parameter		parametro per poter effettuare il filtraggio
	 * @param data			contiene la data di oggi
	 * @param period		lasso di tempo in mesi utilizzato per filtrare
	 */
	public Filters(Vector<String> states, String country, String parameter, LocalDate data, int period) {
		super();
		this.states = states;
		this.country = country;
		this.parameter = parameter;
		this.data = data;
		this.period = period;
	}
	
	public JSONObject filtersImplementation() throws WrongPeriodException{
		
		JSONObject object = new JSONObject();
		
		if (period == 1) {
			
			data.plusMonths(period);
			
		}
		else if (period == 3) {
			
			data.plusMonths(period);
			
		}
		else if (period == 6) {
			
			data.plusMonths(period);
			
		}
		else if (period == 12) {
			
			data.plusMonths(period);
			
		}
		
		else throw new WrongPeriodException(period + "non è ammesso. Inserisci un period uguale a 1,3,6 o 12.");
		
		return object;
		
	}
	
	
	
	
	


}
