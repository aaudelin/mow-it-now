package model.entity.position;

import model.entity.order.AOrder;

public abstract class APosition {
	
	public abstract APosition computePositionFromOrder(AOrder order);
}
