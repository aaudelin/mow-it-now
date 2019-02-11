import java.io.IOException;

import org.junit.Test;

import exception.MissingArgumentException;

public class AutomaticMowerMainTest {

	@Test(expected = MissingArgumentException.class)
	public void testMainEmptyParameters() throws Exception {
		// Checks that no argument provide an exception
		String[] arguments = new String[0];
		AutomaticMowerMain.main(arguments);
	}

	@Test(expected = IOException.class)
	public void testMainInvalidFilePath() throws Exception {
		// Checks that no argument provide an exception
		String[] arguments = { "/invalid/file/path" };
		AutomaticMowerMain.main(arguments);
	}

	@Test
	public void testMainValidFile() throws Exception {
		// Checks that no argument provide an exception
		String[] arguments = { "/invalid/file/path" };
		AutomaticMowerMain.main(arguments);
	}

}
