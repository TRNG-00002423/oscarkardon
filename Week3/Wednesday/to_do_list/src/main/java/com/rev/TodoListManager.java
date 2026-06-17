package com.rev;


import java.util.ArrayList;
import java.util.List;

public class TodoListManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
       tasks.add(task);
    }

    public String getTask(int index) throws IndexOutOfBoundsException{
        try{
            return tasks.get(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void completeTask(int index) throws IndexOutOfBoundsException{
        try{
            tasks.remove(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public List<String> listTasks() {
        for(String task : tasks){
            System.out.println(task);
        }
        return tasks;
    }

    public int size() {
        return tasks.size();
    }
}