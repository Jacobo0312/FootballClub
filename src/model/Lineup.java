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
	

	public String toString (){
    String message = "";
	message = "\n ********** lineup ***********" +
	"\n Date: " + date +
	"\n Tatic: " + tactic +  
	"\n Lineup: \n" + MatrixToString() +
	"\n *************************";
	return message;
	}



   public String MatrixToString (){
         String message="";
         for (int i = 0; i < 10; i++){
            for (int j = 0; j < 7; j++){
                message+=(matrix[i][j]+"	");
            }
            message+="\n";
        }
        return message;
   }

	
}



