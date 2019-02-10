import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MissingArgumentException;

public class MowerMainTest {

	@Test(expected=MissingArgumentException.class)
	public void testMainEmptyParameters() throws Exception {
		String[] arguments = new String[0];
		MowerMain.main(arguments);
	}

}
