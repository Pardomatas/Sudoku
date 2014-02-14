package Sudoku;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Sudoku sudoku = new Sudoku();
		
		Scanner textfile = new Scanner(new File("fileA.txt"));
		
		sudoku.write("Mychal Wilson");
		sudoku.write("");
		
		for(int i = 1; i < 4; i++){
			while(true){
				String name = textfile.next();
				String[] str = name.split(",");
				int row = Integer.parseInt(str[0]);
				int col = Integer.parseInt(str[1]);
				int value = Integer.parseInt(str[2]);
	
				if(value == 0){
					break;
				}else{
					sudoku.insert(row, col, value);
				}
			}
			
			String num = Integer.toString(i);
			sudoku.write(num + ")");
	
			sudoku.start();
			
			if(sudoku.retry() == true){
				sudoku.start();
			}
			
			if(sudoku.retry() == true){
				sudoku.start();
			}
			
			if(sudoku.retry() == true){
				System.out.println("No Solution");
				sudoku.write("No Solution");
				sudoku.write("");
			}else{
				sudoku.display();
				sudoku.writedisplay();
				sudoku.write("");
			}
			
			System.out.println();
			
			sudoku.resetarray();
		}	
	}
}
