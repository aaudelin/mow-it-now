package models.entities.field;

import models.entities.coordinates.APosition;

public abstract class AField {
	
	Integer maxXCoordinate = null;
	
	Integer maxYCoordinate = null;
	
	public boolean isPositionIncluded(APosition position) {
		return false;
		
	}

}
