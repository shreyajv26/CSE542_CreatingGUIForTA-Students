package core;

import core.GuiEnums.EventStatus;

public class Data {
	
	private String name;
	
	private String email;
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	/*
	 * enum to store the status
	 */
	public EventStatus eventStatus;

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Data(String name, String email, EventStatus eventStatus){
		this.name = name;
		this.email = email;
		this.eventStatus = eventStatus;
	}

}
