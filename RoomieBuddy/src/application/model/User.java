package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author qbw322
 *UTSA CS 3443 - Lab 5
 * Spring 2019
 *this class requires 2 arguments to validate if the user's credentials match
 *the username, and the password
 */

public class User {
	private String name; 
	private String phoneNumber; 
	private String email; 
	private String username;
	private String password;
	private boolean signInFlag = false;
	private String data[]; 
	
	public User(String user, String pass){
		
		this.username = user; 
		this.password = pass; 
		data = new String[14];
		for(int x = 0; x < data.length; x++){
			data[x] = ""; 
		}
		
	}
	
	public User(String name, String user, String pass, String phoneNumber, String email) throws IOException{

		this.name = name; 
		this.username = user;
		this.password = pass; 
		this.phoneNumber = phoneNumber; 
		this.email = email; 
		data = new String[14];		
	
	
	//	validate(userName,passWord);
	//	welcomeUser(userName);
	}
	
	public void populateArray(String dataParam[]) {

		this.data = dataParam;

	}
	/**
	 * 
	 * @param User user
	 * @return user
	 * @throws IOException
	 * the validate method checks if what the user entered is in the system and returns true if they are, 
	 * and false if they are not
	 */
	
	public static User validate(User user)throws IOException {
		try{
			Scanner scan = new Scanner(new File("data/loginUPDATED.csv"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				
				if(!line.equals("")) {
					String[] userSplit = line.split(",");
					if(userSplit[1].equals(user.getUsername()) && userSplit[2].equals(user.getPassword())){
						user.populate(userSplit[0], userSplit[4], userSplit[3]);
						return user;						
					}
				}
			}
		scan.close();
		return null;

		}catch( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void populate(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	
	public String getUsername(){
		return username; 
	}
	
	public String getPassword(){
		return password; 
	}
	
	public void setName(String n){
		this.name = n; 
	}
	
	public void setEmail(String e){ 
		this.email = e; 
	}
	public void setUsername(String u){
		this.username = u; 
	}
	
	public void setPassword(String p){
		this.password= p; 
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isSignInFlag() {
		return signInFlag;
	}

	public void setSignInFlag(boolean signInFlag) {
		this.signInFlag = signInFlag;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}

	

	public String getEmail() {
		return email;
	}
	
	
	
}