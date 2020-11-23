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
      "(0) Para salir"
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
      break;
      case 4:
      showEmployee();
      break;
      case 5:
      break;
      case 6:
      break;
      case 7:
      break;
      case 8:
      break;
      case 9:
      System.out.println(app.showInfo());
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
    System.out.println("1.to enter a player \n" +"2 to enter a head coach\n"+"3.to enter a assistant coach");
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
      System.out.println("Enter player position");
      String position=lector.nextLine();
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
     System.out.println("Enter the expertise");
     String expertise=lector.nextLine();
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




}







