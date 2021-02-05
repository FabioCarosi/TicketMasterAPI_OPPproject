/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */
public class WrongPeriodException extends Exception{
	
	String messagex;
	
	public WrongPeriodException(String messagex) {
		
		this.messagex = messagex;
	}

	/**
	 * @return the message
	 */
	public String getMessagex() {
		return messagex;
	}
	

}
