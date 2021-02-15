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
	
	@Test
	@DisplayName("Corretta generazione dell'eccezione WrongStateException")
	void WrongStateExceptionTest() {
		
		 WrongStateException e = assertThrows(WrongStateException.class, () -> {stats.getStateEvents("NA", 3);});
		    
	     assertEquals("NA non è un valore ammesso.", e.getMessage());
	}
	
	

}
