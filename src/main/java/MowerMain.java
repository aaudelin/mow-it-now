import exceptions.MissingArgumentException;

public class MowerMain {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new MissingArgumentException("Missing file path");
		}
	}

}
