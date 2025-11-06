package models;

public class Todo {

	
	private String name;
	private String description;
	private boolean completed;
	
	
	public Todo(String name, String  description) {
		
		this.name = name;
		this.description  = description;
		this.completed = false;
		
	}
	
	
	public String getName() {
			return this.name;
	}
	
	
	public String getDescription() {
		return this.description;
		
	}
	
	public boolean isCompleted() {
		return this.completed;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String  description) {
		this.description = description;
		
	}

	public void makeComplete() {
		this.completed = !this.completed;
	}

	
	
}
