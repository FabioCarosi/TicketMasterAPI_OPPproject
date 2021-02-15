/**
 * 
 */
package it.univpm.TicketmasterCanada.stats;

import org.json.JSONObject;
import it.univpm.TicketmasterCanada.exception.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public interface Stats {
	
	public abstract JSONObject getCountryEvents(int period);
	public abstract JSONObject getStateEvents(String stateCode, int period) throws WrongStateException;
	public abstract JSONObject getMarketEvents(String stateCode, int period) throws WrongStateException;
	public abstract JSONObject getSourceEvents(String stateCode, String source, int period) throws WrongStateException, WrongValueException;
	public abstract JSONObject getSegmentEvents(String stateCode, String segment, int period) throws WrongStateException, WrongValueException;
	public abstract JSONObject getGenreEvents(String stateCode, String genre, int period) throws WrongValueException, WrongStateException;
	public abstract JSONObject getSubGenreEvents(String stateCode, String subgenre, int period) throws WrongStateException, WrongValueException;
	
}
