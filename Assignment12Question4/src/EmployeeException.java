public class EmployeeException extends RuntimeException{
	private String field;
	private int value;
	public EmployeeException() {
		super("Invalid time");
	}
	public EmployeeException(String field, int value) {
		super("Invalid " + field + ": " + value);
		this.field = field;
		this.value = value;
	}
	public String getField() {
		return field;
	}
	public int getValue() {
		return value;
	}
}
