package models;

public class Todo {

	
	private int id;
	private String name;
	private String description;
	private boolean completed;
	
	
	public Todo(String name, String  description) {
		this.id = (int)(Math.random() * 10000);
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
	
	public int getId() {
		return this.id;
	}

	
	
}
