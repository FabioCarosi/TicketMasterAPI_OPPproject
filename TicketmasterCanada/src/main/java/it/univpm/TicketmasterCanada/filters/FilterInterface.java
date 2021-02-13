/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;
import it.univpm.TicketmasterCanada.exception.*;


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public interface FilterInterface {
	
	public abstract JSONArray period(Vector<String> countries, String value, int period) throws WrongValueException;

}
