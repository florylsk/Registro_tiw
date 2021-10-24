package beans;

import java.sql.Timestamp;

public class Registro{
	private String username;
	private String firstname;
	private String lastname;
	private Timestamp startTime;
	private Timestamp endTime;

	
	
	
	
	public Registro(String username, String firstname, String lastname, Timestamp startTime, Timestamp endTime) {
		  this.username=username;
		  this.firstname=firstname;
		  this.lastname=lastname;
		  this.startTime=startTime;
		  this.endTime=endTime;
		 }
	
	
	public String getUsername() {
		return this.username;	
	}
	
	public void setUsername (String username) {
		this.username=username;
	}
	
	
	public String getFirstname() {
		return this.firstname;	
	}
	
	public void setFirstname (String firstname) {
		this.firstname=firstname;
	}
	
	public String getLastname() {
		return this.lastname;	
	}
	
	public void setLastname(String lastname) {
		this.lastname=lastname;
	}


	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public Timestamp getEndTime() {
		return endTime;
	}


	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	

	
}
