package helper.factory;

import exception.PositionException;
import model.common.EAvailableDirection;
import model.entity.position.CoordinatePosition;

/**
 * 
 * @author aaudelin
 *
 */
public class PositionFactory {

	/**
	 * Creates a position sensor that works with coordinates
	 * 
	 * @param x         the x coordinate
	 * @param y         the y coordinate
	 * @param direction the direction (N, S, W, E)
	 * @return a new coordinate position sensor
	 * @throws PositionException
	 */
	public static CoordinatePosition createCoordinatePosition(int x, int y, char direction) throws PositionException {

		if (!EAvailableDirection.isValidDirection(direction)) {
			throw new PositionException("Impossible to save position : direction invalid " + direction);
		}
		CoordinatePosition position = new CoordinatePosition();
		position.setXCoordinate(x);
		position.setYCoordinate(y);
		position.setDirection(direction);

		return position;
	}

}
