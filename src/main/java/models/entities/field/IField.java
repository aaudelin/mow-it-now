package models.entities.field;

import models.entities.coordinates.IPosition;

public interface IField {
	
	Integer xCoordinate = null;
	
	Integer yCoordinate = null;
	
	default public boolean isPositionIncluded(IPosition position) {
		return false;
		
	}

}
