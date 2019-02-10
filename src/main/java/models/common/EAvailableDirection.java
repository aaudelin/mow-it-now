package models.common;

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
	
	

}
