/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class WrongCodeException extends Exception {

String message;
	
	public WrongCodeException(String message) {
		
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
