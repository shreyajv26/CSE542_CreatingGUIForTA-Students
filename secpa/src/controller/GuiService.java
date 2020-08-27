package controller;

public interface GuiService {

	public void addEntry(String name, String email);
	
	public void removeEntry();
	
	public void pauseEntry(int rownumber);
	
	public void unpauseEntry(int rownumber);
	
}
