import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.CoordinateFileReadException;
import exception.MissingArgumentException;
import exception.EntityException;
import helper.service.CoordinateFileReaderService;
import model.entity.mower.AMower;

public class AutomaticMowerMain {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new MissingArgumentException("Missing file path or too much arguments provided");
		}
		String filePath = args[0];

		// Read input file to load field, mower and orders
		List<AMower> mowers = new ArrayList<AMower>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Read field
			String field = br.readLine();

			// Read mowers
			String lineI;
			String lineJ;
			while ((lineI = br.readLine()) != null && (lineJ = br.readLine()) != null) {
				AMower mower = CoordinateFileReaderService.getInstance().createAutomaticMower(field, lineI, lineJ);
				mowers.add(mower);
			}
		} catch (IOException exception) {
			System.out.println("Impossible to read file from path : " + filePath);
			throw exception;
		} catch (CoordinateFileReadException exception) {
			System.out.println("Overall file format exception for file : " + filePath);
			throw exception;
		} catch (EntityException exception) {
			System.out.println("Impossible to create one of the object for file : " + filePath);
			throw exception;
		}
		// Begin automatic mower program for a garden
	}

}
