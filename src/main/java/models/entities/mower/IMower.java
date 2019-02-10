package models.entities.mower;

import java.util.List;

import models.entities.coordinates.IPosition;
import models.entities.field.IField;
import models.entities.order.IOrder;

public interface IMower {
	
	public IPosition position = null;
	
	public IField field = null;
	
	public List<IOrder> orders = null;
	
	public void move();

}
