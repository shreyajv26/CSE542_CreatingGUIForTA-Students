package core;

public class GuiEnums {
	
	public enum EventStatus{
		paused(1),
		unpaused(0);
		
		private int value;
		
		EventStatus(int value){
			this.value = value;
		}
		
	    public int getValue() {
	        return value;
	    }
	    
	    public void setValue(int value) {
	        this.value = value;
	    }
	}

}
