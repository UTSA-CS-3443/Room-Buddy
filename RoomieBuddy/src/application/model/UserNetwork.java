


package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class UserNetwork {




	private ArrayList<User> users; 
	private ArrayList<String> matchedusernames; 


	public UserNetwork(){ 


		users = new ArrayList<User>(); 
		matchedusernames = new ArrayList<String>(); 
	}


	public ArrayList<String> getMatches(User currUser){

		String classification = currUser.getData()[0];
		String major = currUser.getData()[1];
		String clean = currUser.getData()[2];
		String party = currUser.getData()[3];
		String music = currUser.getData()[4];
		String film = currUser.getData()[5];
		String gaming = currUser.getData()[6];
		String sports = currUser.getData()[7];
		String hiking = currUser.getData()[8];
		String reading = currUser.getData()[9];
		String gender = currUser.getData()[10];
		String university = currUser.getData()[11];
		String apartment = currUser.getData()[12];


		ArrayList<String> names = new ArrayList<String>();
		int threshold = 8;
		int count;

		try {
			Scanner scan = new Scanner ( new File("data/results.csv") );

			while( scan.hasNextLine() ) {
				count = 0;
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				if(!tokens[0].toLowerCase().equals(currUser.getName())) {


					if(tokens[2].toLowerCase().equals(classification)){
						count++;
					}
					if(tokens[3].toLowerCase().equals(major)){
						count++;
					}
					if(tokens[4].toLowerCase().equals(clean)){
						count++;
					}
					if(tokens[5].toLowerCase().equals(party)){
						count++;
					}
					if(tokens[6].toLowerCase().equals(music)){
						count++;
					}
					if(tokens[7].toLowerCase().equals(film)){
						count++;
					}
					if(tokens[8].toLowerCase().equals(gaming)){
						count++;
					}
					if(tokens[9].toLowerCase().equals(sports)){
						count++;
					}
					if(tokens[10].toLowerCase().equals(hiking)){
						count++;
					}
					if(tokens[11].toLowerCase().equals(reading)){
						count++;
					}
					if(tokens[12].toLowerCase().equals(gender)){
						count++;
					}
					if(tokens[13].toLowerCase().equals(university)){
						count++;
					}
					if(tokens[14].toLowerCase().equals(apartment)){
						count++;
					}
					System.out.println(count);
					if(count >= threshold) {
						names.add(tokens[0]);
					}
				}
			}
			scan.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(names);
		return names;
	}

	/*public User getUser(String name){ 	
		for(int x = 0; x < users.size(); x++){
			//if((users.get(x).getUsername()).equals(name))
		}

	}*/



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

	public int getExistingUser(String user, String pass){
		for(int x = 0; x < users.size(); x++){
			if((users.get(x).getUsername()).equals(user) && (users.get(x).getPassword()).equals(pass)){
				return x; 
			}
		}

		return -1; 
	}

	public void updateExistingUser(int index,String[] updated){

		users.get(index).setData(updated); 


	}




}
