package model.entity.order;

/**
 * 
 * @author aaudelin
 *
 */
public abstract class AOrder {
	private char action;

	public AOrder(char pAction) {
		this.action = pAction;
	}

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}
}
