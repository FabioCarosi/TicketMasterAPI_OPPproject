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
    		&& !segments.contains("Sports")) 
    		
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
    		&& !segment.equals("Sports"))
    		
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
				&& !genres.contains("KnvZfZ7vAeI") && !genres.contains("KnvZfZ7vAet") && !genres.contains("KnvZfZ7vAde")
				&& !genres.contains("KnvZfZ7vAvd") && !genres.contains("KnvZfZ7vAdA") && !genres.contains("KnvZfZ7v7na")
				&& !genres.contains("KnvZfZ7v7n1") && !genres.contains("KnvZfZ7vAeJ") && !genres.contains("KnvZfZ7vAe1")
				&& !genres.contains("KnvZfZ7vAAE") && !genres.contains("KnvZfZ7vAv6") && !genres.contains("KnvZfZ7vAdk")
				&& !genres.contains("KnvZfZ7vAda") && !genres.contains("KnvZfZ7v7nI") && !genres.contains("KnvZfZ7vAvF")
				&& !genres.contains("KnvZfZ7vAd1") && !genres.contains("KnvZfZ7vA1n") && !genres.contains("KnvZfZ7v7nn")
				&& !genres.contains("KnvZfZ7vAva") && !genres.contains("KnvZfZ7vAv1") && !genres.contains("KnvZfZ7vAAJ")
				&& !genres.contains("KnvZfZ7v7lI") && !genres.contains("KnvZfZ7vAvE") && !genres.contains("KnvZfZ7v7lv")
				&& !genres.contains("KnvZfZ7vA7d") && !genres.contains("KnvZfZ7vAvt") && !genres.contains("KnvZfZ7vA7A")
				&& !genres.contains("KnvZfZ7v7ld") && !genres.contains("KnvZfZ7vA7k") && !genres.contains("KnvZfZ7v7l6")
				&& !genres.contains("KnvZfZ7vAev") && !genres.contains("KnvZfZ7vAed") && !genres.contains("KnvZfZ7vAeA")
				&& !genres.contains("KnvZfZ7vA71") && !genres.contains("KnvZfZ7vAee") && !genres.contains("KnvZfZ7v7la")
				&& !genres.contains("KnvZfZ7v7l1") && !genres.contains("KnvZfZ7v7ll") && !genres.contains("KnvZfZ7v7lJ")
				&& !genres.contains("KnvZfZ7vAA7") && !genres.contains("KnvZfZ7vAeF") && !genres.contains("KnvZfZ7vAAk")
				&& !genres.contains("KnvZfZ7v7l1"))

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
				&& !genre.equals("KnvZfZ7vAeI") && !genre.equals("KnvZfZ7vAet") && !genre.equals("KnvZfZ7vAde")
				&& !genre.equals("KnvZfZ7vAvd") && !genre.equals("KnvZfZ7vAdA") && !genre.equals("KnvZfZ7v7na")
				&& !genre.equals("KnvZfZ7v7n1") && !genre.equals("KnvZfZ7vAeJ") && !genre.equals("KnvZfZ7vAe1")
				&& !genre.equals("KnvZfZ7vAAE") && !genre.equals("KnvZfZ7vAv6") && !genre.equals("KnvZfZ7vAdk")
				&& !genre.equals("KnvZfZ7vAda") && !genre.equals("KnvZfZ7v7nI") && !genre.equals("KnvZfZ7vAvF")
				&& !genre.equals("KnvZfZ7v7l1") && !genre.equals("KnvZfZ7vAd1") && !genre.equals("KnvZfZ7vA1n")
				&& !genre.equals("KnvZfZ7v7nn") && !genre.equals("KnvZfZ7vAva") && !genre.equals("KnvZfZ7vAv1")
				&& !genre.equals("KnvZfZ7vAAJ") && !genre.equals("KnvZfZ7v7lI") && !genre.equals("KnvZfZ7vAvE")
				&& !genre.equals("KnvZfZ7v7lv") && !genre.equals("KnvZfZ7vA7d") && !genre.equals("KnvZfZ7vAvt")
				&& !genre.equals("KnvZfZ7vA7A") && !genre.equals("KnvZfZ7v7ld") && !genre.equals("KnvZfZ7vA7k")
				&& !genre.equals("KnvZfZ7v7l6") && !genre.equals("KnvZfZ7vAev") && !genre.equals("KnvZfZ7vAed")
				&& !genre.equals("KnvZfZ7vAeA") && !genre.equals("KnvZfZ7vA71") && !genre.equals("KnvZfZ7vAee")
				&& !genre.equals("KnvZfZ7v7la") && !genre.equals("KnvZfZ7v7l1") && !genre.equals("KnvZfZ7v7ll")
				&& !genre.equals("KnvZfZ7v7lJ") && !genre.equals("KnvZfZ7vAA7") && !genre.equals("KnvZfZ7vAeF")
				&& !genre.equals("KnvZfZ7vAAk"))

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
				&& !subGenres.contains("KZazBEonSMnZfZ7vAvJ") && !subGenres.contains("KZazBEonSMnZfZ7v6dt")
				&& !subGenres.contains("KZazBEonSMnZfZ7vF1a") && !subGenres.contains("KZazBEonSMnZfZ7vF11")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAAd") && !subGenres.contains("KZazBEonSMnZfZ7v676")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFJJ") && !subGenres.contains("KZazBEonSMnZfZ7v671")
				&& !subGenres.contains("KZazBEonSMnZfZ7vaaE") && !subGenres.contains("KZazBEonSMnZfZ7vAv7")
				&& !subGenres.contains("KZazBEonSMnZfZ7v7na") && !subGenres.contains("KZazBEonSMnZfZ7v7n1")
				&& !subGenres.contains("KZazBEonSMnZfZ7vF1A") && !subGenres.contains("KZazBEonSMnZfZ7vAJ1")
				&& !subGenres.contains("KZazBEonSMnZfZ7vF17") && !subGenres.contains("KZazBEonSMnZfZ7vFlv")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAFa") && !subGenres.contains("KZazBEonSMnZfZ7vFJE")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFEv") && !subGenres.contains("KZazBEonSMnZfZ7v7nl")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAJn") && !subGenres.contains("KZazBEonSMnZfZ7v7lt")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFEe") && !subGenres.contains("KZazBEonSMnZfZ7vFEd")
				&& !subGenres.contains("KZazBEonSMnZfZ7v6At") && !subGenres.contains("KZazBEonSMnZfZ7v7le")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAn7") && !subGenres.contains("KZazBEonSMnZfZ7vaa1")
				&& !subGenres.contains("KZazBEonSMnZfZ7v6kl") && !subGenres.contains("KZazBEonSMnZfZ7vkFd")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFnl") && !subGenres.contains("KZazBEonSMnZfZ7vAv6")
				&& !subGenres.contains("KZazBEonSMnZfZ7vkEk") && !subGenres.contains("KZazBEonSMnZfZ7vAde")
				&& !subGenres.contains("KZazBEonSMnZfZ7vkda") && !subGenres.contains("KZazBEonSMnZfZ7vFdJ")
				&& !subGenres.contains("KZazBEonSMnZfZ7v7l7") && !subGenres.contains("KZazBEonSMnZfZ7vFJ6")
				&& !subGenres.contains("KZazBEonSMnZfZ7vaJk") && !subGenres.contains("KZazBEonSMnZfZ7vFIt")
				&& !subGenres.contains("KZazBEonSMnZfZ7v7lk") && !subGenres.contains("KZazBEonSMnZfZ7vFIE")
				&& !subGenres.contains("KZazBEonSMnZfZ7vaJ6") && !subGenres.contains("KZazBEonSMnZfZ7vaav")
				&& !subGenres.contains("KZazBEonSMnZfZ7v7l1") && !subGenres.contains("KZazBEonSMnZfZ7v6F1")
				&& !subGenres.contains("KZazBEonSMnZfZ7vkel") && !subGenres.contains("KZazBEonSMnZfZ7vknl")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFtJ") && !subGenres.contains("KZazBEonSMnZfZ7v6da")
				&& !subGenres.contains("KZazBEonSMnZfZ7v6an") && !subGenres.contains("KZazBEonSMnZfZ7vkIt")
				&& !subGenres.contains("KZazBEonSMnZfZ7vF6E") && !subGenres.contains("KZazBEonSMnZfZ7vknE")
				&& !subGenres.contains("KZazBEonSMnZfZ7v61J") && !subGenres.contains("KZazBEonSMnZfZ7v7lE")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAv1") && !subGenres.contains("KZazBEonSMnZfZ7vkdA")
				&& !subGenres.contains("KZazBEonSMnZfZ7vAvA") && !subGenres.contains("KZazBEonSMnZfZ7vFn6")
				&& !subGenres.contains("KZazBEonSMnZfZ7va1k") && !subGenres.contains("KZazBEonSMnZfZ7v6Jt")
				&& !subGenres.contains("KZazBEonSMnZfZ7vFna"))

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
				&& !subGenre.equals("KZazBEonSMnZfZ7vAvJ") && !subGenre.equals("KZazBEonSMnZfZ7v6dt")
				&& !subGenre.equals("KZazBEonSMnZfZ7vF1a") && !subGenre.equals("KZazBEonSMnZfZ7vF11")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAAd") && !subGenre.equals("KZazBEonSMnZfZ7v676")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFJJ") && !subGenre.equals("KZazBEonSMnZfZ7v671")
				&& !subGenre.equals("KZazBEonSMnZfZ7vaaE") && !subGenre.equals("KZazBEonSMnZfZ7vAv7")
				&& !subGenre.equals("KZazBEonSMnZfZ7v7na") && !subGenre.equals("KZazBEonSMnZfZ7v7n1")
				&& !subGenre.equals("KZazBEonSMnZfZ7vF1A") && !subGenre.equals("KZazBEonSMnZfZ7vAJ1")
				&& !subGenre.equals("KZazBEonSMnZfZ7vF17") && !subGenre.equals("KZazBEonSMnZfZ7vFlv")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAFa") && !subGenre.equals("KZazBEonSMnZfZ7vFJE")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFEv") && !subGenre.equals("KZazBEonSMnZfZ7v7nl")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAJn") && !subGenre.equals("KZazBEonSMnZfZ7v7lt")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFEe") && !subGenre.equals("KZazBEonSMnZfZ7vFEd")
				&& !subGenre.equals("KZazBEonSMnZfZ7v6At") && !subGenre.equals("KZazBEonSMnZfZ7v7le")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAn7") && !subGenre.equals("KZazBEonSMnZfZ7vaa1")
				&& !subGenre.equals("KZazBEonSMnZfZ7v6kl") && !subGenre.equals("KZazBEonSMnZfZ7vkFd")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFnl") && !subGenre.equals("KZazBEonSMnZfZ7vAv6")
				&& !subGenre.equals("KZazBEonSMnZfZ7vkEk") && !subGenre.equals("KZazBEonSMnZfZ7vAde")
				&& !subGenre.equals("KZazBEonSMnZfZ7vkda") && !subGenre.equals("KZazBEonSMnZfZ7vFdJ")
				&& !subGenre.equals("KZazBEonSMnZfZ7v7l7") && !subGenre.equals("KZazBEonSMnZfZ7vFJ6")
				&& !subGenre.equals("KZazBEonSMnZfZ7vaJk") && !subGenre.equals("KZazBEonSMnZfZ7vFIt")
				&& !subGenre.equals("KZazBEonSMnZfZ7v7lk") && !subGenre.equals("KZazBEonSMnZfZ7vFIE")
				&& !subGenre.equals("KZazBEonSMnZfZ7vaJ6") && !subGenre.equals("KZazBEonSMnZfZ7vaav")
				&& !subGenre.equals("KZazBEonSMnZfZ7v7l1") && !subGenre.equals("KZazBEonSMnZfZ7v6F1")
				&& !subGenre.equals("KZazBEonSMnZfZ7vkel") && !subGenre.equals("KZazBEonSMnZfZ7vknl")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFtJ") && !subGenre.equals("KZazBEonSMnZfZ7v6da")
				&& !subGenre.equals("KZazBEonSMnZfZ7v6an") && !subGenre.equals("KZazBEonSMnZfZ7vkIt")
				&& !subGenre.equals("KZazBEonSMnZfZ7vF6E") && !subGenre.equals("KZazBEonSMnZfZ7vknE")
				&& !subGenre.equals("KZazBEonSMnZfZ7v61J") && !subGenre.equals("KZazBEonSMnZfZ7v7lE")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAv1") && !subGenre.equals("KZazBEonSMnZfZ7vkdA")
				&& !subGenre.equals("KZazBEonSMnZfZ7vAvA") && !subGenre.equals("KZazBEonSMnZfZ7vFn6")
				&& !subGenre.equals("KZazBEonSMnZfZ7va1k") && !subGenre.equals("KZazBEonSMnZfZ7v6Jt")
				&& !subGenre.equals("KZazBEonSMnZfZ7vFna"))

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
