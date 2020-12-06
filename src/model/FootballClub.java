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
private String [][] offices;
private String [][] dressingRoomsA;
private String [][] dressingRoomsB;

//Constructor

public FootballClub (String name, String nit, String foundationDate){
	this.name=name;
	this.nit=nit;
	this.foundationDate=foundationDate;
	this.employees= new ArrayList<Employee>();
    this.teams=new ProfessionalTeam [2];
    teams[0]=new ProfessionalTeam("TeamA");
    teams[1]=new ProfessionalTeam("TeamB");
    this.offices= new String [6][6];
    this.dressingRoomsA= new String [7][7];
    this.dressingRoomsB= new String [7][6];
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
	//Validaciones
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
		String message="";
		Employee objsearch = findEmployee(name);
		if (objsearch !=null){
		message = objsearch.toString();	
		}
		else{
			message="The employee does not exist";
		}
		

	return message;
	}

	public String showInfo(){
		String message = "";
		//MOstrad datos del clib


		for(int i = 0; i<employees.size(); i++){
				message += employees.get(i).toString();

			}
		message+=showTeamInfo(1);
		message+=showTeamInfo(2);
        message+=officesToString();
		message+=dreassingToString();
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



   public String addLineup(int option, String date, String lineup, String tatic){
   	    String message="";
		ProfessionalTeam team=null;
        if (option==1){
          team=teams[0];
        }
        else if (option==2)
        {
        	team=teams[1];
        }

     String[] lineups = lineup.split("-");
    
     int def=Integer.parseInt(lineups[0]);
     int mid=Integer.parseInt(lineups[1]);
     int ata=Integer.parseInt(lineups[2]);
     int suma=def+mid+ata;

	    if (suma != 10){
	    	message="!Invalid lineup¡";
	    }
	    else{
	    	int matrix [][]=new int [10][7];
	    	matrix [9][3]=1;
	    	matrix = lineupToMatrix(8,matrix,def);
	    	matrix = lineupToMatrix(5,matrix,mid);
	    	matrix = lineupToMatrix(2,matrix,ata);
	    	message=team.addLineup(date,matrix,tatic);
	    }
     return message;
   }


   public int [][] lineupToMatrix (int row, int [][] matrix, int option){
    switch (option){
    	case 1:
    	matrix[row][3]=1;
    	break;
    	case 2:
    	matrix [row][2]=1;
    	matrix [row][4]=1;
    	break;
    	case 3:
    	matrix [row][1]=1;
    	matrix [row][3]=1;
    	matrix [row][5]=1;
    	break;
    	case 4:
    	matrix [row][0]=1;
    	matrix [row][2]=1;
    	matrix [row][4]=1;
    	matrix [row][6]=1;
    	break;
    	case 5:
    	matrix [row][0]=1;
    	matrix [row][2]=1;
    	matrix [row][3]=1;
    	matrix [row][4]=1;
    	matrix [row][6]=1;
        break;
    }
    return matrix;
   }
    
public String showTeamInfo(int option){
   	String message="";
		ProfessionalTeam team=null;
        if (option==1){
          team=teams[0];
        }
        else if (option==2)
        {
        	team=teams[1];
        }
        message=team.toString();
        return message;
    }

public void locatedOffices (){
	 ArrayList <Employee> coaches;coaches= new ArrayList<Employee>();
	 for (int a=0;a<employees.size();a++){
	 	if (employees.get(a) instanceof Coach && employees.get(a).getStatus().equalsIgnoreCase("ACTIVE")){
	 		coaches.add(employees.get(a));
	 	}
	 }

	 int x=0;
	 for (int i = 0; i < 6 && x<coaches.size(); i++){
            for (int j = 0; j < 6 && x<coaches.size(); j++){
                if ((i%2==0 && j%2==0) || (i%2 !=0 && j%2 !=0)){	
	              
               
                  offices[i][j]=coaches.get(x).getName();
                  x++;
	             }
	             else
	             {
                  offices[i][j]="";   
	             }
            }
        }
}

public void cleanOffices(){
	 for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
            offices[i][j]="";

            }
        }
}


public String officesToString(){
	cleanOffices();
	locatedOffices();
	     String message="\n**************** OFFICES **************** \n ";
         for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (offices[i][j] !=null)
                	 message+=(offices[i][j]+"	");
               
            }
            message+="\n";
        }
        return message;
}

public void cleanDressingRooms(){
	for (int i = 0; i < 7; i++){
		for (int j = 0; j < 7; j++){
			dressingRoomsA[i][j]="";

		}
	}
	for (int i = 0; i < 7; i++){
		for (int j = 0; j < 6; j++){
			dressingRoomsB[i][j]="";

		}
	}

}





public void locatedDressingsA (){
	 ArrayList <Employee> playersA;playersA= new ArrayList<Employee>();
	 Player [] teamPlayersA=teams[0].getPlayers();

	 for (int a=0;a<teamPlayersA.length;a++){
	 	if (teamPlayersA[a] instanceof Player && teamPlayersA[a].getStatus().equalsIgnoreCase("ACTIVE")){
	 		playersA.add(teamPlayersA[a]);
	 	}
	 }
     
	 int x=0;
	 for (int i = 0; i < 7 && x<playersA.size(); i++){
            for (int j = 0; j < 7 && x<playersA.size(); j++){
                if ((i%2==0 && j%2==0) || (i%2 !=0 && j%2 !=0)){	
	              
               
                  dressingRoomsA[i][j]=playersA.get(x).getName();
                  x++;
	             }
	             else
	             {
                  dressingRoomsA[i][j]="";   
	             }
            }
        }
}

