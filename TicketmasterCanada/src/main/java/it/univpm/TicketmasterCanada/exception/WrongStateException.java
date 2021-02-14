/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class WrongStateException extends Exception{
	
	String message;

	public WrongStateException(String message) {

		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
