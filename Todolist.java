/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author heday
 */
public class Todolist {

    	private List <Tasks> alltasks;
    	
    	public Todolist() {
    		alltasks=new ArrayList<>();
    		
    	}
    	public void addTask(String description) {
    		Tasks newtask=new Tasks(description);
    		alltasks.add(newtask);
    	}
    	public void displaytasks() {
    		for (int i=0; i<alltasks.size(); i++) {
    			System.out.println((i+1)+ " "+alltasks.get(i));
    		}
    	}
    	 public static void main(String[] args) {
    	        Scanner scanner = new Scanner(System.in);
    	        Todolist toDoList = new Todolist();

    	        while (true) {
    	            System.out.println("Enter a task description (or type 'exit' to quit):");
    	            String description = scanner.nextLine();

    	            if (description.equalsIgnoreCase("exit")) {
    	                break;
    	            }

    	            toDoList.addTask(description);
    	        }
    	        scanner.close();

    	        System.out.println("Your tasks:");
    	        toDoList.displaytasks();
    	    }
}
