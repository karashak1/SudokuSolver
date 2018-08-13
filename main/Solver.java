package main;

import java.util.LinkedList;

public class Solver {
	
	private Integer[][] table;

	public Solver(Integer[][] table){
		this.table = table;
	}
	
	public Integer[][] getTable(){
		return table;
	}
	
	public boolean solve(){
		return solve(0,0);
	}
	
	private boolean solve(int row, int col){
		if(col == 9){
			col = 0;
			row++;
		}
		if(row == 9)
			return true;
		//if not a clue then we need to find value otherwise move on
		if(table[row][col] == null){
			int x = 1;
			boolean done = false;
			while(!done && x <= 9){
				//table[row][col] = x;
				//todo validate , move on to the next iteration
				//System.out.println("testing "+row+","+col+" value:"+x);
				if(validate(row,col,x)){
					table[row][col] = x;
					done = solve(row,col+1);
				}
				x++;
			}
			if(done == false)
				table[row][col]= null;
			return done;
		}
		else
			return solve(row, col+1);
		
	}
	
	private boolean validate(int row, int col, int testCase){
		return rowValid(row,testCase) && columnValid(col, testCase) && boxValid(row,col, testCase);
	}
	
	private boolean rowValid(int row, int testCase){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(testCase);
		for(int x = 0; x < table[row].length; x++){
			if(table[row][x]  != null){
				if(list.contains(table[row][x]))
					return false;
				else
					list.add(table[row][x].intValue());
			}
		}
		return true;
	}
	
	private boolean columnValid(int col, int testCase){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(testCase);
		for(int x = 0; x < table.length; x++){
			if(table[x][col]  != null){
				if(list.contains(table[x][col]))
					return false;
				else
					list.add(table[x][col].intValue());
			}
		}
		return true;
	}
	
	public boolean boxValid(int row, int col, int testCase){
		int startX = (row/3)*3;
		int startY = (col/3)*3;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(testCase);
		for(int x = startX; x < startX+3; x++){
			for(int y = startY; y < startY+3; y++){
				if(table[x][y] != null){
					if(list.contains(table[x][y]))
						return false;
					else
						list.add(table[x][y].intValue());
				}
			}
		}
		return true;
	}
	
	public String toString(){
		String temp = "";
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				if(table[i][j] == null)
					temp +='X';
				else
					temp += table[i][j].intValue();
			}
			temp +="\n";
		}
		return temp;
	}

}
