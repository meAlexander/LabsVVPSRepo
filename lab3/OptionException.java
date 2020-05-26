package lab3;

@SuppressWarnings("serial")
public class OptionException extends Exception{
	@Override
	public String getMessage() {
		return "Invalid option";
	}
}
