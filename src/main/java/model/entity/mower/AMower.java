package model.entity.mower;

import java.util.List;

import exception.EntityException;
import model.entity.field.AField;
import model.entity.order.AOrder;
import model.entity.position.APosition;

/**
 * 
 * @author aaudelin
 *
 */
public abstract class AMower {

	public APosition position = null;

	public AField field = null;

	public List<AOrder> orders = null;

	/**
	 * Executes all the orders and use the position sensor to understand if the
	 * action is available
	 * 
	 * @throws EntityException
	 */
	public abstract void move() throws EntityException;

	public APosition getPosition() {
		return position;
	}

	public void setPosition(APosition position) {
		this.position = position;
	}

	public AField getField() {
		return field;
	}

	public void setField(AField field) {
		this.field = field;
	}

	public List<AOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<AOrder> orders) {
		this.orders = orders;
	}

}
