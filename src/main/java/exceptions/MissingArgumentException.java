package exceptions;

public class MissingArgumentException extends Exception {

	private static final long serialVersionUID = 4410131683322786558L;
	
	public MissingArgumentException(String string) {
		super(string);
	}


}
