/**
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * A00368502
 * Universidad Icesi (Cali-Colombia)
 * @Author: Jacobo Garcia
 * @Date: 18 noviembre 2020
 *
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

  package ui;
  import java.util.Scanner;
  import model.FootballClub;
  public class Main{

  //Relations 
  	private FootballClub app;
  	private Scanner lector;



    public Main(){
      lector=new Scanner(System.in);
    }
    
    public static void main(String [] args) {
      
      Main ppal= new Main();
      int option=0;
      ppal.createFootballClub();
      System.out.println("Starting...");


      do{
       option= ppal.showMenu();
       ppal.executeOperation(option);

     }while (option!=0);

   }

   public int showMenu() {
    int option=0;

    System.out.println(
      "Select an option\n" +
      "(1) Hire employees\n" +
      "(2) Fire employees \n"+
      "(3) Add coachs or players to teams\n"+
      "(4) Show employee information \n"+ 
      "(5) Add lineup \n"+
      "(6) Show team information \n"+
      "(7) Place coaches in offices \n" +
      "(8) Place players in locker rooms  \n" +
      "(9) Show club information  \n" +
      "(10) To modify employees  \n" +
      "(0) To exit"
      );
    option= lector.nextInt();
    lector.nextLine();
    return option;
  }

  public void executeOperation(int operation) {

    switch(operation) {
      case 0:
      System.out.println("Bye!");
      break;
      case 1:
      addEmployee();
      break;
      case 2:
      fireEmployee();
      break;
      case 3:
      addEmployeeToTeam();
      break;
      case 4:
      showEmployee();
      break;
      case 5:
      createLineup();
      break;
      case 6:
      showTeamInfo();
      break;
      case 7:
      System.out.println(app.officesToString());
      break;
      case 8:
      System.out.println(app.dreassingToString());
      break;
      case 9:
      System.out.println(app.showInfo());
      break;
      case 10:
      modify();
      break;
      default:
      System.out.println("Error...");
    }
  }

  
  public void createFootballClub(){
    System.out.println("Enter name football club");
    String name=lector.nextLine();
    System.out.println("Enter NIT football club");
    String nit=lector.nextLine();
    System.out.println("Enter foundation date football club");
    String foundationDate=lector.nextLine();
    app= new FootballClub(name,nit,foundationDate);
    System.out.println("The Football Club was created");
  }




  public void addEmployee(){
    String message="";
    System.out.println("1.to enter a player \n" +"2. to enter a head coach\n"+"3.to enter a assistant coach");
    int option=lector.nextInt();lector.nextLine();
    System.out.println("Enter name ");
    String name=lector.nextLine();
    System.out.println("Enter id ");
    String id=lector.nextLine();
    System.out.println("Enter salary ");
    double salary=lector.nextDouble();lector.nextLine();
    //mirar si se puede colcoar un if para ahorrar years experiene

    switch(option){
      case 1:
      System.out.println("Enter dorsal player");
      int dorsal=lector.nextInt();lector.nextLine();
      System.out.println("Enter the goals the player has scored");
      int goals=lector.nextInt();lector.nextLine();
      System.out.println("Enter average player rating");
      double rating=lector.nextDouble();lector.nextLine();
      System.out.println("Enter player position: GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD");
      String position=lector.nextLine().toUpperCase();;
      message=app.addEmployee( name,  id,  salary,  dorsal,  goals,  rating,  position);
      break;

      case 2:
      System.out.println("enter the coach's years of experience");
      int yearsExperience=lector.nextInt();lector.nextLine();
      System.out.println("Enter the number of number of teams you have directed");
      int numbersTeams=lector.nextInt();lector.nextLine();
      System.out.println("Enter the championships the coach has won");
      int championships=lector.nextInt();lector.nextLine();
      message=app.addEmployee( name,  id,  salary,  yearsExperience,  numbersTeams,  championships);
      break;

      case 3:
      System.out.println("enter the coach's years of experience");
      yearsExperience=lector.nextInt();lector.nextLine();
      System.out.println("If it was a player ENTER 1, if not ENTER 2");
      int x=lector.nextInt();lector.nextLine();
      boolean exPlayer=false;
      if (x==1){
       exPlayer=true;
     }
     System.out.println("Enter the expertise: OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY");
     String expertise=lector.nextLine().toUpperCase();;
     message=app.addEmployee( name,  id,  salary,  yearsExperience,  exPlayer,  expertise);
     break;
   }

 System.out.println(message);
 }

 public void fireEmployee(){
  System.out.println("Enter the name of the employee to fire");
  String name=lector.nextLine();
  String message=app.fireEmployee(name);
  System.out.println(message);
 }

 public void showEmployee(){
  System.out.println("Enter the name of the employee");
  String name=lector.nextLine();
  System.out.println(app.showEmployee(name));
 }

 public void addEmployeeToTeam (){
  System.out.println("Enter the name of the employee");
  String name=lector.nextLine();
  System.out.println("Enter 1 for team A, Enter 2 for team B");
  int team=lector.nextInt();lector.nextLine();
  switch(team){
    case 1: 
    System.out.println(app.addEmployeeToTeam(1,name));
    break;
    case 2: 
    System.out.println(app.addEmployeeToTeam(2,name));
    break;
  }

 }

 public void createLineup(){
 System.out.println("Enter 1 for team A, Enter 2 for team B");
 int team=lector.nextInt();lector.nextLine();
 System.out.println("Enter date of the lineup");
 String date=lector.nextLine();
 System.out.println("Enter the lineup,example: 4-4-2");
 String lineup=lector.nextLine();
 System.out.println("Enter the tactic that can be POSSESSION, COUNT_ATTACK, HIGH_PRESSURE or DEFAULT.");
 String tatic=lector.nextLine().toUpperCase();;
 System.out.println(app.addLineup(team, date, lineup, tatic));
 }



 public void showTeamInfo(){
  System.out.println("Enter 1 for team A, Enter 2 for team B");
  int team=lector.nextInt();lector.nextLine();
  System.out.println(app.showTeamInfo(team));
 }


public void modify() {
    
    int option;
    
    System.out.println("Modificar atributo de empleado");
    System.out.println("write the name of the employee you want to modify");
    String name = lector.nextLine();
    System.out.println("What information, do you want to modify?");
    System.out.println
                      ("\n 1.to modify the name."+
                        "\n 2.For the id."+
                        "\n 3.For the salary."+
                        "\n 4.if is a coach write 4 to modify years experience. "+
                        "\n 5.if is a head coach, choose 5 to modify teams in charge or."+ 
                        "\n 6. to modify championship won"+
                        "\n 7.is you want modifythe expertice"+
                        "\n 8.if is  a player, choose 9 to modify player number,"+
                        "\n 9. to modify de position,"+
                        "\n 10. to modify goals or"+
                        "\n 11. to modify rating");
    
    option = lector.nextInt();lector.nextLine();
    
    switch(option) {
    case 1:
    System.out.println("Write the new name"); 
    String newname = lector.nextLine();
    System.out.println(app.setName( name,newname));
      break;
    case 2:
    System.out.println("Write the new id");
    String newid= lector.nextLine();
    System.out.println(app.setId(name, newid));
      break;
    case 3:
    System.out.println("Write the new salary");
    double newsalary = lector.nextDouble();
    System.out.println(app.setSalary( name, newsalary));
      break;
    case 4:
    System.out.println("Write the new years experience");
    int newyears = lector.nextInt();lector.nextLine();
    System.out.println(app.setYears( name,  newyears));
      break;
    case 5:
    System.out.println("Write the new teams in charge");
    int newteams = lector.nextInt();lector.nextLine();
    System.out.println(app.setTeams(name, newteams));
      break;
    case 6:
    System.out.println("Write the new championschip won");
    int newchampions = lector.nextInt();lector.nextLine();
    System.out.println(app.setChampions(name, newchampions));
      break;
    case 7:
    System.out.println("Write the new expertice(OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY)");
    String newexpertice = lector.nextLine();
    System.out.println(app.setExpertise(name, newexpertice));
      break;
    case 8:
    System.out.println("Write the new player number");
    int newnumber = lector.nextInt();lector.nextLine();
    System.out.println(app.setDorsal( name, newnumber));
      break;
    case 9:
    System.out.println("Write the new position (GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD)");
    String newposition = lector.nextLine().toUpperCase();
    System.out.println(app.setPosition( name, newposition));
      break;
    case 10:
    System.out.println("Write the new goals");
    int newgoals = lector.nextInt();lector.nextLine();
    System.out.println(app.setGoals( name, newgoals));
      break;
    case 11:
    System.out.println("Write the new rating");
    double newrating = lector.nextDouble();lector.nextLine();
    System.out.println(app.setRating( name,newrating));
      break;  
    } 
  }


}







