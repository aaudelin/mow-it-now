package models.entities.mower;

import java.util.List;

import models.entities.field.AField;
import models.entities.order.AOrder;
import models.entities.position.APosition;

public abstract class AMower {
	
	public APosition position = null;
	
	public AField field = null;
	
	public List<AOrder> orders = null;
	
	public abstract void move();

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
