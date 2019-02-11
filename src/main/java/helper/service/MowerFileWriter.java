package helper.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.entity.mower.AMower;

/**
 * 
 * @author aaudelin
 *
 */
public class MowerFileWriter {

	private static final MowerFileWriter instance = new MowerFileWriter();

	/**
	 * Returns the singleton instance
	 * 
	 * @return instance
	 */
	public static MowerFileWriter getInstance() {
		return instance;
	}

	/**
	 * Write mowers position to output file and stdout
	 * 
	 * @param mowers   the mowers to print
	 * @param filePath the output file
	 * @throws IOException
	 */
	public void writeMowersToFile(List<AMower> mowers, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			System.out.println("---- RESULT : Output mowers final position ---");

			mowers.stream().forEach((mower) -> {
				if (null != mower.getPosition()) {
					// Get position
					String position = mower.getPosition().toString();

					// Write to stdout
					System.out.println(position);
					try {
						// Write to file
						writer.write(position);
						writer.newLine();
					} catch (IOException exception) {
						System.out.println("Impossible to write position : " + mower);
						exception.printStackTrace();
					}
				}
			});
		}
	}

}
