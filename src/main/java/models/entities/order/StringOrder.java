package models.entities.order;

public class StringOrder implements IOrder {

	private char action;

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}
}
