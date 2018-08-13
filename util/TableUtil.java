package util;

import java.io.*;

public class TableUtil {
	
	public static Integer[][] readFile(String input){
		Integer[][] table = new Integer[9][9];
		try{
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line;
			int row = 0;
			while((line = reader.readLine()) != null){
				for(int col = 0; col < 9; col++){
					if(line.charAt(col) != 'X'){
						table[row][col] = Integer.parseInt(line.substring(col, col+1));
					}
				}
				row++;		
			}
			reader.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return table;
	}
	
	public static boolean writeTable(Integer[][] table, String fileName){
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
			for(int x = 0; x < table.length; x++){
				for(int y = 0; y < table[x].length; y++){
					writer.print(table[x][y]);
				}
				writer.println();
			}
			writer.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return false;
	}

}
