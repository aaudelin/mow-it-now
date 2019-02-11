package model.entity.position;

import java.util.HashMap;
import java.util.Map;

import exception.PositionException;
import helper.factory.PositionFactory;
import model.common.EAvailableActions;
import model.common.EAvailableDirection;
import model.entity.field.AField;
import model.entity.order.AOrder;
import model.entity.order.RotateOrder;

public class CoordinatePosition extends APosition {

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
		return null;
	}

	@Override
	public boolean isIncludedInField(AField field) {
		// TODO Auto-generated method stub
		return false;
	}

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
			direction = mapLeft.get(EAvailableDirection.createFromDirection(this.getDirection()));
		} else if (action == EAvailableActions.ROTATE_RIGHT.getAction()) {
			direction = mapRight.get(EAvailableDirection.createFromDirection(this.getDirection()));
		}
		return direction;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
