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
 * La classe Filters contiene i metodi necessari per poter utilizzare i filtri.
 */
public class Filters {
	private Vector<String> states = new Vector<String>();
	private String parameter;
	private int period;
	private String value;
	private String comparator;

	/**
	 * Costruttore vuoto
	 */
	public Filters() {
		super();
	}

	Stats stats = new StatsImplementation();

	/**
	 * Costruttore con parametri:
	 * 
	 * @parameter states Vector di stinghe contenente i nomi degli stati da filtrare
	 * @parameter country country su cui si vuole effettuare il filtraggio
	 * @parameter parameter parameteretro per poter effettuare il filtraggio
	 * @parameter data contiene la data di oggi
	 * @parameter period lasso di tempo in mesi utilizzato per filtrare
	 * @parameter value valore assunto dal parameteretro
	 * @parameter comparator String che permette all'utente di poter scegliere cosa confrontare
	 */
	public Filters(String comparator, Vector<String> states, String parameter, String value, int period) {
		super();
		this.comparator = comparator;
		this.states = states;
		this.parameter = parameter;
		this.value = value;
		this.period = period;
	}

	public JSONArray filtersImplementation()throws WrongPeriodException, WrongParameterException, WrongValueException, WrongComparatorException {

		JSONArray array = new JSONArray();

		if (comparator.equals("country")) {
			
			if (period == 1) {
				
				if (parameter.equals("marketID")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.OneMonthCountryMarket(states);
				} else if (parameter.equals("country")) {
					FilterCountry filter = new FilterCountry();
					array = filter.OneMonthCountryMarket(states);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
				
			} else if (period == 3) {

				if (parameter.equals("marketID")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.ThreeMonthsCountryMarket(states);
				} else if (parameter.equals("country")) {
					FilterCountry filter = new FilterCountry();
					array = filter.ThreeMonthsCountryMarket(states);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
				
			} else if (period == 6) {

				if (parameter.equals("marketID")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.SixMonthsCountryMarket(states);
				} else if (parameter.equals("country")) {
					FilterCountry filter = new FilterCountry();
					array = filter.SixMonthsCountryMarket(states);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
				
			} else if (period == 12) {

				if (parameter.equals("marketID")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.OneYearCountryMarket(states);
				} else if (parameter.equals("country")) {
					FilterCountry filter = new FilterCountry();
					array = filter.OneYearCountryMarket(states);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else throw new WrongParameterException(parameter + " non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.");
			}

			else throw new WrongPeriodException(period + " non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12");

		} else if (comparator.equals("market")) {

			if (period == 1) {

				if (parameter.equals("total")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.OneMonthCountryMarket(states);
				} else throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 3) {

				if (parameter.equals("total")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.ThreeMonthsCountryMarket(states);
				} else
					throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
				
			} else if (period == 6) {

				if (parameter.equals("total")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.SixMonthsCountryMarket(states);
				}

				else throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 12) {
				if (parameter.equals("total")) {
					FilterMarketID filter = new FilterMarketID();
					array = filter.OneYearCountryMarket(states);
				} else throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
			} else throw new WrongPeriodException(period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("source")) {

			if (period == 1) {
				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa country.");
			} else if (period == 3) {

				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa country.");
			}

			else if (period == 6) {

				if (parameter.equals("country")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 12) {

				if (parameter.equals("country")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa country.");

			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		} else if (comparator.equals("segment")) {

			if (period == 1) {

				if (parameter.equals("country")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			}

			else if (period == 3) {

				if (parameter.equals("country")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			}

			else if (period == 6) {

				if (parameter.equals("country")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 12) {

				if (parameter.equals("country")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("genre")) {

			if (period == 1) {

				if (parameter.equals("country")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 3) {

				if (parameter.equals("country")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 6) {

				if (parameter.equals("country")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 12) {

				if (parameter.equals("country")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("subgenre")) {

			if (period == 1) {

				if (parameter.equals("country")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 3) {

				if (parameter.equals("country")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 6) {

				if (parameter.equals("country")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else if (period == 12) {

				if (parameter.equals("country")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa country.");

			}

			else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");

		}

		else
			throw new WrongComparatorException(comparator + " non è una stringa ammessa. Inserisci una stringa tra "
					+ "country, market, source, segment, genre o subgenre.");

		return array;
	}

	public JSONArray filterFiller(Vector<String> states, String value, int period) {

		JSONArray array = new JSONArray();

		Iterator<String> iter = states.iterator();

		int j = 0;
		String max = null;
		String min = null;
		int maxevent = 0;
		int minevent = 9999;

		while (iter.hasNext()) {
			JSONObject obj = new JSONObject();
			obj = stats.getGenreEvents(iter.next(), value, period);
			int totalElements = obj.getInt("totalEvents");
			

			JSONObject couple = new JSONObject();
			couple.put("State: ", states.get(j));
			couple.put("Total elements: ", totalElements);
			array.put(couple);
			if (totalElements <= minevent) {
				minevent = totalElements;
				min = states.get(j);
			}
			if (totalElements >= maxevent) {
				maxevent = totalElements;
				max = states.get(j);
			}

			j++;
		}

		JSONObject highest = new JSONObject();
		JSONObject lower = new JSONObject();
		highest.put("Stato con il maggior numero di eventi: ", max);
		highest.put("Numero di eventi: ", maxevent);
		lower.put("Stato con il minor numero di eventi: ", min);
		lower.put("Numero di eventi: ", minevent);
		array.put(highest);
		array.put(lower);

		return array;
	}
}
