package model.common;

public enum EAvailableActions {
	
	ROTATE_RIGHT('D'),
	
	ROTATE_LEFT('L'),
	
	MOVE_FORWARD('A');
	
	private char action;
	
	EAvailableActions(char pAction) {
		this.action = pAction;
	}
	
	public String toString() {
		return String.valueOf(this.action);
	}
	

}
