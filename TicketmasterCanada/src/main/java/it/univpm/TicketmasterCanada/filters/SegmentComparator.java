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


/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

/**
 * Questa classe implementa period e contiene i metodi per il filtraggio degli eventi di 
 * un segment in base allo Stato e in funzione del periodo su cui si vuole effettuare tale ricerca
 */
public class SegmentComparator implements FilterInterface {
		
		Stats stats;
		

		public JSONArray period(Vector<String> segments, String state, int period) throws WrongValueException, WrongStateException {
			
			JSONArray segmentEvents = new JSONArray();
			
			Iterator<String> it = segments.iterator();
			
			int i = 0;
			
			String maxSegment = null;
			String minSegment = null;
			int maxEvent = 0;
			int minEvent = 999999;
			
			while(it.hasNext()) {
				
				JSONObject object = new JSONObject();
				object = stats.getSegmentEvents(state, it.next(), period);
				int totalElements = object.getInt("totalEvents");
				
				JSONObject couple = new JSONObject();
				couple.put("segment: ", segments.get(i));
				couple.put("totalEvents: ", totalElements);
				segmentEvents.put(couple);
				
				if(totalElements <= minEvent) {
					minEvent = totalElements;
					minSegment = segments.get(i);
				}
				
				if (totalElements >= maxEvent) {
					maxEvent = totalElements;
					maxSegment = segments.get(i);
				}

				i++;
					
				}
			
			JSONObject maxSegmentEvents = new JSONObject();
			maxSegmentEvents.put("Segment with most events: ", maxSegment);
			maxSegmentEvents.put("totalEvents: ", maxEvent);
			JSONObject minSegmentEvents = new JSONObject();
			minSegmentEvents.put("segment with least events: ", minSegment);
			minSegmentEvents.put("totalEvents: ", minEvent);
			
			segmentEvents.put(maxSegmentEvents);
			segmentEvents.put(minSegmentEvents);
			
			return segmentEvents;

		}
	
}

