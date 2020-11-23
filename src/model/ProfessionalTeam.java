package model;
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

public ProfessionalTeam (String name){
this.name=name;
this.coach=null;
players = new Player [MAX_PLAYERS];
assistents= new AssistantCoach [MAX_ASSISTANTCOACH];
this.coach=coach;
}

ProfessionalTeam TeamA= new ProfessionalTeam(TeamA);
ProfessionalTeam TeamB= new ProfessionalTeam(TeamB);



}