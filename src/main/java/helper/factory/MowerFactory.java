package helper.factory;

import java.util.List;

import model.entity.field.AField;
import model.entity.mower.AutomaticMower;
import model.entity.order.AOrder;
import model.entity.position.APosition;

/**
 * 
 * @author aaudelin
 *
 */
public class MowerFactory {

	/**
	 * Creates an automatic mower
	 * 
	 * @param field    the field to mow
	 * @param position the current position
	 * @param orders   the list of orders to execute
	 * @return a new automatic mower
	 */
	public static AutomaticMower createAutomaticMower(AField field, APosition position, List<AOrder> orders) {
		return new AutomaticMower(position, field, orders);
	}

}
