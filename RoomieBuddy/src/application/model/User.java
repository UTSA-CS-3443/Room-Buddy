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
	private String userName;
	private String passWord;
	private ArrayList<String> data; 
	
	public User(String user, String pass) throws IOException{
		this.userName = user;
		this.passWord = pass;
		int x = 0;
		
	//	validate(userName,passWord);
	//	welcomeUser(userName);
	}
	/**
	 * 
	 * @param u
	 * @param p
	 * @return
	 * @throws IOException
	 * the validate method checks if what the user entered is in the system and returns true if they are, 
	 * and false if they are not
	 */
	
	public static String validate(String u, String p)throws IOException {
		String validation = "";
		try {
			Scanner scan = new Scanner(new File("data/loginUPDATED.csv"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				if(!line.equals("")) {
					String[] userSplit = line.split(",");
					if(userSplit[1].equals(u) && userSplit[2].equals(p)){
						validation = "true";
				
						break;
					}else if((userSplit[0]!=u) && (userSplit[1]!=p)){
						validation = "false";
					}
				}
			}
		scan.close();
		}catch( IOException e ) {
			e.printStackTrace();
		}
		return validation;
	}
	
}