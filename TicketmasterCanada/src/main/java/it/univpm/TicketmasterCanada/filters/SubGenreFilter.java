/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;
import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class SubGenreFilter {

	Stats stats = new StatsImplementation();

	/**
	 * Metodo calcola il numero totale di eventi considerando un state e un subgenre
	 * in un dato periodo. Restituisce un JSONArray contenente JSONObject che
	 * rappresentano i generi e il numero totale di eventi di ciascuno, Inoltre
	 * mostra il maggiore e il minor numero di eventi
	 * 
	 * @param states   vettori di stati
	 * @param subgenre sottogenere
	 * @param period   indica il periodo temporale (in mesi) su cui si vuole
	 *                 effettuare il confronto
	 * @throws WrongValueException se inserito genere di evento non ammesso
	 * @throws WrongStateException se inserito provincia non Canadese
	 */

	public JSONArray period(Vector<String> states, String subgenre, int period)
			throws WrongStateException, WrongValueException {

		JSONArray subgenreEvents = new JSONArray();

		Iterator<String> it = states.iterator();

		int i = 0;

		String maxState = null; // Stato che contiente il maggior numero di eventi
		String minState = null; // Stato che contiente il minor numero di eventi
		int maxEvent = 0; // Numero di eventi maggiore
		int minEvent = 999999; // Numero di eventi minore

		while (it.hasNext()) { // ciclo che si conclude dopo aver scorso tutto il vettore con gli States

			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(it.next(), subgenre, period); // chiamata al metodo getGenreEvents a cui si
																			// passa il genre i-esimo e il periodo preso
																			// in esame
			int totalElements = object.getInt("totalEvents");

			JSONObject couple = new JSONObject();
			couple.put("state", states.get(i)); // Inserisco il codice dello Stato esaminato nel coppia stato-numero
												// eventi
			couple.put("totalEvents", totalElements); // Inserisco il numero di eventi dello Stato esaminato nel coppia
														// stato-numero eventi
			subgenreEvents.put(couple);

			if (totalElements <= minEvent) { // Salvo lo stato con meno eventi
				minEvent = totalElements;
				minState = states.get(i);
			}

			if (totalElements >= maxEvent) { // Salvo lo stato con piu' eventi
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;

		}

		JSONObject maxStateEvents = new JSONObject(); // Salvo il nome e il numero di eventi dello Stato con più eventi
														// all'interno di un JSONObject
		maxStateEvents.put("State with most events", maxState);
		maxStateEvents.put("totalEvents", maxEvent);
		JSONObject minStateEvents = new JSONObject(); // Salvo il nome e il numero di eventi dello Stato con meno eventi
														// all'interno di un JSONObject
		minStateEvents.put("State with least events", minState);
		minStateEvents.put("totalEvents", minEvent);

		subgenreEvents.put(maxStateEvents); // Inserisco il JSONOBject dellos stati con più eventi all'interno del
											// JSONArray finale
		subgenreEvents.put(minStateEvents); // Inserisco il JSONOBject dellos stati con meno eventi all'interno del
											// JSONArray finale

		return subgenreEvents;
	}

}
