/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolist;


public class Tasks {
    public String description;
    public boolean iscompleted;
    
    
    public Tasks (String description) {
    	this.description=description;
    	this.iscompleted=false;
    }
    
    public String getTask() {
    	return description;
    }
    
    public boolean is_task_completed() {
    	return iscompleted;
   
    }
    public void setcompletion (boolean completion) {
    	iscompleted=completion;
    }
    
    public void setTask(String newtask) {
    	description=newtask;
    }
    
    @Override
    public String toString() {
    	return description + " (Completed: "+ iscompleted+")";
    }
}
