package model.entity.position;

import model.entity.order.AOrder;

public class CoordinatePosition extends APosition {

	char direction = '\u0000';

	int xCoordinate = 0;

	int yCoordinate = 0;
	

	@Override
	public APosition computePositionFromOrder(AOrder order) {
		// TODO Auto-generated method stub
		return null;
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
