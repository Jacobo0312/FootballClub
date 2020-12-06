package model;
public class HeadCoach extends Coach implements Price,Level{
//Attributes
	private int numbersTeams;
	private int championships;
	private double price;
	private double level;

	public HeadCoach (String name, String id, double salary, int yearsExperience, int numbersTeams, int championships){
		super(name, id, salary, yearsExperience);
		this.numbersTeams=numbersTeams;
		this.championships=championships;
		this.price=calculatePrice();
		this.level=level();
	}

public double calculatePrice(){
	price=(getSalary()*10) + (getYears() *100) + (championships*50);
	return price;

}
public double level(){
	level=5+(championships/10);
	return level;
}
	public String toString(){
			String message = "";
			message = super.toString();
			
			message += "\n **********Head Coach***********" +
		    "\n Numbers of teams that he has trained: " + numbersTeams +
		    "\n telefono del doctor: " + championships + 
		    "\n Market price: " + price + 
		    "\n Level: " + level + 
			"\n ***************************************************";
			return message;
	}

public void setNumbersTeams (int teams){
	this.numbersTeams=teams;
}

public void setPrice(){
	this.price=calculatePrice();
}	

public void setLevel(){
	this.level=level();
}


}