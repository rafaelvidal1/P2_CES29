package exe03;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory<T> {
	
	Map<Class<T>, IController<T>> registry = new HashMap<>();
	
	void ControllerFactory(){
		this.registerController(Student.class, StudentController.class);
		this.registerController(Teacher.class, TeacherController.class);
	}

	public void registerController(Class<T> type, Class<? extends IController> controllerType) {
	    registry.put(type, controllerType);
	}

	public <T> IController<T> getController(Class<T> classT) {
	  return registry.get(classT).newInstance();
	}
	
}
