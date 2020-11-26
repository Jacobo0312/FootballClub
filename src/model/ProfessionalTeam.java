package model;
import java.util.*;
public class ProfessionalTeam {

//Constant

private final int MAX_ASSISTANTCOACH=3;
private final int MAX_PLAYERS=25;

//Attributes

private String name;

//Relationship
private Player [] players;
private AssistantCoach [] assistents;
private HeadCoach coach;
private ArrayList <Lineup> lineups;

public ProfessionalTeam (String name){
this.name=name;
this.coach=null;
players = new Player [MAX_PLAYERS];
assistents= new AssistantCoach [MAX_ASSISTANTCOACH];
this.lineups= new ArrayList<Lineup>();
}


public String addHeadCoach (HeadCoach employee){
String message="";
coach=employee;
if (coach != null){
    message="HeadCoach was already added";
}
else
{
 message="HeadCoach has been replaced";
}
return message;

}

public String addAssistent (AssistantCoach employee){
	String message="";
	boolean exit=false;
	for (int i=0;i<MAX_ASSISTANTCOACH && !exit;i++){
		if (assistents[i] ==null){
			assistents[i]=employee;
			exit=true;
			message="Assistant coach was alreay added";
		}
	}
	if (exit == false){
		message="The 3 assistant coaches already exist";
	}
	return message;
}

public String addPlayer (Player employee){
	String message="";
	boolean exit=false;
	for (int i=0;i<MAX_PLAYERS && !exit;i++){
		if (players[i] ==null){
			players[i]=employee;
			exit=true;
			message="Player was alreay added";
		}
	}
	if (exit == false){
		message="The 25 players already exist";
	}
	return message;
}

public String addLineup (String date,int [][] lineup, String tactic){
String message="the lineup was added";	
lineups.add(new Lineup(date,lineup,tactic));
return message;
}



}