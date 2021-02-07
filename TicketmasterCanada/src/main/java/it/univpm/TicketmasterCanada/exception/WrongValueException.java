/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 *
 */
public class WrongValueException extends Exception {

	String message;
	
	public WrongValueException(String message) {
		
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
