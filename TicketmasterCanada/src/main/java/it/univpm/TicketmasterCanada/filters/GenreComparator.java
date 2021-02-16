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
 */
public class GenreComparator implements FilterInterface {

	Stats stats = new StatsImplementation();

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
