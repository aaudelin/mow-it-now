package model.entity.position;

import exception.PositionException;
import model.entity.field.AField;
import model.entity.order.AOrder;

public abstract class APosition {

	public abstract APosition computePositionFromOrder(AOrder order) throws PositionException;

	public abstract boolean isIncludedInField(AField field) throws PositionException;
}
