package main;

import util.TableUtil;



public class Main {
	
	public static void main(String args[]){
		try{
			for(int x = 0; x < args.length; x++){
				Solver solver = new Solver(TableUtil.readFile(args[x]));
				if(solver.solve())
					TableUtil.writeTable(solver.getTable(), args[x].substring(0, args[x].lastIndexOf('.'))+".sln.txt");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
