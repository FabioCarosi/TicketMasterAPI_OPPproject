/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
/**
 * Questa classe implementa period e contiene i metodi per il filtraggio degli
 * eventi di un subGenre in base allo Stato e in funzione del periodo su cui si
 * vuole effettuare tale ricerca
 */
public class SubGenreComparator implements FilterInterface {
	Stats stats = new StatsImplementation();

	/**
	 * Metodo calcola il numero totale di eventi considerando un subgenere e un
	 * state in un dato periodo. Restituisce un JSONArray contenente JSONObject che
	 * rappresentano i generi e il numero totale di eventi di ciascuno, Inoltre
	 * mostra il maggiore e il minor numero di eventi
	 * 
	 * @param subgenres vettori di sottogeneri
	 * @param state    in cui si svolgono gli eventi
	 * @param period    indica il periodo temporale (in mesi) su cui si vuole
	 *                  effettuare il confronto
	 * @throws WrongValueException se inserito genere di evento non ammesso
	 * @throws WrongStateException se inserito provincia non Canadese
	 */

	public JSONArray period(Vector<String> subgenres, String state, int period)
			throws WrongValueException, WrongStateException {

		JSONArray subgenreEvents = new JSONArray();

		Iterator<String> it = subgenres.iterator();

		int i = 0;

		String maxSubGenre = null;
		String minSubgenre = null;
		int maxEvent = 0;
		int minEvent = 999999;

		while (it.hasNext()) {

			JSONObject object = new JSONObject();
			object = stats.getSubGenreEvents(state, it.next(), period);
			int totalElements = object.getInt("totalEvents");

			JSONObject couple = new JSONObject();
			couple.put("subgenre", subgenres.get(i));
			couple.put("totalEvents", totalElements);
			subgenreEvents.put(couple);

			if (totalElements <= minEvent) {
				minEvent = totalElements;
				minSubgenre = subgenres.get(i);
			}

			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSubGenre = subgenres.get(i);
			}

			i++;

		}

		JSONObject maxSubGenreEvents = new JSONObject();
		maxSubGenreEvents.put("Subgenre with most events", maxSubGenre);
		maxSubGenreEvents.put("totalEvents", maxEvent);
		JSONObject minSubGenreEvents = new JSONObject();
		minSubGenreEvents.put("subgenre with least events", minSubgenre);
		minSubGenreEvents.put("totalEvents", minEvent);

		subgenreEvents.put(maxSubGenreEvents);
		subgenreEvents.put(minSubGenreEvents);

		return subgenreEvents;

	}
}
