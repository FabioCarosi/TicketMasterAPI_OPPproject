/**
 * 
 */
package it.univpm.TicketmasterCanada.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class StatsImplementationTest {
	
	StatsImplementation stats;
	
	/**
	 * Inizializza le componenti utili al test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp () throws Exception{
		
		stats = new StatsImplementation();
	}
	/**
	 * Distrugge quello che è stato creato dal setUp
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception{
	}
	
	/**
	 * Test che verifica la corretta esecuzione dell'eccezione WrongStateException.
	 */
	@Test
	@DisplayName("Corretta generazione dell'eccezione WrongStateException")
	void WrongStateExceptionTest() {
		
		 WrongStateException e = assertThrows(WrongStateException.class, () -> {stats.getStateEvents("NA", 3);});
		    
	     assertEquals("NA non è un valore ammesso.", e.getMessage());
	}
	
	/**
	 * Test che verifica la corretta esecuzione dell'eccezione WrongValueException.
	 */
	@Test
	@DisplayName("Corretta generazione dell'eccezione WrongValueException")
	void WrongValueExceptionTest() {
		
		WrongValueException e = assertThrows(WrongValueException.class, () -> {stats.getSegmentEvents("ON", "Ruby", 12);});
		
		assertEquals("Ruby non è un valore ammesso.", e.getMessage());
	}
	
	

}
