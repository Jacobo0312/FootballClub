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


public void setStatus(String pStatus){
	status=pStatus;
}

public double getSalary(){
	return salary;
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
