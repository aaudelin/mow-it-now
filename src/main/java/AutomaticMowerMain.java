import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exception.CoordinateFileReadException;
import exception.MissingArgumentException;
import helper.service.CoordinateFileReaderService;
import model.entity.field.AField;

public class AutomaticMowerMain {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new MissingArgumentException("Missing file path or too much arguments provided");
		}
		String filePath = args[0];

		// Read input file to load field, mower and orders
		AField field;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			field = CoordinateFileReaderService.getInstance().createField(br.readLine());
		} catch (IOException exception) {
			System.out.println("Impossible to read file from path : " + filePath);
			throw exception;
		} catch (CoordinateFileReadException exception) {
			System.out.println("Overall file format exception for file : " + filePath);
			throw exception;
		}
		// Begin automatic mower program for a garden
	}

}
