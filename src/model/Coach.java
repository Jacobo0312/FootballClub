package model;
public abstract class Coach extends Employee{

//Attributes
private int yearsExperience;

public Coach (String name, String id, double salary, int yearsExperience){
super(name,id,salary);
this.yearsExperience=yearsExperience;
}


public int getYears(){
	return yearsExperience;
}

public String toString(){

	String message ="";
	message = super.toString();
	message += "\n **********Coach***********" +
	"\n Years of experience  : " + yearsExperience +
	"\n ***************************************************";
	return message;
}

}