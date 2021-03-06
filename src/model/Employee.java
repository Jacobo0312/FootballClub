package model;
public abstract class Employee {

//Attributes
private String name;
private String id;
private double salary;
private String status;

public Employee (String name, String id, double salary){
	this.name=name;
	this.id=id;
	this.salary=salary;
	this.status="ACTIVE";
}

public String getName(){
	return name;
}

public String getStatus(){
	return status;
}


public void setStatus(String pStatus){
	status=pStatus;
}

public double getSalary(){
	return salary;
}

public void setName(String name){
	this.name=name;
}

public void setId(String id){
	this.id=id;
}

public void setSalary(double salary){
	this.salary=salary;
}


public String toString(){

	String message = "";
	message = "\n ********** EMPLOYEE ***********" +
	"\n Name of the employee: " + name +
	"\n Id of the employee: " + id +  
	"\n salary: " + salary +
	"\n Status: " + status +
	"\n *************************";
	return message;
}


}
