package com.mycompany.todolist;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class todolistgui extends JFrame {
	    private List<Tasks> tasks;
	    private List <User> users;
	    private User currentuser;
	    private DefaultListModel<String> taskListModel;
	    private JPanel taskspanel;
	    
	    public todolistgui(List<User> users) {
	    	this.users=users;
	    	tasks=new ArrayList<>();
	    	taskListModel=new DefaultListModel<>();
	    	taskspanel=new JPanel();
	    	taskspanel.setLayout(new BoxLayout(taskspanel, BoxLayout.Y_AXIS));
	    	setupGUI();
	    	}
	    
	    
	    private void setupGUI(){
	    	setTitle("To-Do List");
	    	setSize(500,500);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setLocationRelativeTo(null);
	    	
	    	
	    	JPanel inputpanel= new JPanel();
	    	inputpanel.setLayout(new BorderLayout());
	    	
	    	JTextField taskfield=new JTextField();
	    	
	    	JButton addbutton=new JButton("Add Task");
	    	
	    	addbutton.addActionListener(new ActionListener() {
	    		@Override
	    		public void actionPerformed(ActionEvent e) {
	    			String description = taskfield.getText();
	    			if(!description.isEmpty()) {
	    				addTask(description);
	    				taskfield.setText("");
	    			}
	    		}
	    		
	    	});
	    	
	    	inputpanel.add(taskfield, BorderLayout.NORTH);
	    	inputpanel.add(addbutton, BorderLayout.SOUTH);
	    	
	    	JScrollPane scrollpane=new JScrollPane(taskspanel);
	    	
	    	add(inputpanel,BorderLayout.NORTH);
	    	add(scrollpane, BorderLayout.CENTER);
	    
	    	
	    }
	    private void addTask(String description) {
	    	Tasks newTask=new Tasks(description);
	    	tasks.add(newTask);
	    	updateTaskPanel();
	    	}
	    
	    private void updateTaskPanel() {
	    	taskspanel.removeAll();
	    	for (Tasks task: tasks) {
	    		JPanel taskpanel=new JPanel(new BorderLayout());
	    		JLabel tasklabel=new JLabel(task.toString());
	    		JButton completebutton=new JButton("CLICK to Complete");
	    		JButton modifybutton=new JButton("Modify");
	    		
	    		completebutton.addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				if(task.is_task_completed()) {
	    					task.setcompletion(false);
	    					completebutton.setBackground(Color.RED);
	    					completebutton.setText("Not Completed");
	    					tasklabel.setText(task.toString());
	    				}
	    				else {
	    					task.setcompletion(true);
	    					completebutton.setBackground(Color.GREEN);
	    					completebutton.setText("Completed");
		    				tasklabel.setText(task.toString());
	    				}
	    				
	    			}
	    		});
	    		modifybutton.addActionListener(new ActionListener() {
	    			
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				String newDescription=JOptionPane.showInputDialog("Modify Task", task.getTask());
	    				if (newDescription != null && !newDescription.isEmpty()) {
	    					task.setTask(newDescription);
	    					tasklabel.setText(task.toString());
	    				}
	    			}
	    		});
	    		taskpanel.add(tasklabel, BorderLayout.CENTER);
	    		taskpanel.add(completebutton, BorderLayout.EAST);
	    		taskpanel.add(modifybutton, BorderLayout.WEST);
	    		taskspanel.add(taskpanel);
	    	}
	    	taskspanel.revalidate();
	    	taskspanel.repaint();
	    }
	

}
