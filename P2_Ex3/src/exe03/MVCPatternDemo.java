package exe03;

public class MVCPatternDemo {
	public static void main(String[] args) throws NoSuchMethodException {
				
		// fetch student record based on his roll no from the database
		Student modelS = retriveStudentFromDatabase();
		Teacher modelT = retriveTeacherFromDatabase();
		
		// Create a view : to write student details on console
		
		ControllerFactory controller =  ControllerFactory.getController(modelS);

		controller.updateView();

		controller =  ControllerFactory.getController(modelT);
		
		controller.updateView();
	}

	private static Student retriveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
	
	private static Teacher retriveTeacherFromDatabase(){
		Teacher teacher = new Teacher();
		teacher.setName("Sam");
		teacher.setRollNo("20");
		return teacher;
	}

}
