package exe03;

public class MVCPatternDemo {
	public static void main(String[] args) {
		
		//Object controller = null;
		
		// fetch student record based on his roll no from the database
		Student model = retriveStudentFromDatabase();

		// Create a view : to write student details on console
		StudentView view = new StudentView();
		
		//Teacher modelT = retrieveTeacherFromDatabase();
		//TeacherView viewT = new TeacherView();
		
		//controller = Class.forName("Teacher").newInstance();
		
		StudentController controller = new StudentController(model, view);

		controller.updateView();

		// update model data
		controller.setStudentName("John");

		controller.updateView();
	}

	private static Student retriveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}

}