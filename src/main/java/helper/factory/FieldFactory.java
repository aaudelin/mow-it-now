package helper.factory;

import model.entity.field.CoordinateField;

public class FieldFactory {

	public static CoordinateField createCoordinateField(int xPos, int yPos) {
		CoordinateField field = new CoordinateField();
		field.setMinXCoordinate(0);
		field.setMinYCoordinate(0);
		field.setMaxXCoordinate(xPos);
		field.setMaxYCoordinate(yPos);

		return field;

	}

}
