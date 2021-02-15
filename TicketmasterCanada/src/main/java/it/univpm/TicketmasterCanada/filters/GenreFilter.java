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

public class GenreFilter {
	
	Stats stats = new StatsImplementation();
	
	public JSONArray period(Vector<String> states, String genre, int period) throws WrongValueException, WrongStateException {
		
		JSONArray genreEvents = new JSONArray();
		
		Iterator<String> it = states.iterator();
		
		int i = 0;
		
		String maxState = null;	//Stato che contiente il maggior numero di eventi
		String minState = null;	//Stato che contiente il minor numero di eventi
		int maxEvent = 0;		//Numero di eventi maggiore
		int minEvent = 999999;	//Numero di eventi minore
		
		while(it.hasNext()) {	//ciclo che si conclude dopo aver scorso tutto il vettore con gli States
			
			JSONObject object = new JSONObject();
			object = stats.getGenreEvents(it.next(), genre, period);	//chiamata al metodo getGenreEvents a cui si passa il genre i-esimo e il periodo preso in esame
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("state: ", states.get(i));			//Inserisco il codice dello Stato esaminato nel coppia stato-numero eventi
			couple.put("totalEvents: ", totalElements);		//Inserisco il numero di eventi dello Stato esaminato nel coppia stato-numero eventi
			genreEvents.put(couple);
			
			if(totalElements <= minEvent) {		//Salvo lo stato con meno eventi
				minEvent=totalElements;
				minState = states.get(i);
			}
			
			if (totalElements >= maxEvent) {	//Salvo lo stato con piu' eventi
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;
				
			}
		
		JSONObject maxStateEvents = new JSONObject();	//Salvo il nome e il numero di eventi dello Stato con più eventi all'interno di un JSONObject
		maxStateEvents.put("State with most events: ", maxState);
		maxStateEvents.put("totalEvents: ", maxEvent);
		JSONObject minStateEvents = new JSONObject();	//Salvo il nome e il numero di eventi dello Stato con meno eventi all'interno di un JSONObject
		minStateEvents.put("State with least events: ", minState);
		minStateEvents.put("totalEvents: ", minEvent);
		
		genreEvents.put(maxStateEvents);	//Inserisco il JSONOBject dellos stati con più eventi all'interno del JSONArray finale
		genreEvents.put(minStateEvents);	//Inserisco il JSONOBject dellos stati con più eventi all'interno del JSONArray finale
		
		return genreEvents;
	}
	
}
