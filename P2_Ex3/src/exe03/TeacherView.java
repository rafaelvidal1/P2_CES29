package exe03;

public class TeacherView implements IView {

	@Override
	public void printDetails(String nameTeacher, String teacherRollNo) {
		System.out.println("Teacher: ");
		System.out.println("Name: " + nameTeacher);
		System.out.println("Roll No: " + teacherRollNo);
	}

}
