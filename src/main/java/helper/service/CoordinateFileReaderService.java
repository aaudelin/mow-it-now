package helper.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.CoordinateFileReadException;
import exception.EntityException;
import helper.factory.FieldFactory;
import helper.factory.MowerFactory;
import helper.factory.OrderFactory;
import helper.factory.PositionFactory;
import model.entity.field.AField;
import model.entity.mower.AMower;
import model.entity.order.AOrder;
import model.entity.position.APosition;

public class CoordinateFileReaderService {

	public static final String FILE_FIELD_DELIMITER = " ";

	private static CoordinateFileReaderService instance = new CoordinateFileReaderService();

	public static CoordinateFileReaderService getInstance() {
		return instance;
	}

	public AField createField(String fieldInfos) throws CoordinateFileReadException {
		String[] coordinates = fieldInfos.split(CoordinateFileReaderService.FILE_FIELD_DELIMITER);
		List<Integer> listCoordinates;

		if (coordinates.length != 2) {
			throw new CoordinateFileReadException("Impossible to read field from file : illegal file format");
		}
		try {
			listCoordinates = Arrays.stream(coordinates).map((value) -> Integer.valueOf(value))
					.collect(Collectors.toList());
		} catch (NumberFormatException exception) {
			throw new CoordinateFileReadException(
					"Impossible to read field coordinates from file : illegal file format");
		}

		return FieldFactory.createCoordinateField(listCoordinates.get(0), listCoordinates.get(1));

	}

	public APosition createPosition(String position) throws CoordinateFileReadException, EntityException {
		String[] positionInfos = position.split(CoordinateFileReaderService.FILE_FIELD_DELIMITER);

		if (positionInfos.length != 3) {
			throw new CoordinateFileReadException("Impossible to read mower position from file : illegal file format");
		}

		int[] coordinates = new int[2];
		char direction;
		try {
			coordinates[0] = Integer.valueOf(positionInfos[0]);
			coordinates[1] = Integer.valueOf(positionInfos[1]);
			direction = positionInfos[2].charAt(0);
		} catch (NumberFormatException | IndexOutOfBoundsException exception) {
			throw new CoordinateFileReadException(
					"Impossible to read mower coordinate from file : illegal file format");
		}

		return PositionFactory.createCoordinatePosition(coordinates[0], coordinates[1], direction);

	}

	public List<AOrder> createOrders(String order) throws CoordinateFileReadException, EntityException {
		String[] orders = order.split(CoordinateFileReaderService.FILE_FIELD_DELIMITER);

		if (orders.length != 1) {
			throw new CoordinateFileReadException("Impossible to read mower order from file : illegal file format");
		}

		return OrderFactory.createOrderList(order);

	}

	public AMower createAutomaticMower(String pField, String pPosition, String pOrders)
			throws CoordinateFileReadException, EntityException {
		AField field = this.createField(pField);
		APosition position = this.createPosition(pPosition);
		List<AOrder> orders = this.createOrders(pOrders);

		return MowerFactory.createAutomaticMower(field, position, orders);
	}

}
