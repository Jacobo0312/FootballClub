package model;
import java.util.*;
public class FootballClub{
	
//Attribute
private String name;
private String nit;
private String foundationDate;

//Relationship
private ArrayList <Employee> employees;
private ProfessionalTeam[] teams;


//Constructor

public FootballClub (String name, String nit, String foundationDate){
	this.name=name;
	this.nit=nit;
	this.foundationDate=foundationDate;
	this.employees= new ArrayList<Employee>();
    this.teams=new ProfessionalTeam [2];
    teams[0]=new ProfessionalTeam("TeamA");
    teams[1]=new ProfessionalTeam("TeamB");
}

//Methods

public Employee findEmployee(String name){
	Employee objSearch=null;
	boolean find=false;
	for (int i=0;i<employees.size() && !find;i++){
		if (employees.get(i).getName().equalsIgnoreCase(name)){
			objSearch=employees.get(i);
			find=true;	
		}
	}
	return objSearch;

}


public String addEmployee(String name, String id, double salary, int dorsal, int goals, double rating, String position){
	String message="";
	Employee employee=findEmployee(name);
	if (employee != null)
	{
		message="The employee is already registered";
	}
	else 
	{
     employees.add(new Player( name,  id,  salary,  dorsal,  goals,  rating,  position));
     message="The employee has been registered";
	}
return message;
}

public String addEmployee(String name, String id, double salary, int yearsExperience, int numbersTeams, int championships){
	String message="";
	Employee employee=findEmployee(name);
	if (employee != null)
	{
		message="The employee is already registered";
	}
	else 
	{
     employees.add(new HeadCoach( name,  id,  salary,  yearsExperience,  numbersTeams,  championships));
     message="The employee has been registered";
	}
return message;
}

public String addEmployee(String name, String id, double salary, int yearsExperience, boolean exPlayer, String expertise){
	String message="";
	Employee employee=findEmployee(name);
	if (employee != null)
	{
		message="The employee is already registered";
	}
	else 
	{
     employees.add(new AssistantCoach( name,  id,  salary,  yearsExperience,  exPlayer,  expertise));
     message="The employee has been registered";
	}
return message;
}

public String fireEmployee(String name){
	//Cambiar si el empleado pertenece a un equipo
	String message="";
	Employee employee=findEmployee(name);
	if (employee == null)
	{
		message="The employee does not exist";
	}
	else
	{
     employee.setStatus("INACTIVE");
     message="the employee has been dismissed";
	}
	return message;
}

	public String showEmployee(String name){
		Employee objsearch = findEmployee(name);
		String message = objsearch.toString();

	return message;
	}

	public String showInfo(){
		String message = "";
		for(int i = 0; i<employees.size(); i++){
				message += employees.get(i).toString();

			}
		return message;
	}


	public String addEmployeeToTeam(int option, String name){
		String message="";
		ProfessionalTeam team=null;
		Employee employee=findEmployee(name);
        if (option==1){
          team=teams[0];
        }
        else if (option==2)
        {
        	team=teams[1];
        }

		if (employee !=null){
			if (employee instanceof HeadCoach){
				message=team.addHeadCoach((HeadCoach)employee);
			}
			else if (employee instanceof AssistantCoach){
				message=team.addAssistent((AssistantCoach)employee);
			}
			else if (employee instanceof Player){
				message=team.addPlayer((Player)employee);
			}
		}
		else
		{
			message="The employee does not exist";
		}

		return message;
	}





}