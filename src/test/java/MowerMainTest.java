import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import exceptions.MissingArgumentException;

public class MowerMainTest {

	@Test(expected=MissingArgumentException.class)
	public void testMainEmptyParameters() throws Exception {
		// Checks that no argument provide an exception
		String[] arguments = new String[0];
		MowerMain.main(arguments);
	}

	@Test(expected=IOException.class)
	public void testMainInvalidFilePath() throws Exception {
		// Checks that no argument provide an exception
		String[] arguments = {"/invalid/file/path"};
		MowerMain.main(arguments);
	}

}
