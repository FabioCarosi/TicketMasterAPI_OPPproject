/**
 * 
 */
package it.univpm.TicketmasterCanada.files;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class GetImportantEventsTest {
	
	GetImportantEvents file;
	
	@BeforeEach
	void setUp() throws Exception {
		file = new GetImportantEvents();
		}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("Salvataggio del file avvenuto in modo corretto")
	void fileSaver() throws IOException {
		
		String countryCode = "CA";
		
		String segment = "Sports";
		
		String nomeDirectory = "Most_important_event";

		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;

		String nomeFile = "CA" + "_Most_Important_Event";

		String pathFile = pathDirectory + "/" + nomeFile + ".txt";
		
		File filex = new File(pathFile);
 
		try{
			if (!filex.exists()) {
				filex.createNewFile();
			}
		} catch (IOException e) {
			System.out.println(e);
		}		
		assertEquals(pathFile, file.SaveImportantCountryEvents(countryCode, segment));			
	}
	
	
	@Test
	@DisplayName("Creazione della directory avvenuta in modo corretto")
	void directorySaver() throws IOException {
		
		String countryCode = "CA";
		
		String segment = "Sports";
		
		String path = file.SaveImportantCountryEvents(countryCode, segment);
		
		path.replaceAll("/CA_Most_Important_Event", "");
				
		assertEquals(path, file.SaveImportantCountryEvents(countryCode, segment));
		
	}
}
