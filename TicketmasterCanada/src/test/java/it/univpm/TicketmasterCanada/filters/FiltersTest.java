package it.univpm.TicketmasterCanada.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.TicketmasterCanada.exception.*;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class FiltersTest {
	
	public Filters filters;
	private Vector<String> elements;
	
	/**
    * Inizializza le componenti utili al test.
    * @throws java.lang.Exception
    */
	@BeforeEach
	void setUp() throws Exception {
		elements = new Vector<String>();
	}
	
	/**
     * Serve per distruggere ciò che è stato creato dal setUp.
     * @throws java.lang.Exception
     */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Questo Test verifica se viene generata correttamente l'eccezione WrongPeriod.
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongPeriodException.")
    void filtersImplementation_WrongPeriod() {
		
    	elements.add("ON");
        elements.add("MB");
        
        filters = new Filters("country" ,elements, "segment", "Music", 13);
    	
        WrongPeriodException e = assertThrows(WrongPeriodException.class, () -> {filters.filtersImplementation();});
    
        assertEquals("13 non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12", e.getMessage());
        
    }
	
    /**
	 * Questo Test verifica se viene generata correttamente l'eccezione WrongParameter.
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongParameterException.")
    void filtersImplementation_WrongParameter() {
		
    	elements.add("ON");
        elements.add("MB");
        
        filters = new Filters("country" ,elements, "Tipologia", "Music", 12);
    	
        WrongParameterException e = assertThrows(WrongParameterException.class, () -> {filters.filtersImplementation();});
    
        assertEquals("Tipologia non è accettato. Scegli tra: marketID, source, segment, genre e subgenre.", e.getMessage());
        
    }
    
    /**
	 * Questo Test verifica se viene generata correttamente l'eccezione WrongComparator.
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongComparatorException.")
    void filtersImplementation_WrongComparator() {
		
    	elements.add("ON");
        elements.add("MB");
        
        filters = new Filters("Paccasassi" ,elements, "segment", "Music", 12);
    	
        WrongComparatorException e = assertThrows(WrongComparatorException.class, () -> {filters.filtersImplementation();});
    
        assertEquals("Paccasassi non è una stringa ammessa. Inserisci una stringa tra country, market, source, segment, genre o subgenre.", e.getMessage());    
    }
    
    
	
	

}
