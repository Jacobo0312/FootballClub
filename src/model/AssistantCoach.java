package model;
public class AssistantCoach extends Coach{
//Attributes
	private boolean exPlayer;

	//Relationship
	private Expertise expertise;

	public AssistantCoach (String name, String id, double salary, int yearsExperience, boolean exPlayer, String expertise){
		super(name, id, salary, yearsExperience);
		this.exPlayer=exPlayer;
		this.expertise=Expertise.valueOf(expertise);
	}

	public String toString(){
		String message = "";
		message = super.toString();
		String ex="";
		if (exPlayer==true){
			ex="Was a player";
		}
			else
			{
				ex="He was not a player";
			}
		

		message += "\n **********Assistant Coach***********" +
		"\n"+ ex +
		"\n Expertise: " + expertise + 
		"\n ***************************************************";
		return message;
	}
	
public void setExpertise(String expertise){
	this.expertise=Expertise.valueOf(expertise);
}
	
}

		