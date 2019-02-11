package helper.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import exception.OrderException;
import model.entity.order.AOrder;
import model.entity.order.MoveOrder;
import model.entity.order.RotateOrder;

public class OrderFactoryTest {

	@Test(expected = OrderException.class)
	public void testInvalidSingleOrder() throws Exception {
		OrderFactory.createOrderList("X");
	}

	@Test(expected = OrderException.class)
	public void testInvalidMultipleOrders() throws Exception {
		OrderFactory.createOrderList("AADGXIIJ");
	}

	@Test
	public void testValidOrders() throws Exception {
		char orderMove = 'A';
		char orderRotateLeft = 'G';
		char orderRotateRight = 'D';
		StringBuilder builder = new StringBuilder();
		builder.append(orderMove);
		builder.append(orderRotateLeft);
		builder.append(orderRotateRight);

		List<AOrder> orders = OrderFactory.createOrderList(builder.toString());

		assertEquals(3, orders.size());
		assertTrue(orders.get(0) instanceof MoveOrder);
		assertEquals(orderMove, orders.get(0).getAction());
		assertTrue(orders.get(1) instanceof RotateOrder);
		assertEquals(orderRotateLeft, orders.get(1).getAction());
		assertTrue(orders.get(2) instanceof RotateOrder);
		assertEquals(orderRotateRight, orders.get(2).getAction());
	}

}
