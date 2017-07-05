package exe03;

public class StudentController extends ControllerFactory {
	
	public void setController(Student model, StudentView view){
		_model = model;
		_view = view;
	};

}
