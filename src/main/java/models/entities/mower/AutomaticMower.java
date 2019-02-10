package models.entities.mower;

import java.util.List;

import models.entities.field.AField;
import models.entities.order.AOrder;
import models.entities.position.APosition;

public class AutomaticMower extends AMower {
	
	public AutomaticMower(APosition pPosition, AField pField, List<AOrder> pOrders) {
		this.position = pPosition;
		this.field = pField;
		this.orders = pOrders;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	private APosition computeNextPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
