package models;

import java.util.ArrayList;

public class TodoManager {

	
	private ArrayList<Todo> todos;
	private static TodoManager instance = null;
	
	private TodoManager() {
		this.todos = new ArrayList<Todo>();
	}
	
	
	public static TodoManager getInstance()	{
		if(TodoManager.instance == null) {
			TodoManager.instance = new TodoManager();
		}
		return TodoManager.instance;
	}
	
	public void add(Todo todo) {
		this.todos.add(todo);
	}
	
	public void remove(int id) {
		int index = 0;
		for(int i = 0; i < this.length();i++) {
			if(todos.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		todos.remove(index);
	}
	
	public Todo get(int i) {
		return this.todos.get(i);
	}
	
	public Todo getById(int id) {
		int index = 0;
		for(int i = 0; i < this.length();i++) {
			if(todos.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		return get(index);
	}
	
	public  int length() {
		return this.todos.size();
	}
}
