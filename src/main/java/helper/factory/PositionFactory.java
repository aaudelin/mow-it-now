package helper.factory;

import exception.PositionException;
import model.common.EAvailableDirection;
import model.entity.position.APosition;
import model.entity.position.CoordinatePosition;

public class PositionFactory {

	public static APosition createCoordinatePosition(int x, int y, char direction) throws PositionException {

		if (!EAvailableDirection.isValidDirection(direction)) {
			throw new PositionException("Impossible to save position : direction invalid " + direction);
		}
		CoordinatePosition position = new CoordinatePosition();
		position.setxCoordinate(x);
		position.setyCoordinate(y);
		position.setDirection(direction);

		return position;
	}

}
