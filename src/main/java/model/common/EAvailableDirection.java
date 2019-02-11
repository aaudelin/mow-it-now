package model.common;

public enum EAvailableDirection {

	DIRECTION_NORTH('N'),

	DIRECTION_SOUTH('S'),

	DIRECTION_EAST('E'),

	DIRECTION_WEST('W');

	private char direction;

	EAvailableDirection(char pDirection) {
		this.direction = pDirection;
	}

	public String toString() {
		return String.valueOf(this.direction);
	}

	public char getDirection() {
		return direction;
	}

	public static boolean isValidDirection(char direction) {
		for (EAvailableDirection validDirection : EAvailableDirection.values()) {
			if (validDirection.getDirection() == direction) {
				return true;
			}
		}
		return false;
	}

	public static EAvailableDirection createFromDirection(char direction) {
		for (EAvailableDirection validDirection : EAvailableDirection.values()) {
			if (validDirection.getDirection() == direction) {
				return validDirection;
			}
		}
		return EAvailableDirection.DIRECTION_NORTH;
	}

}
