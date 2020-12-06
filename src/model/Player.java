package model;
public class Player extends Employee implements Price,Level{

//Attributes
private int dorsal;
private int goals;
private double rating;
private double price;
private double level;

//Relationships
private Position position;

public Player (String name, String id, double salary, int dorsal, int goals, double rating, String position){
super(name,id,salary);
this.dorsal=dorsal;
this.goals=goals;
this.rating=rating;
this.position=Position.valueOf(position);
this.price=calculatePrice();
this.level=level();

}

public double calculatePrice(){
switch (position){
	case GOALKEEPER:
    price=(getSalary()*12)+(rating*150);
    break;

    case DEFENDER:
    price=(getSalary()*13)+(rating*125)+(goals*100);
    break;

    case MIDFIELDER:
    price=(getSalary()*14)+(rating*135)+(goals*125);
    break;

    case FORWARD:
    price=(getSalary()*15)+(rating*145)+(goals*150);
    break;
}
return price;

}

public double level (){
switch (position){
	case GOALKEEPER:
    level=(rating*0.9);
    break;

    case DEFENDER:
    level=(rating*0.9)+(goals/100);
    break;

    case MIDFIELDER:
    level=(rating*0.9)+(goals/90);
    break;

    case FORWARD:
    level=(rating*0.9)+(goals/80);
    break;
 }
 return level;	
}

public String toString(){
   String message = "";
   message = super.toString();

   message += "\n **********Player***********" +
   "\n Dorsal: " + dorsal +
   "\n Goals scored: " + goals + 
   "\n Average rating: " + rating + 
   "\n Position: " + position + 
   "\n Market price: " + price + 
   "\n Level: " + level + 
   "\n ***************************************************";
   return message;
}

public void setGoals(int goals){
  this.goals=goals;
}

public void setRating(double rating){
  this.rating=rating;
}

public void setPosition(String position){
  this.position=Position.valueOf(position);
}

public void setDorsal (int dorsal){
  this.dorsal=dorsal;
}

public void setLevel(){
  this.level=level();
}

public void setPrice (){
  this.price=calculatePrice();
}



}