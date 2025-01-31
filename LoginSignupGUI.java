package com.mycompany.todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginSignupGUI extends JFrame {
	
	private List <User> users;
	private JFrame todolistframe;
	
	public LoginSignupGUI(List<User> users, JFrame todolistframe) {
		this.users=users;
		this.todolistframe=todolistframe;
		setupGUI();
	}
	
	private void setupGUI() {
		setTitle("Login/ Sign Up");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel=new JPanel (new GridLayout(4,2));
		JLabel usernamelabel=new JLabel("Username: ");
		JTextField usernamefield=new JTextField();
		JLabel passwordlabel=new JLabel ("Password: ");
		JTextField passwordfield=new JTextField ();
		JButton loginbutton=new JButton("Login");
		JButton signupbutton=new JButton("Sign Up");
		loginbutton.setBackground(Color.BLUE);
		signupbutton.setBackground(Color.GREEN);
		
		panel.add(usernamelabel);
		panel.add(usernamefield);
		panel.add(passwordlabel);
		panel.add(passwordfield);
		panel.add(signupbutton);
		panel.add(loginbutton);
		
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=usernamefield.getText();
				String password=new String(passwordfield.getText());
				
				if(verifyuser(username,password)) {
					JOptionPane.showMessageDialog(null, "Login successful");
					todolistframe.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username. Try Signing Up");
				}
			}
		});
		
		signupbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=usernamefield.getText();
				String password=new String(passwordfield.getText());
				if(createuser(username,password)) {
					JOptionPane.showMessageDialog(null, "Account Created, you can Login Now");
				}else {
					JOptionPane.showMessageDialog(null, "Username Already Exists, Try Logging in");
				}
			}
		});
		add(panel);
		
	}
	
	private boolean verifyuser(String username, String pass) {
		for (User user: users) {
			if (user.getusername().equals(username) && user.getpassword().equals(pass)) {
				return true;
			}
		}
		users.add(new User(username, pass));
		return false;
	}
	
	private boolean createuser(String username, String password) {
		for (User user: users) {
			if (user.getusername().equals(username)) {
				return false;
			}
		}
		users.add(new User(username, password));
		return true;
	}
	
	public static void main(String[] args) {
		List<User> users=new ArrayList<>();
		users.add(new User("admin", "password"));
		todolistgui todolistGUI=new todolistgui(users);
		LoginSignupGUI loginsignup=new LoginSignupGUI(users, todolistGUI);
		loginsignup.setVisible(true);
	}

}
