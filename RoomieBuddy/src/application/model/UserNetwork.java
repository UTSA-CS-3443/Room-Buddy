package application.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class UserNetwork {
	
	
	
	
	private ArrayList<User> users; 
<<<<<<< HEAD
	private ArrayList<String> matchedusernames; 
=======
	private ArrayList<User> matchedUserNames; 
>>>>>>> branch 'master' of https://github.com/UTSA-CS-3443/Room-Buddy.git
	
	
	public UserNetwork(){ 
		
		
		users = new ArrayList<User>(); 
		matchedUserNames = new ArrayList<User>(); 
	}
	
	public ArrayList<User> getMatches(User currUser) {
		
		for( int i = 0; i < users.size() ; i++ )
		{
			
		}
		return this.matchedUserNames;
	}
	
	/*
	public ArrayList<User> compareUsers(String name){ 	
	}
	
	public User getUser(String name){ 	
		for(int x = 0; x < users.size(); x++){
			//if((users.get(x).getUsername()).equals(name))
		}
	
	}
	
	*/
	
	public void save() throws IOException{ 
		FileWriter f = new FileWriter("loginUPDATED.csv");
		String s = "";  
		for( int x = 0; x < users.size(); x++){
			s+= users.get(x).getName() + "," + users.get(x).getUsername() + "," + users.get(x).getPassword() + "," + users.get(x).getEmail() + "," + users.get(x).getPhoneNumber() + ",";
			String[] a = users.get(x).getData();
			for(int y = 0; y < 14; y++){
				s += a[y] + "," ;
			}
			
		}
		f.close();
	/*
		for (Map.Entry<Zone, ArrayList<Dinosaur>> entry : parkdata.entrySet()) {			
			for( int x = 0; x < entry.getValue().size(); x++){
				Dinosaur d = entry.getValue().get(x); 			
				String s = d.getName()+ "," +d.getType() + "," + Boolean.toString(d.getBolDiet()) + "," + d.getZCode() + "\n";
				f.write(s);
			}
		}
		f.close();
		*/
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public ArrayList<String> getMatchedusernames() {
		return matchedusernames;
	}


	public void setMatchedusernames(ArrayList<String> matchedusernames) {
		this.matchedusernames = matchedusernames;
	}
	
	
	
	
	
}
