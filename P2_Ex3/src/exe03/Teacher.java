package exe03;

public class Teacher implements ModelType {
	private String rollNo;
	private String name;
	
	@Override
	public String getRollNo() {
		return rollNo;
	}

	@Override
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
