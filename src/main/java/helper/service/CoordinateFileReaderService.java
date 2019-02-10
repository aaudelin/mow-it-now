package helper.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.CoordinateFileReadException;
import helper.factory.FieldFactory;
import model.entity.field.AField;

public class CoordinateFileReaderService {

	public static final String FILE_FIELD_DELIMITER = " ";

	private static CoordinateFileReaderService instance = new CoordinateFileReaderService();

	public static CoordinateFileReaderService getInstance() {
		return instance;
	}

	public AField createField(String line) throws CoordinateFileReadException {
		String[] coordinates = line.split(CoordinateFileReaderService.FILE_FIELD_DELIMITER);
		List<Integer> listCoordinates = Arrays.stream(coordinates).map((value) -> Integer.valueOf(value))
				.collect(Collectors.toList());

		if (listCoordinates.size() != 2) {
			throw new CoordinateFileReadException("Impossible to read field from file : illegal file format");
		}

		return FieldFactory.createCoordinateField(listCoordinates.get(0), listCoordinates.get(1));

	}

}
