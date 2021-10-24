package beans;


public class Registro{
	private String username;
	private String firstname;
	private String lastname;
	private String startTime;
	private String endTime;

	
	
	
	
	public Registro(String username, String firstname, String lastname, String startTime, String endTime) {
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


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	

	
}
