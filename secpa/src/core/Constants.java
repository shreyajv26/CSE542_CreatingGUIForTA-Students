package core;

import java.util.HashMap;

public class Constants {

	//Create a hashmap with preset list of email and name
	public static HashMap<String, String> preList = new HashMap<String, String>(){

		private static final long serialVersionUID = 1L;

		{
			put("nissim@mail.com", "Nissim");
			put("mathew@mail.com", "Mathew");
			put("hunter@mail.com", "Hunter");
			put("ivan@mail.com", "Ivan");
			put("jack@mail.com", "Jack");
			put("paul@mail.com", "Paul");
			put("owen@mail.com", "Owen");
			put("galvin@mail.com", "Galvin");
			put("valentine@mail.com", "Valentine");
			put("richard@mail.com", "Richard");
			put("chase@mail.com", "Chase");
		}};
	
	//initial number of random entries in queue
	public static int randomEntries = 3; 
	
	public static String order = "Queue Order";
	public static String colName = "Name";
	public static String colEmail = "Email";
	public static String colStatus = "Status";
	
	public static String pause = "Pause";
	public static String paused = "paused";
	public static String unpause = "Unpause";
	public static String unpaused = "unpaused";
	public static String remove = "Remove";
	
	public static String addStuButton = "Add Student";
	public static String name = "Name";
	public static String email = "Email";
	public static String password = "Session Password";
	public static String submit = "Submit";
	
	public static String pauseMsg = "The user is already paused";
	public static String unPauseMsg = "The user is already unpaused";
	public static String noRowMsg = "No Row Selected";
	public static String queueEmptyMsg = "Queue is Empty";
	public static String fieldEmptyMsg = "Field values cannot be empty";
	public static String pwdEmptyMsg = "Password field is empty";
	
}
