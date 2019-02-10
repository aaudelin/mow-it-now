package models.entities.position;

import models.entities.order.AOrder;

public abstract class APosition {
	
	public abstract APosition computePositionFromOrder(AOrder order);
}
