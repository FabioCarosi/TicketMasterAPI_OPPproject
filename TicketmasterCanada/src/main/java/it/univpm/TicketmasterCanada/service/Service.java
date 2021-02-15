/**
 * 
 */
package it.univpm.TicketmasterCanada.service;

import java.util.Vector;

import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;
import it.univpm.TicketmasterCanada.model.*;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */

//Questa classe fa da interfaccia alla classe ServiceImplementation, con alcuni metodi richiamati dal Controller
public interface Service {

	public abstract EventVector getCountryEventsFromAPI();
	public abstract EventVector getStateEventsFromAPI(String stateCode) throws WrongStateException;
	public abstract EventVector getMarketEventsFromAPI(String marketCode) throws WrongValueException;
	public abstract EventVector getSourceEventsFromAPI(String source, String stateCode) throws WrongValueException, WrongStateException;
	public abstract EventVector getKeywordEventsFromAPI(String keyword, String stateCode) throws WrongStateException;
	public abstract EventVector getSegmentEventsFromAPI(String segment, String stateCode) throws WrongStateException, WrongValueException;
	public abstract EventVector getGenreEventsFromAPI(String genre, String stateCode) throws WrongStateException, WrongValueException;
	public abstract EventVector getSubGenreEventsFromAPI(String subgenre, String stateCode) throws WrongStateException, WrongValueException;

	public abstract JSONObject getCountryEvents();
	public abstract JSONObject getStateEvents(String stateCode) throws WrongStateException;
	public abstract JSONObject getMarketEvents(String marketID) throws WrongValueException;
	public abstract JSONObject getSourceEvents(String source, String stateCode) throws WrongValueException, WrongStateException;
	public abstract JSONObject getKeywordEvents(String keyword, String stateCode) throws WrongStateException;
	public abstract JSONObject getSegmentEvents(String segment, String stateCode) throws WrongStateException, WrongValueException;
	public abstract JSONObject getGenreEvents(String genre, String stateCode) throws WrongStateException, WrongValueException;
	public abstract JSONObject getSubGenreEvents(String subgenre, String stateCode) throws WrongStateException, WrongValueException;

	public abstract Vector<Event> vectorFiller(JSONObject object);

}
