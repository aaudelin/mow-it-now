package helper.factory;

import java.util.List;

import model.entity.field.AField;
import model.entity.mower.AutomaticMower;
import model.entity.order.AOrder;
import model.entity.position.APosition;

public class MowerFactory {

	public static AutomaticMower createAutomaticMower(AField field, APosition position, List<AOrder> orders) {
		return new AutomaticMower(position, field, orders);
	}

}
