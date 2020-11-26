package model;
public class Lineup{
//Attributes
	private String date;
    private int [][] matrix;


//Relationships
	private Tactic tactic;

	public Lineup (String date,int [][] matrix, String tactic){
    this.date=date;
    this.matrix=matrix;
    this.tactic=Tactic.valueOf(tactic);
	}
	
	
}