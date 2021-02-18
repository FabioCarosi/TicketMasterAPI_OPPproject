package it.univpm.TicketmasterCanada.exception;

import java.util.Vector;


/**
 * Questa classe contiene i metodi utili a riconoscere i valori ammessi dei parametri country, market, segment, 
 * genre, subgenre e source. In caso venga inserita una stringa non ammessa questi metodi richiamano l'opportuna eccezione 
 * 
 * @author Mattia Girolami
 * @author Fabio Carosi
 *
 */

public class SummonException {
		
	/** Questo metodo serve a valutare se il vettore di state inserito dall'utente è ammesso oppure no, ossia se gli stateCode
	 * inseriti appartengono ad uno stato del Canada. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 * 
	 * @param states vettore di state inserito dall'utente all'interno della rotta /filters
	 * @throws WrongStateException se viene inserito il codice di uno stato non canadese.
	 */
    public void stateVectorException(Vector<String> states) throws WrongStateException {
		
		if (!states.contains("BC") && !states.contains("AB") && !states.contains("SK") && !states.contains("MB")
			&& !states.contains("ON") && !states.contains("QC") && !states.contains("NB") && !states.contains("NS")
			&& !states.contains("PE") && !states.contains("NL") && !states.contains("YT") && !states.contains("NT")
			&& !states.contains("NU") && !states.contains("CA"))
			
		 throw new WrongStateException(states + " non è un valore ammesso.");
		
	}
    
    
	/** Questo metodo serve a valutare se il country inserito dall'utente è ammesso oppure no, ossia se il countryCode
	 * inserito appartiene ad un paese europeo. In caso contrario lancia la relativa eccezione     
	 * 
     * @param country paese inserito dall'utente all'interno delle varie rotte di GET
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
     */
    public void stateStringException(String state) throws WrongStateException {
		
		if (!state.equals("BC") && !state.equals("AB") && !state.equals("SK") && !state.equals("MB")
			&& !state.equals("ON") && !state.equals("QC") && !state.equals("NB") && !state.equals("NS")
			&& !state.equals("PE") && !state.equals("NL") && !state.equals("YT") && !state.equals("NT")
			&& !state.equals("NU") && !state.equals("CA"))
				
			 throw new WrongStateException(state + " non è un valore ammesso.");

	}
    
    
	/** Questo metodo serve a valutare se il vettore di market inserito dall'utente è ammesso oppure no, ossia se i marketId
	 * inseriti appartengono ad un paese europeo. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 * 
	 * @param marketsId vettore di market inserito dall'utente all'interno della rotta /filters
	 * @throws WrongValueException se viene inserito un market non ammesso
     */
    public void marketVectorException(Vector<String> marketsId) throws WrongValueException {
    	
    	if (!marketsId.contains("102") && !marketsId.contains("103") && !marketsId.contains("106") && !marketsId.contains("107")
    		&& !marketsId.contains("108") && !marketsId.contains("110") && !marketsId.contains("111") && !marketsId.contains("112")
    		&& !marketsId.contains("120")) 
    		
		throw new WrongValueException(marketsId + " non è un valore ammesso.");
    	
    }
    
    
	/** Questo metodo serve a valutare se il market inserito dall'utente è ammesso oppure no, ossia se il marketId
	 * inserito appartiene ad un paese europeo. In caso contrario lancia la relativa eccezione     
	 * 
     * @param marketId market inserito dall'utente all'interno delle varie rotte di GET
	 * @throws WrongValueException se viene inserito un market non ammesso
     */
    public void marketStringException(String marketId) throws WrongValueException {
    	
    	if (!marketId.equals("102") && !marketId.equals("103") && !marketId.equals("106") && !marketId.equals("107")
        		&& !marketId.equals("108") && !marketId.equals("110") && !marketId.equals("111") && !marketId.equals("112")
        		&& !marketId.equals("120"))
    		
		throw new WrongValueException(marketId + " non è un valore ammesso.");
    	
    }
    
    
	/** Questo metodo serve a valutare se il vettore di segment inserito dall'utente è ammesso oppure no, ossia se i segment
	 * inseriti siano validi. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 *      
	 * @param segments vettore di segment inserito dall'utente all'interno della rotta /filters
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
     */
    public void segmentVectorException(Vector<String> segments) throws WrongValueException {
    	
    	if (!segments.contains("Arts") && !segments.contains("Miscellaneous") && !segments.contains("Music") 
    		&& !segments.contains("Sports") && !segments.contains("KZFzniwn")) 
    		
    		throw new WrongValueException(segments + " non è un valore ammesso.");

    }
    
    
	/** Questo metodo serve a valutare se il segment inserito dall'utente è ammesso oppure no.
	 * In caso contrario lancia la relativa eccezione     
	 * 
     * @param segment tipologia inserita dall'utente all'interno delle varie rotte di GET
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
     */
    public void segmentStringException(String segment) throws WrongValueException {
    	
    	if (!segment.equals("Arts") && !segment.equals("Miscellaneous") && !segment.equals("Music") 
    		&& !segment.equals("Sports")&& !segment.contains("KZFzniwn"))
    		
		throw new WrongValueException(segment + " non è un valore ammesso.");

    }
    
	
	/** Questo metodo serve a valutare se il vettore di genre inserito dall'utente è ammesso oppure no, ossia se i genre
	 * inseriti siano validi. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 *      
	 * @param genres vettore di genre inserito dall'utente all'interno della rotta /filters
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso
     */
	public void genreVectorException(Vector<String> genres) throws WrongValueException {

		if (!genres.contains("Alternative") && !genres.contains("Aquatics") && !genres.contains("Athletic Races")
				&& !genres.contains("Basketball") && !genres.contains("Blues") && !genres.contains("Boxing")
				&& !genres.contains("Children's Theatre") && !genres.contains("Circus & Specialty Acts")
				&& !genres.contains("Classical") && !genres.contains("Comedy") && !genres.contains("Community/Civic")
				&& !genres.contains("Country") && !genres.contains("Cricket") && !genres.contains("Cycling")
				&& !genres.contains("Dance") && !genres.contains("Dance/Electronic") && !genres.contains("Equestrian")
				&& !genres.contains("Family") && !genres.contains("Fashion") && !genres.contains("Folk")
				&& !genres.contains("Hip-Hop/Rap") && !genres.contains("Hobby/Special Interest Expos")
				&& !genres.contains("Ice Shows") && !genres.contains("Jazz") && !genres.contains("Magic & Illusion")
				&& !genres.contains("Martial Arts") && !genres.contains("Metal") && !genres.contains("Miscellaneous")
				&& !genres.contains("Miscellaneous Theatre") && !genres.contains("Motorsports/Racing")
				&& !genres.contains("Musical") && !genres.contains("Performance Art") && !genres.contains("Pop")
				&& !genres.contains("Reggae") && !genres.contains("Rock") && !genres.contains("Rugby")
				&& !genres.contains("R&B") && !genres.contains("Spectacular") && !genres.contains("Theatre")
				&& !genres.contains("Undefined") && !genres.contains("Variety") && !genres.contains("Volleyball")
				&& !genres.contains("World") && !genres.contains("Wrestling") && !genres.contains("KnvZfZ7vAvv")
				&& !genres.contains("KnvZfZ7v"))

			throw new WrongValueException(genres + " non è un valore ammesso.");

	}
	
	
	/** Questo metodo serve a valutare se il genre inserito dall'utente è ammesso oppure no.
	 * In caso contrario lancia la relativa eccezione     
	 * 
     * @param genre genere inserito dall'utente all'interno delle varie rotte di GET
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso
	 */
	public void genreStringException(String genre) throws WrongValueException {

		if (!genre.equals("Alternative") && !genre.equals("Aquatics") && !genre.equals("Athletic Races")
				&& !genre.equals("Basketball") && !genre.equals("Blues") && !genre.equals("Boxing")
				&& !genre.equals("Children's Theatre") && !genre.equals("Circus & Specialty Acts")
				&& !genre.equals("Classical") && !genre.equals("Comedy") && !genre.equals("Community/Civic")
				&& !genre.equals("Country") && !genre.equals("Cricket") && !genre.equals("Cycling")
				&& !genre.equals("Dance") && !genre.equals("Dance/Electronic") && !genre.equals("Equestrian")
				&& !genre.equals("Family") && !genre.equals("Fashion") && !genre.equals("Folk")
				&& !genre.equals("Hip-Hop/Rap") && !genre.equals("Hobby/Special Interest Expos")
				&& !genre.equals("Ice Shows") && !genre.equals("Jazz") && !genre.equals("Magic & Illusion")
				&& !genre.equals("Martial Arts") && !genre.equals("Metal") && !genre.equals("Miscellaneous")
				&& !genre.equals("Miscellaneous Theatre") && !genre.equals("Motorsports/Racing")
				&& !genre.equals("Musical") && !genre.equals("Performance Art") && !genre.equals("Pop")
				&& !genre.equals("Reggae") && !genre.equals("Rock") && !genre.equals("Rugby") && !genre.equals("R&B")
				&& !genre.equals("Spectacular") && !genre.equals("Theatre") && !genre.equals("Undefined")
				&& !genre.equals("Variety") && !genre.equals("Volleyball") && !genre.equals("World")
				&& !genre.equals("Wrestling") && !genre.equals("Wrestling") && !genre.equals("KnvZfZ7vAvv")
				&& !genre.contains("KnvZfZ7v"))

			throw new WrongValueException(genre + " non è un valore ammesso.");

	}
    
    
	/** Questo metodo serve a valutare se il vettore di subGenre inserito dall'utente è ammesso oppure no, ossia se i subGenre
	 * inseriti siano validi. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 *      
	 * @param subGenres vettore di subGenre inserito dall'utente all'interno della rotta /filters
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso 
	 */
	public void subgenreVectorException(Vector<String> subGenres) throws WrongValueException {

		if (!subGenres.contains("Adult Contemporary") && !subGenres.contains("Alternative")
				&& !subGenres.contains("Alternative Rock") && !subGenres.contains("Aquatics")
				&& !subGenres.contains("Athletic Races") && !subGenres.contains("Blues")
				&& !subGenres.contains("Blues-Rock") && !subGenres.contains("Boxing")
				&& !subGenres.contains("British Folk-Rock") && !subGenres.contains("Burlesque")
				&& !subGenres.contains("Cabaret") && !subGenres.contains("Children's Theatre")
				&& !subGenres.contains("Circus") && !subGenres.contains("Classical/Vocal")
				&& !subGenres.contains("Club Dance") && !subGenres.contains("Comedy")
				&& !subGenres.contains("Community/Civic") && !subGenres.contains("Country")
				&& !subGenres.contains("Cricket") && !subGenres.contains("Cycling") && !subGenres.contains("Dance")
				&& !subGenres.contains("Disco") && !subGenres.contains("Drama") && !subGenres.contains("Dressage")
				&& !subGenres.contains("Equestrian") && !subGenres.contains("European Pop")
				&& !subGenres.contains("Fashion") && !subGenres.contains("Folk") && !subGenres.contains("French Rap")
				&& !subGenres.contains("Hard Rock") && !subGenres.contains("Heavy Metal")
				&& !subGenres.contains("Hobby/Special Interest Expos") && !subGenres.contains("Ice Shows")
				&& !subGenres.contains("Indie Pop") && !subGenres.contains("Indie Rock") && !subGenres.contains("Jazz")
				&& !subGenres.contains("Latin") && !subGenres.contains("Magic")
				&& !subGenres.contains("Men Professional") && !subGenres.contains("Metalcore")
				&& !subGenres.contains("Miscellaneous") && !subGenres.contains("Miscellaneous Theatre")
				&& !subGenres.contains("Mixed Martial Arts") && !subGenres.contains("Nu-Metal")
				&& !subGenres.contains("Other") && !subGenres.contains("Performance Art") && !subGenres.contains("Pop")
				&& !subGenres.contains("Rap-Rock") && !subGenres.contains("Reggae")
				&& !subGenres.contains("Rugby Union") && !subGenres.contains("Rock")
				&& !subGenres.contains("Rock & Roll") && !subGenres.contains("R&B")
				&& !subGenres.contains("Scandinavia") && !subGenres.contains("Soul")
				&& !subGenres.contains("Southern Rock") && !subGenres.contains("Spectacular")
				&& !subGenres.contains("Undefined") && !subGenres.contains("Urban") && !subGenres.contains("Variety")
				&& !subGenres.contains("Volleyball") && !subGenres.contains("Witchstep") && !subGenres.contains("World")
				&& !subGenres.contains("Wrestling") && !subGenres.contains("KZazBEonSMnZfZ7vk1l")
				&& !subGenres.contains("KZazBEonSMnZfZ7"))

			throw new WrongValueException(subGenres + " non è un valore ammesso.");

	}
    
    
	/** Questo metodo serve a valutare se il subGenre inserito dall'utente è ammesso oppure no.
	 * In caso contrario lancia la relativa eccezione     
	 * 
     * @param subGenre sottogenere inserito dall'utente all'interno delle varie rotte di GET
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso 
     */
	public void subgenreStringException(String subGenre) throws WrongValueException {

		if (!subGenre.equals("Adult Contemporary") && !subGenre.equals("Alternative")
				&& !subGenre.equals("Alternative Rock") && !subGenre.equals("Aquatics")
				&& !subGenre.equals("Athletic Races") && !subGenre.equals("Blues") && !subGenre.equals("Blues-Rock")
				&& !subGenre.equals("Boxing") && !subGenre.equals("British Folk-Rock") && !subGenre.equals("Burlesque")
				&& !subGenre.equals("Cabaret") && !subGenre.equals("Children's Theatre") && !subGenre.equals("Circus")
				&& !subGenre.equals("Classical/Vocal") && !subGenre.equals("Club Dance") && !subGenre.equals("Comedy")
				&& !subGenre.equals("Community/Civic") && !subGenre.equals("Country") && !subGenre.equals("Cricket")
				&& !subGenre.equals("Cycling") && !subGenre.equals("Dance") && !subGenre.equals("Disco")
				&& !subGenre.equals("Drama") && !subGenre.equals("Dressage") && !subGenre.equals("Equestrian")
				&& !subGenre.equals("European Pop") && !subGenre.equals("Fashion") && !subGenre.equals("Folk")
				&& !subGenre.equals("French Rap") && !subGenre.equals("Hard Rock") && !subGenre.equals("Heavy Metal")
				&& !subGenre.equals("Hobby/Special Interest Expos") && !subGenre.equals("Ice Shows")
				&& !subGenre.equals("Indie Pop") && !subGenre.equals("Indie Rock") && !subGenre.equals("Jazz")
				&& !subGenre.equals("Latin") && !subGenre.equals("Magic") && !subGenre.equals("Men Professional")
				&& !subGenre.equals("Metalcore") && !subGenre.equals("Miscellaneous")
				&& !subGenre.equals("Miscellaneous Theatre") && !subGenre.equals("Mixed Martial Arts")
				&& !subGenre.equals("Musical") && !subGenre.equals("Nu-Metal") && !subGenre.equals("Other")
				&& !subGenre.equals("Performance Art") && !subGenre.equals("Pop") && !subGenre.equals("Rap-Rock")
				&& !subGenre.equals("Reggae") && !subGenre.equals("Rugby Union") && !subGenre.equals("Rock")
				&& !subGenre.equals("Rock & Roll") && !subGenre.equals("R&B") && !subGenre.equals("Scandinavia")
				&& !subGenre.equals("Soul") && !subGenre.equals("Southern Rock") && !subGenre.equals("Spectacular")
				&& !subGenre.equals("Undefined") && !subGenre.equals("Urban") && !subGenre.equals("Variety")
				&& !subGenre.equals("Volleyball") && !subGenre.equals("Witchstep") && !subGenre.equals("World")
				&& !subGenre.equals("Wrestling") && !subGenre.equals("KZazBEonSMnZfZ7vk1l")
				&& !subGenre.contains("KZazBEonSMnZfZ7"))

			throw new WrongValueException(subGenre + " non è un valore ammesso.");

	}

    
	/** Questo metodo serve a valutare se il vettore di source inserito dall'utente è ammesso oppure no, ossia se i source
	 * inseriti siano validi. Nel caso in cui uno di questi non sia ammesso viene lanciata la relativa eccezione
	 *      
	 * @param sources vettore di source inserito dall'utente all'interno della rotta /filters
	 * @throws WrongValueException se viene inserito un distributore non ammesso
     */
    public void sourceVectorException(Vector<String> sources) throws WrongValueException {
    	
    	if (!sources.contains("ticketmaster") && !sources.contains("universe") && !sources.contains("frontgate") 
    		&& !sources.contains("tmr"))
    		
		throw new WrongValueException(sources + " non è un valore ammesso.");

    }
    
    
	/** Questo metodo serve a valutare se il distributore inserito dall'utente è ammesso oppure no.
	 * In caso contrario lancia la relativa eccezione     
	 * 
     * @param source distributore inserito dall'utente all'interno delle varie rotte di GET
	 * @throws WrongValueException se viene inserito un distributore non ammesso
     */
    public void sourceStringException(String source) throws WrongValueException {
    	
    	if (!source.equals("ticketmaster") && !source.equals("universe") && !source.equals("frontgate") && !source.equals("tmr"))
    		
		throw new WrongValueException(source + " non è un valore ammesso.");

    }
    
}
