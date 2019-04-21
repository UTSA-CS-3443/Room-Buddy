package application.model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author qbw322
 *UTSA CS 3443 - Lab 5
 * Spring 2019
 *this class requires 2 arguments to validate if the user's credentials match
 *the username, and the password
 */
public class user {
	private String userName;
	private String passWord;
	public user(String user, String pass) throws IOException{
		this.userName = user;
		this.passWord = pass;
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
	/**
	 * @return
	 * @throws IOException
	 * this method scans the personnel.csv file and returns which register that the ship in which the 
	 * user belongs to
	 */
	public String returnedRegister()throws IOException {
		String reg = "";
		try {
			Scanner scan = new Scanner(new File("data/personnel.csv"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] userSplit = line.split(",");
				if(userSplit[0].toLowerCase().contains(userName)){
					reg = userSplit[3] ;
					break;
				}
			}
		scan.close();
		}catch( IOException e ) {
			reg = "";
			return reg;
		//	e.printStackTrace();
			
		}
		return reg;
	}
	/**
	 * @param register
	 * @return
	 * @throws IOException
	 * this method returns the name of the fleet the user belongs to
	 */
	public String returnedFleetName(String register)throws IOException {
		String fleetName = "";
		try {
			Scanner scan = new Scanner(new File("data/fleet.csv"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] userSplit = line.split(",");
				if(userSplit[1].equals(register)){
					fleetName = userSplit[0] ;
					break;
				}
			}
		scan.close();
		}catch( IOException e ) {
			fleetName = " ";
			return fleetName;
		//	e.printStackTrace();
			
		}
		return fleetName;
	}
	public String getName(){
		return this.userName;
	}
	/**
	 * @param text
	 * @return
	 * @throws IOException
	 * this method returns the Welcome message that shows up when the suer signs in  
	 */
	public  String welcomeUser(String text)throws IOException {
		String str = "";
		String cap = text.substring(0, 1).toUpperCase() + text.substring(1);
		try {
			Scanner scan = new Scanner(new File("data/personnel.csv"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] userSplit = line.split(",");
				if(userSplit[0].toLowerCase().contains(text)){
					 str = userSplit[2] + " " + cap ;
					break;
				}
				if(!userSplit[0].toLowerCase().contains(text)){
					str = "No USER";
				}
			}
		scan.close();
		}catch( IOException e ) {
			e.printStackTrace();
		}
		
		return str;
	}
}