/**
 * 
 */
package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class State {
	
	private String stateCode; 	//rappresenta l'abbreviazione del territorio (es. AB, MB...)
	private String stateName; 	//rappresenta il nome del territorio (es. Alberta, Manitoba...)
	
	/**
	 * Metodo che restituisce il:
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	
	/**
	 * Metodo che setta il:
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	/**
	 * Metodo che restituisce il:
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	
	/**
	 * Metodo che setta il:
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param stateCode
	 * @param stateName
	 */
	public State(String stateCode, String stateName) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
	}
	
	/**
	 * Costruttore con parametro:
	 * @param stateCode
	 */
	public State(String stateCode) {
		super();
		this.stateCode = stateCode;
		this.stateName = null;
	}
	

	/**
	 * Costruttore vuoto.
	 */
	public State() {
		super();
		this.stateCode = null;
		this.stateName = null;
	}
	
	/**
	 * Override del metodo toString.
	 */
	@Override
	public String toString() {
		return "State stateCode=" + stateCode + ", stateName=" + stateName;
	}

	/**
	 * Override del metodo equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}
	
}
