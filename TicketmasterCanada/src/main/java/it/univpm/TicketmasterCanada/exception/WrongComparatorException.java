/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 *
 */
public class WrongComparatorException extends Exception{

	String message;
		
	public WrongComparatorException(String message) {
			
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}

