import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exceptions.MissingArgumentException;

public class MowerMain {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new MissingArgumentException("Missing file path or too much arguments provided");
		}
		String filePath = args[0];

		// Read input file to load field, mower and orders
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			br.readLine();
		} catch (IOException exception) {
			System.out.println("Impossible to read file from path : " + filePath);
			throw exception;
		}
		
		// Begin automatic mower program for a garden
	}

}
