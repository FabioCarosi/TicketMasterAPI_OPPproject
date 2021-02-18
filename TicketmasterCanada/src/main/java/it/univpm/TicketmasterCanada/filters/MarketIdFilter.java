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
/**
 * Implementa MarketCountryInterface e contiene i metodi per filtrare gli eventi
 * in un Market in funzione del periodo su cui si vuole effettuare tale ricerca
 */
public class MarketIdFilter {
	Stats stats = new StatsImplementation();

	public JSONArray periodMarketState(Vector<String> markets, int period)
			throws WrongStateException, WrongValueException {

		JSONArray marketEvents = new JSONArray();

		Iterator<String> it = markets.iterator(); // inizializzo un iteratore con i markets passati come parametri

		int i = 0;

		String maxMarket = null; // Stato che contiente il maggior numero di eventi
		String minMarket = null; // Stato che contiente il minor numero di eventi
		int maxEvent = 0; // Numero di eventi maggiore
		int minEvent = 999999; // Numero di eventi minore
		int totEvent =0;
		while (it.hasNext()) { // ciclo che si conclude dopo aver scorso tutto il vettore con i Markets

			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), period); // chiamata al metodo getMarktetEvents a cui si passa il
																// market i-esimo e il periodo preso in esame
			int totalElements = object.getInt("totalEvents");
			totEvent = totEvent+totalElements;
			JSONObject couple = new JSONObject();
			couple.put("market ", markets.get(i)); // Inserisco il codice del Market esaminato nel coppia stato-numero
													// eventi
			couple.put("totalEvents", totalElements); // Inserisco il numero di eventi del Market esaminato nel coppia
														// stato-numero eventi
			marketEvents.put(couple);

			if (totalElements <= minEvent) { // Salvo il market con meno eventi
				minEvent = totalElements;
				minMarket = markets.get(i);
			}

			if (totalElements >= maxEvent) { // Salvo il market con più eventi
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;

		}

		JSONObject maxMarketEvents = new JSONObject(); // Salvo il market e il numero di eventi maggiore all'interno di
														// un JSONObject
		maxMarketEvents.put("Market with most events", maxMarket);
		maxMarketEvents.put("Events", maxEvent);
		JSONObject minMarketEvents = new JSONObject(); // Salvo il market e il numero di eventi minore all'interno di un
														// JSONObject
		minMarketEvents.put("Market with least events", minMarket);
		minMarketEvents.put("Events", minEvent);
		
		JSONObject totalEvents = new JSONObject();
		totalEvents.put("Total Events", totEvent);

		marketEvents.put(maxMarketEvents); // Inserisco il JSONOBject del market con più eventi all'interno del
											// JSONArray finale
		marketEvents.put(minMarketEvents); // Inserisco il JSONOBject del market con meno eventi all'interno del
											// JSONArray finale
		marketEvents.put(totalEvents);

		return marketEvents;

	}

}
