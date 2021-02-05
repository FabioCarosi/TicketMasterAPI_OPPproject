/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class WrongCountryCodeException {

String message;
	
	public WrongCountryCodeException(String message) {
		
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
