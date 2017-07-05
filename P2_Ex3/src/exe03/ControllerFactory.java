package exe03;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllerFactory {
	
	protected ModelType _model;
	protected IView _view;

	public void setName(String name){
		_model.setName(name);
	};

	public String getName(){
		return _model.getName();
	};

	public void setRollNo(String rollNo){
		_model.setRollNo(rollNo);
	};

	public String getRollNo(){
		return _model.getRollNo();
	};
	
	public void updateView() {
		_view.printDetails(_model.getName(), _model.getRollNo());
	}
	
	public static ControllerFactory getController(ModelType model){
		
		if(model.getClass().getSimpleName().equals("Student")){
			StudentController studentController = new StudentController();
			studentController.setController((Student)model, new StudentView());
			return studentController;
		}
		
		if(model.getClass().getSimpleName().equals("Teacher")){
			TeacherController teacherController = new TeacherController();
			teacherController.setController((Teacher)model, new TeacherView());
			return teacherController;
		}
		return null;
	}
	
}
