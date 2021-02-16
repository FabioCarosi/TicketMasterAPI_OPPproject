package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;
import it.univpm.TicketmasterCanada.exception.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 *Interfaccia che contiene il metodo il quale filtra gli eventi per value e per periodo
 */
public interface FilterInterface {

	public abstract JSONArray period(Vector<String> state, String value, int period)
			throws WrongValueException, WrongStateException;

}