public void locatedDressingsB (){
	 ArrayList <Employee> playersB;playersB= new ArrayList<Employee>();
	 Player [] teamPlayersB=teams[1].getPlayers();
	 for (int a=0;a<teamPlayersB.length;a++){
	 	if (teamPlayersB[a] instanceof Player && teamPlayersB[a].getStatus().equalsIgnoreCase("ACTIVE")){
	 		playersB.add(teamPlayersB[a]);
	 	}
	 }
     
     Collections.shuffle(playersB);


	 int x=0;
	 for (int i = 0; i < 7 && x<playersB.size(); i++){
            for (int j = 0; j < 6 && x<playersB.size(); j++){
                if ((i%2==0 && j%2==0) || (i%2 !=0 && j%2 !=0)){	
	              
               
                  dressingRoomsB[i][j]=playersB.get(x).getName();
                  x++;
	             }
	             else
	             {
                  dressingRoomsB[i][j]="";   
	             }
            }
        }
}


public String dreassingToString(){
	cleanDressingRooms();
	locatedDressingsA();
	locatedDressingsB();
	     
	     String message="**************** DREASSING ROOM TEAM A **************** \n ";
         for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (dressingRoomsA[i][j] !=null)
                	 message+=(dressingRoomsA[i][j]+"	");
               
            }
            message+="\n";
        }
     
     	      message+="**************** DREASSING ROOM TEAM B **************** \n ";
         for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                if (dressingRoomsB[i][j] !=null)
                	 message+=(dressingRoomsB[i][j]+"	");
               
            }
            message+="\n";
        }
        return message;
}

public String setName (String name, String newname){
	String message="";
	Employee employee=findEmployee(name);
	if (employee ==null){
		message="The employee does not exist";
	}
	else{
		employee.setName(newname);
		message="The name was modified";
	}
	return message;
}

public String setId (String name, String id){
	String message="";
	Employee employee=findEmployee(name);
	if (employee ==null){
		message="The employee does not exist";
	}
	else{
		employee.setId(id);
		message="The id was modified";
	}
return message;
}

public String setSalary (String name, double salary){
	String message="";
	Employee employee=findEmployee(name);
	if (employee ==null){
		message="The employee does not exist";
	}
	else
	{
		employee.setSalary(salary);
		message="The salary was modified";
	}

	return message;
}

public String setYears (String name, int years){
	String message="";
	Employee employee=findEmployee(name);
	if (employee == null){
		message="The employee does not exist";	
	}
	else if (employee instanceof Coach)
	{
		((Coach)employee).setYearsExperience(years);
		message="The years was modified";
		if (employee instanceof HeadCoach){
			((HeadCoach)employee).setPrice();
		}
	}
return message;
}

public String setTeams (String name, int pTeams){
	String message="";
	Employee employee=findEmployee(name);
	if (employee==null){
		message="The employee does not exist";
	}
	else if (employee instanceof HeadCoach)
	{
		((HeadCoach)employee).setNumbersTeams(pTeams);
		message="The numbers team was modified";
	}
return message;
}


public String setChampions (String name, int champions){
	String message="";
	Employee employee=findEmployee(name);
	if (employee==null){
		message="The employee does not exist";
	}
	else if (employee instanceof HeadCoach)
	{
		((HeadCoach)employee).setNumbersTeams(champions);
		((HeadCoach)employee).setLevel();
		((HeadCoach)employee).setPrice();
		message="The numbers team was modified";
	}
return message;
}

public String setDorsal (String name, int dorsal){
	String message="";
	Employee employee=findEmployee(name);
	if (employee==null){
		message="The employee does not exit";
	}
	else{
		((Player)employee).setDorsal(dorsal);
		message="The dorsal was modified";
	}
return message;
} 

public String setPosition (String name, String position){
	String message="";
	Employee employee=findEmployee(name);
	if (employee==null){
		message="The employee does not exist";
	}
	else{
		((Player)employee).setPosition(position);
		message="The position was modified";
	}
	return message;
}

public String setExpertise(String name, String expertise){
	String message="";
	Employee employee=findEmployee(name);
	if (employee==null){
		message="The employee does not exist";
	}
	else if (employee instanceof AssistantCoach ){
		((AssistantCoach)employee).setExpertise(expertise);
		message="The expertise was modified";
	}
	return message;
}

public String setGoals(String name, int goals){
String message="";
Employee employee=findEmployee(name);
if (employee==null){
	message="The employee does not exist";
}	
else if (employee instanceof Player)
{
	((Player)employee).setGoals(goals);
	((Player)employee).setLevel();
	((Player)employee).setPrice();
	message="The goals was modified";
}
return message;
}

public String setRating (String name, double rating){
	String message="";
	Employee employee=findEmployee(name);
	if (employee == null){
		message="The employee does exist";
	}
	else if (employee instanceof Player)
	{
		((Player)employee).setRating (rating);
		message="The rating was modified";
	}
	return message;
}







}