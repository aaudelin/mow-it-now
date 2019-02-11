package helper.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.entity.mower.AMower;

public class MowerFileWriter {

	private static final MowerFileWriter instance = new MowerFileWriter();

	public static MowerFileWriter getInstance() {
		return instance;
	}

	public boolean writeMowersToFile(List<AMower> mowers, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			System.out.println("---- RESULT : Output mowers final position ---");
			mowers.stream().forEach((mower) -> {
				if (null != mower.getPosition()) {
					String position = mower.getPosition().toString();
					System.out.println(position);
					try {
						writer.write(position);
						writer.newLine();
					} catch (IOException exception) {
						System.out.println("Impossible to write position : " + mower);
						exception.printStackTrace();
					}
				}
			});
		}
		return true;
	}

}
