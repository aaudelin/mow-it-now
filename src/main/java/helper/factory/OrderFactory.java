package helper.factory;

import java.util.ArrayList;
import java.util.List;

import model.common.EAvailableActions;
import model.entity.order.AOrder;
import model.entity.order.MoveOrder;
import model.entity.order.RotateOrder;

public class OrderFactory {

	public static List<AOrder> createOrderList(String order) throws OrderException {
		List<AOrder> orders = new ArrayList<AOrder>();
		for (char orderChar : order.toCharArray()) {
			if (EAvailableActions.isMovement(orderChar)) {
				orders.add(new MoveOrder());
			} else if (EAvailableActions.isRotation(orderChar)) {
				orders.add(new RotateOrder());
			} else {
				throw new OrderException("Impossible to save all orders : action invalid " + orderChar);
			}
		}
		return orders;
	}

}
