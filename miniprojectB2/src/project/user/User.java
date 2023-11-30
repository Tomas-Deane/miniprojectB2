package user;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
	private String username, password;
	private int id;

	public int getID() {
		return this.id;
	}

	public void setID(int IdValue) {
		this.id = IdValue;
	}

	public String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setNewID() { // Creates user specific ID and stores in text file "userID.txt"
		int newID = 1;
		try {
			File myObj = new File("userID.txt"); // Creates file if it does not exist
			if (!myObj.exists()) {
				myObj.createNewFile();
				BufferedWriter writer = new BufferedWriter(new FileWriter("userID.txt", true));
				writer.write("0");
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("userID.txt", true));
			BufferedReader reader = new BufferedReader(new FileReader("userID.txt"));
			String line = reader.readLine();
			String prevLine = "0";
			while (line != null) { // Reads through file to find last ID
				System.out.println(line);
				prevLine =line;
				line = reader.readLine();
				
			}
			
			newID += Integer.parseInt(prevLine); // Sets new ID to last ID + 1
			writer.append(String.format("\n%s", newID));
			writer.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		setID(newID);
	}

	public void setUserInfo(String username, String password) { // Stores new usernames and passwords to "userProfiles.txt" to save account information for future logins
		setNewID();
		try {
			File myObj = new File("userProfiles.txt");
			myObj.createNewFile();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("userProfiles.txt", true));
				Scanner reader = new Scanner("userProfiles.txt");
				while (reader.hasNextLine()) {
					writer.write("\n");
					reader.nextLine();

				}
				reader.close();

			writer.write(getID() + " " + username + " " + password);
			writer.close();
			setUsername(username);
			setPassword(password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// check details are same as in text file
	public boolean validLogIn(String username, String password) {
		try {
			File file = new File("userProfiles.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String nextLine = reader.nextLine().trim();
				String[] infoArr = nextLine.split("[ ]");

				if (username.equals(infoArr[1]) && password.equals(infoArr[2])) {
					reader.close();
					setID(Integer.parseInt(infoArr[0]));
					setUsername(infoArr[1]);
					setPassword(infoArr[2]);
					return true;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return false;
	}
}