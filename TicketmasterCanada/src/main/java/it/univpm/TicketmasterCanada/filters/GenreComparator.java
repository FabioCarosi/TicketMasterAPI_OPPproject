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
 * @author Mattia Girolami
 * @author Fabio Carosi
 *
 *Classe che implementa FilterInterface
 *Contiene i metodi per filtare gli eventi di un genre analizzando per paese e dividendo per periodo
 */
public class GenreComparator implements FilterInterface {

	Stats stats = new StatsImplementation();
	
	/**
	 *  Metodo calcola il numero totale di eventi considerando un genere e un paese in un dato periodo.
	 * Restituisce un JSONArray contenente JSONObject che rappresentano i generi e il numero totale di eventi di ciascuno, 
	 *Inoltre mostra il maggiore e il minor numero di eventi
	 * 
	 * @param genres vettore di generi
	 * @param state paese in cui si svolgono gli eventi
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @throws WrongValueException se inserito genere di evento non ammesso
	 * @throws WrongStateException se inserito provincia non Canadese
	 */
	public JSONArray period(Vector<String> genres, String state, int period)
			throws WrongValueException, WrongStateException {

		JSONArray genreEvents = new JSONArray();

		Iterator<String> it = genres.iterator();

		int i = 0;

		String maxGenre = null;
		String minGenre = null;
		int maxEvent = 0;
		int minEvent = 999999;

		while (it.hasNext()) {

			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(state, it.next(), period);
			int totalElements = object.getInt("totalEvents");

			JSONObject couple = new JSONObject();
			couple.put("genre", genres.get(i));
			couple.put("totalEvents", totalElements);
			genreEvents.put(couple);

			if (totalElements <= minEvent) {
				minEvent = totalElements;
				minGenre = genres.get(i);
			}

			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxGenre = genres.get(i);
			}

			i++;

		}

		JSONObject maxGenreEvents = new JSONObject();
		maxGenreEvents.put("Genre with most events", maxGenre);
		maxGenreEvents.put("totalEvents", maxEvent);
		JSONObject minGenreEvents = new JSONObject();
		minGenreEvents.put("Genre with least events", minGenre);
		minGenreEvents.put("totalEvents", minEvent);

		genreEvents.put(maxGenreEvents);
		genreEvents.put(minGenreEvents);

		return genreEvents;

	}
}
