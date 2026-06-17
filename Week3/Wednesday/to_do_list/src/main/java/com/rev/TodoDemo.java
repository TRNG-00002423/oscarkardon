
package com.rev;

public class TodoDemo {
    public static void main(String[] args) {
        TodoListManager todoList = new TodoListManager();
        todoList.addTask("Finish exercise");
        todoList.addTask("Buy groceries");
        todoList.addTask("Go to frisbee practice");

        todoList.listTasks();

        todoList.completeTask(1);

        todoList.size();

        try {
            todoList.getTask(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
}