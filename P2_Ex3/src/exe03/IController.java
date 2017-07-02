package exe03;

public interface IController<T> {
	
	public T model;
	private View _view;

	public void setController(T model, View view);

	public void setName(String name);

	public String getName();

	public void setRollNo(String rollNo);

	public String getRollNo();

	public default void updateView() {
		_view.printDetails(model.getName(), model.getRollNo());
	}
	
}
