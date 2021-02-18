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
 * @author Mattia Girolami Questa classe implementa period e contiene i metodi
 *         per il filtraggio degli eventi in un paese in base al segment e in
 *         funzione del periodo su cui si vuole effettuare tale ricerca
 */

public class SegmentFilter {

	Stats stats = new StatsImplementation();

	/**
	 * Metodo calcola il numero totale di eventi considerando un state e un segment
	 * in un dato periodo. Restituisce un JSONArray contenente JSONObject che
	 * rappresentano i generi e il numero totale di eventi di ciascuno, Inoltre
	 * mostra il maggiore e il minor numero di eventi
	 * 
	 * @param segment
	 * @param states  in cui si svolgono gli eventi
	 * @param period  indica il periodo temporale (in mesi) su cui si vuole
	 *                effettuare il confronto
	 * @throws WrongValueException se inserito genere di evento non ammesso
	 * @throws WrongStateException se inserito provincia non Canadese
	 */
	public JSONArray period(Vector<String> states, String segment, int period)
			throws WrongStateException, WrongValueException {

		JSONArray segmentEvents = new JSONArray();

		Iterator<String> it = states.iterator();

		int i = 0;

		String maxState = null; // Stato che contiente il maggior numero di eventi
		String minState = null; // Stato che contiente il minor numero di eventi
		int maxEvent = 0; // Numero di eventi maggiore
		int minEvent = 999999; // Numero di eventi minore
		int totEvent = 0;

		while (it.hasNext()) { // ciclo che si conclude dopo aver scorso tutto il vettore con gli States

			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(it.next(), segment, period);
			int totalElements = object.getInt("totalEvents");
			totEvent = totEvent + totalElements;
			JSONObject couple = new JSONObject();
			couple.put("state", states.get(i)); // Inserisco il codice dello Stato esaminato nel coppia stato-numero
												// eventi
			couple.put("totalEvents", totalElements); // Inserisco il numero di eventi dello Stato esaminato nel coppia
														// stato-numero eventi
			segmentEvents.put(couple);

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
		maxStateEvents.put("Events", maxEvent);
		JSONObject minStateEvents = new JSONObject(); // Salvo il nome e il numero di eventi dello Stato con meno eventi
														// all'interno di un JSONObject
		minStateEvents.put("State with least events", minState);
		minStateEvents.put("Events", minEvent);

		JSONObject totalEvents = new JSONObject();
		totalEvents.put("Total Events", totEvent);

		segmentEvents.put(maxStateEvents); // Inserisco il JSONOBject dellos stati con più eventi all'interno del
											// JSONArray finale
		segmentEvents.put(minStateEvents); // Inserisco il JSONOBject dellos stati con meno eventi all'interno del
											// JSONArray finale
		segmentEvents.put(totalEvents);
		return segmentEvents;
	}

}
