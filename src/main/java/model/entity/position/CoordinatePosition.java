package model.entity.position;

import java.util.HashMap;
import java.util.Map;

import exception.PositionException;
import helper.factory.PositionFactory;
import model.common.EAvailableActions;
import model.common.EAvailableDirection;
import model.entity.field.AField;
import model.entity.field.CoordinateField;
import model.entity.order.AOrder;
import model.entity.order.MoveOrder;
import model.entity.order.RotateOrder;

/**
 * Sensor plugged to a mower that indicates and computes the position according
 * to the field and the orders
 * 
 * Works with coordinate field
 * 
 * @author aaudelin
 *
 */
public class CoordinatePosition extends APosition {

	public static final String INFO_DELIMITER = " ";

	char direction = '\u0000';

	int xCoordinate = 0;

	int yCoordinate = 0;

	@Override
	public APosition computePositionFromOrder(AOrder order) throws PositionException {
		if (order instanceof RotateOrder) {
			EAvailableDirection direction = this.rotateFromAction(order.getAction());
			return PositionFactory.createCoordinatePosition(this.xCoordinate, this.yCoordinate,
					direction.getDirection());
		}

		if (order instanceof MoveOrder) {
			int x = this.moveXFromAction();
			int y = this.moveYFromAction();
			return PositionFactory.createCoordinatePosition(x, y, this.getDirection());
		}
		return null;
	}

	@Override
	public boolean isIncludedInField(AField field) throws PositionException {
		if (!(field instanceof CoordinateField)) {
			throw new PositionException(
					"Invalid field type not handled by the position : " + field.getClass().getName());
		}
		CoordinateField cField = (CoordinateField) field;
		return this.xCoordinate >= cField.getMinXCoordinate() 
				&& this.xCoordinate <= cField.getMaxXCoordinate()
				&& this.yCoordinate >= cField.getMinYCoordinate() 
				&& this.yCoordinate <= cField.getMaxYCoordinate();
	}

	/**
	 * Computes a movement action to the x coordinate
	 * 
	 * @return the next x position
	 */
	private int moveXFromAction() {
		EAvailableDirection direction = EAvailableDirection.getFromDirection(this.getDirection());
		if (EAvailableDirection.DIRECTION_WEST.equals(direction)) {
			return this.xCoordinate - 1;
		}
		if (EAvailableDirection.DIRECTION_EAST.equals(direction)) {
			return this.xCoordinate + 1;
		}
		return this.xCoordinate;

	}

	/**
	 * Computes a movement action to the y coordinate
	 * 
	 * @return the next y position
	 */
	private int moveYFromAction() {
		EAvailableDirection direction = EAvailableDirection.getFromDirection(this.getDirection());
		if (EAvailableDirection.DIRECTION_NORTH.equals(direction)) {
			return this.yCoordinate + 1;
		}
		if (EAvailableDirection.DIRECTION_SOUTH.equals(direction)) {
			return this.yCoordinate - 1;
		}
		return this.yCoordinate;

	}

	/**
	 * Computes a rotation
	 * 
	 * @param action the rotation type
	 * @return the next direction, focus on NORTH by default
	 */
	private EAvailableDirection rotateFromAction(char action) {
		Map<EAvailableDirection, EAvailableDirection> mapLeft = new HashMap<EAvailableDirection, EAvailableDirection>();
		mapLeft.put(EAvailableDirection.DIRECTION_NORTH, EAvailableDirection.DIRECTION_WEST);
		mapLeft.put(EAvailableDirection.DIRECTION_WEST, EAvailableDirection.DIRECTION_SOUTH);
		mapLeft.put(EAvailableDirection.DIRECTION_SOUTH, EAvailableDirection.DIRECTION_EAST);
		mapLeft.put(EAvailableDirection.DIRECTION_EAST, EAvailableDirection.DIRECTION_NORTH);

		Map<EAvailableDirection, EAvailableDirection> mapRight = new HashMap<EAvailableDirection, EAvailableDirection>();
		mapRight.put(EAvailableDirection.DIRECTION_NORTH, EAvailableDirection.DIRECTION_EAST);
		mapRight.put(EAvailableDirection.DIRECTION_EAST, EAvailableDirection.DIRECTION_SOUTH);
		mapRight.put(EAvailableDirection.DIRECTION_SOUTH, EAvailableDirection.DIRECTION_WEST);
		mapRight.put(EAvailableDirection.DIRECTION_WEST, EAvailableDirection.DIRECTION_NORTH);

		EAvailableDirection direction = EAvailableDirection.DIRECTION_NORTH;
		if (action == EAvailableActions.ROTATE_LEFT.getAction()) {
			direction = mapLeft.get(EAvailableDirection.getFromDirection(this.getDirection()));
		} else if (action == EAvailableActions.ROTATE_RIGHT.getAction()) {
			direction = mapRight.get(EAvailableDirection.getFromDirection(this.getDirection()));
		}
		return direction;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.xCoordinate);
		builder.append(INFO_DELIMITER);
		builder.append(this.yCoordinate);
		builder.append(INFO_DELIMITER);
		builder.append(this.direction);
		return builder.toString();
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
