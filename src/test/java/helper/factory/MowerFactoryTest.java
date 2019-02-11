package helper.factory;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import model.entity.field.CoordinateField;
import model.entity.mower.AutomaticMower;
import model.entity.order.AOrder;
import model.entity.position.CoordinatePosition;

public class MowerFactoryTest {

	@Test
	public void testValidAutomaticMower() throws Exception {
		// Build objects
		int x = 8;
		int y = 9;
		CoordinateField field = FieldFactory.createCoordinateField(x, y);

		char orderMove = 'A';
		char orderRotateLeft = 'G';
		char orderRotateRight = 'D';
		StringBuilder builder = new StringBuilder();
		builder.append(orderMove);
		builder.append(orderRotateLeft);
		builder.append(orderRotateRight);

		List<AOrder> orders = OrderFactory.createOrderList(builder.toString());

		int posX = 1;
		int posY = 3;
		char direction = 'N';

		CoordinatePosition position = PositionFactory.createCoordinatePosition(posX, posY, direction);

		// Call method
		AutomaticMower mower = MowerFactory.createAutomaticMower(field, position, orders);

		// Asserts
		assertTrue(field == mower.getField());
		assertTrue(orders == mower.getOrders());
		assertTrue(position == mower.getPosition());
	}

}
