/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class WrongPeriodException extends Exception{
	
	String message;
	
	public WrongPeriodException(String message) {
		
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	

}
