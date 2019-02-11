package model.entity.mower;

import java.util.List;

import exception.EntityException;
import model.entity.field.AField;
import model.entity.order.AOrder;
import model.entity.position.APosition;

public class AutomaticMower extends AMower {

	public AutomaticMower(APosition pPosition, AField pField, List<AOrder> pOrders) {
		this.position = pPosition;
		this.field = pField;
		this.orders = pOrders;
	}

	@Override
	public void move() throws EntityException {
		for (AOrder order : orders) {
			this.setPosition(this.computeNextPosition(order));
		}
	}

	private APosition computeNextPosition(AOrder order) throws EntityException {
		return this.position.computePositionFromOrder(order);
	}

}
