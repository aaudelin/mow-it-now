package helper.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.PositionException;
import model.entity.position.CoordinatePosition;

public class PositionFactoryTest {

	@Test(expected = PositionException.class)
	public void testInvalidDirection() throws Exception {
		PositionFactory.createCoordinatePosition(1, 1, 'Z');
	}

	@Test
	public void testValidPositon() throws Exception {
		int x = 1;
		int y = 3;
		char direction = 'N';

		CoordinatePosition position = PositionFactory.createCoordinatePosition(x, y, direction);

		assertEquals(position.getDirection(), direction);
		assertEquals(position.getXCoordinate(), x);
		assertEquals(position.getYCoordinate(), y);
	}

}
