package models.entities.field;

import models.entities.position.APosition;

public abstract class AField {
	
	int maxXCoordinate = 0;
	
	int maxYCoordinate = 0;
	
	public boolean isPositionIncluded(APosition position) {
		return false;
		
	}

	public Integer getMaxXCoordinate() {
		return maxXCoordinate;
	}

	public void setMaxXCoordinate(Integer maxXCoordinate) {
		this.maxXCoordinate = maxXCoordinate;
	}

	public Integer getMaxYCoordinate() {
		return maxYCoordinate;
	}

	public void setMaxYCoordinate(Integer maxYCoordinate) {
		this.maxYCoordinate = maxYCoordinate;
	}
	
	

}
