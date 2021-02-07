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
	
	public abstract JSONArray OneMonth(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray ThreeMonths(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray SixMonths(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray OneYear(Vector<String> countries, String value) throws WrongValueException;

}
