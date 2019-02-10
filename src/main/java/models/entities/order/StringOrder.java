package models.entities.order;

public class StringOrder extends AOrder {

	private char action;

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}

	@Override
	public boolean isValidOrder() {
		// TODO Auto-generated method stub
		return false;
	}
}
