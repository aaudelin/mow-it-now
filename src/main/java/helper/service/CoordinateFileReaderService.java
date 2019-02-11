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

/**
 * Reads a coordinate file type to create all coordinate types objects
 * 
 * @author aaudelin
 *
 */
public class CoordinateFileReaderService {

	/** Delimiter to read file infos */
	public static final String FILE_FIELD_DELIMITER = " ";

	private static CoordinateFileReaderService instance = new CoordinateFileReaderService();

	/**
	 * Retrieves the instance of the singleton
	 * 
	 * @return instance
	 */
	public static CoordinateFileReaderService getInstance() {
		return instance;
	}

	/**
	 * Create an according field according a string line
	 * 
	 * @param fieldInfos the input line
	 * @return a new coordinate field
	 * @throws CoordinateFileReadException
	 */
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

	/**
	 * Create a position sensor according to a string line
	 * 
	 * @param position the input line
	 * @return a new coordinate position
	 * @throws CoordinateFileReadException
	 * @throws EntityException
	 */
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

	/**
	 * Create a list of moving or rotating orders according to an input line
	 * 
	 * @param order the input line
	 * @return a new list of orders
	 * @throws CoordinateFileReadException
	 * @throws EntityException
	 */
	public List<AOrder> createOrders(String order) throws CoordinateFileReadException, EntityException {
		String[] orders = order.split(CoordinateFileReaderService.FILE_FIELD_DELIMITER);

		if (orders.length != 1) {
			throw new CoordinateFileReadException("Impossible to read mower order from file : illegal file format");
		}

		return OrderFactory.createOrderList(order);

	}

	/**
	 * Create a mower by injecting all dependencies
	 * 
	 * @param pField    the field to mow
	 * @param pPosition the current mower position
	 * @param pOrders   the list of orders
	 * @return a new automatic mower
	 * @throws CoordinateFileReadException
	 * @throws EntityException
	 */
	public AMower createMower(String pField, String pPosition, String pOrders)
			throws CoordinateFileReadException, EntityException {
		AField field = this.createField(pField);
		APosition position = this.createPosition(pPosition);
		List<AOrder> orders = this.createOrders(pOrders);

		return MowerFactory.createAutomaticMower(field, position, orders);
	}

}
