package models.entities.mower;

import java.util.List;

import models.entities.coordinates.APosition;
import models.entities.field.AField;
import models.entities.order.AOrder;

public abstract class AMower {
	
	public APosition position = null;
	
	public AField field = null;
	
	public List<AOrder> orders = null;
	
	public abstract void move();

}
