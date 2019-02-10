package models.entities.order;

public abstract class AOrder {
	private char action;

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}
	
	public abstract boolean isValidOrder();

}
