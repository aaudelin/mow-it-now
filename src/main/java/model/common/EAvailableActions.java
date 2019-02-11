package model.common;

public enum EAvailableActions {

	ROTATE_RIGHT('D'),

	ROTATE_LEFT('G'),

	MOVE_FORWARD('A');

	private char action;

	EAvailableActions(char pAction) {
		this.action = pAction;
	}

	public String toString() {
		return String.valueOf(this.action);
	}

	public char getAction() {
		return action;
	}

	public static boolean isValidAction(char action) {
		for (EAvailableActions validAction : EAvailableActions.values()) {
			if (validAction.getAction() == action) {
				return true;
			}
		}
		return false;

	}

	public static boolean isRotation(char action) {
		return ROTATE_LEFT.getAction() == action || ROTATE_RIGHT.getAction() == action;
	}

	public static boolean isMovement(char action) {
		return MOVE_FORWARD.getAction() == action;
	}

}
