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
public class AutomaticMower extends AMower {

	public AutomaticMower(APosition pPosition, AField pField, List<AOrder> pOrders) {
		this.position = pPosition;
		this.field = pField;
		this.orders = pOrders;
	}

	@Override
	public void move() throws EntityException {
		for (AOrder order : orders) {
			APosition position = this.computeNextPosition(order);
			if (position.isIncludedInField(this.getField())) {
				this.setPosition(position);
			}
		}
	}

	/**
	 * Use the position sensor to compute where the next position should be
	 * 
	 * @param order the order to treat
	 * @return the estimated next position
	 * @throws EntityException
	 */
	private APosition computeNextPosition(AOrder order) throws EntityException {
		return this.position.computePositionFromOrder(order);
	}

}
