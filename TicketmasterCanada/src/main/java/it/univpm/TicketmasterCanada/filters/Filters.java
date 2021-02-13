package it.univpm.TicketmasterCanada.filters;


import java.util.Vector;

import org.json.JSONArray;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi 
 */

/**
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
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else if (parameter.equals("country")) {
					CountryFilter filter = new CountryFilter();
					array = filter.periodMarketCountry(states,period);
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
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else if (parameter.equals("country")) {
					CountryFilter filter = new CountryFilter();
					array = filter.periodMarketCountry(states,period);
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
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else if (parameter.equals("country")) {
					CountryFilter filter = new CountryFilter();
					array = filter.periodMarketCountry(states,period);
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
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else if (parameter.equals("country")) {
					CountryFilter filter = new CountryFilter();
					array = filter.periodMarketCountry(states,period);
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
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 3) {

				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				} else
					throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
				
			} else if (period == 6) {

				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
				}

				else throw new WrongParameterException(parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 12) {
				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketCountry(states,period);
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
}
