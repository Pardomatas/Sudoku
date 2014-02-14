package Sudoku;

import java.io.*;

public class Sudoku{

	public int [][] boardarray = new int[4][4];	//sudoku board
	public int[] checkarray = new int [4];	//number checks
	public int[] answerarray = new int [4];	//finds answer
	public boolean[] check = new boolean[4];	//gets answer
	public int line, run;
	
//-------------------------------------------------------------------------------------
	
	public int insert(int row, int col, int value){   //inserts numbers
		boardarray[row-1][col-1] = value;
		return value;	
	}
	
//-------------------------------------------------------------------------------------
	
	public void display(){		//displays board
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 2)
					System.out.print("|");
				System.out.print(boardarray[i][j]);
			}
			if(i == 1)
				System.out.print("\n-----");
			System.out.println();
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void singledisplay(int row, int col){	//displays single number
		System.out.println(boardarray[row-1][col-1]);
	}
	
//-------------------------------------------------------------------------------------
	
	public void blockcheck(int row, int col){ //checks block
		int k = 0;
		if(row < 2 && col < 2){		//block 1
			for(int i = 0; i < 2; i++){
				for(int j = 0; j < 2; j++){
					checkarray[k] = boardarray[i][j];
					//System.out.print(checkarray[k]);
					k++;
					answercheck(checkarray);
				}
			}
		}
		else if(row < 2 && col > 1){	//block 2
			for(int i = 0; i < 2; i++){
				for(int j = 2; j < 4; j++){
					checkarray[k] = boardarray[i][j];
					//System.out.print(checkarray[k]);
					k++;
					answercheck(checkarray);
				}
			}
		}
		else if(row > 1 && col < 2){	//block 3
			for(int i = 2; i < 4; i++){
				for(int j = 0; j < 2; j++){
					checkarray[k] = boardarray[i][j];
					//System.out.print(checkarray[k]);
					k++;
					answercheck(checkarray);
				}
			}
		}
		else if(row > 1 && col > 1){	//block 4
			for(int i = 2; i < 4; i++){
				for(int j = 2; j < 4; j++){
					checkarray[k] = boardarray[i][j];
					//System.out.print(checkarray[k]);
					k++;
					answercheck(checkarray);
				}
			}
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void rowcheck(int row, int col){	//checks row
		int j = 0;
		for(int i = 0; i < 4; i++){
			checkarray[j++] = boardarray[row][i];
			//System.out.print(checkarray[i]);
		}
		//System.out.println();
		answercheck(checkarray);
	}
	
//-------------------------------------------------------------------------------------
	
	public void colcheck(int row, int col){	//checks column
		int j = 0;
		for(int i = 0; i < 4; i++){
			checkarray[j++] = boardarray[i][col];
			//System.out.print(checkarray[i]);
		}
		//System.out.println();
		answercheck(checkarray);
	}
	
//-------------------------------------------------------------------------------------
	
	public void answercheck(int [] b){	//finds all used numbers
		for(int j = 0; j < b.length; j++){
			if(b[j] == 1){
				check[0] = true;
			}
			if(b[j] == 2){
				check[1] = true;
			}
			if(b[j] == 3){
				check[2] = true;
			}
			if(b[j] == 4){
				check[3] = true;
			}
		}
		check();
	}
	
//-------------------------------------------------------------------------------------
	
	public void check(){	//finds possible answer
		int i = 0;
		int answer = 0;
		if(check[0] == false){
			answer = 1;
			i++;
		}
		if(check[1] == false) {
			answer = 2;
			i++;
		}
		if(check[2] == false) {
			answer = 3;
			i++;
		}
		if(check[3] == false) {
			answer = 4;
			i++;
		}
		if(i == 1){
			insert(line + 1, run + 1, answer);
			i = 0;
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void start(){	//trigger
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(boardarray[i][j] == 0){
					line = i;
					run = j;
					rowcheck(i, j);
					colcheck(i, j);
					blockcheck(i, j);
					reset();
				}
			}
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void reset(){	//resets everything
		check[0] = false;
		check[1] = false;
		check[2] = false;
		check[3] = false;
		checkarray[0] = 0;
		checkarray[1] = 0;
		checkarray[2] = 0;
		checkarray[3] = 0;
		line = 0;
		run = 0;
	}
	
//-------------------------------------------------------------------------------------

	public boolean retry(){	//counts zeros 
		int zerocount = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(boardarray[i][j] == 0){
					zerocount++;
				}
			}
		}
		if(zerocount > 0){
			return true;
		}else{
			return false;
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void resetarray(){	//resets boardarray
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				boardarray[i][j] = 0;
			}
		}
	}
	
//-------------------------------------------------------------------------------------
	
	public void writedisplay() throws IOException{
		PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true));	//writes boardarray to file
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 2)
					writer.print("|");
				writer.print(boardarray[i][j]);
			}
			if(i == 1)
				writer.print("\n-----");
			writer.println();
		}
		writer.close();
	}
	
//-------------------------------------------------------------------------------------
	
	public void write(String message) throws IOException{		//writes string to file
		PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true));
		writer.println(message);
		writer.close();
	}
	
//-------------------------------------------------------------------------------------
	
	public void checkdouble(){
		int count = 0;
		for(int i = 0; i < 4; i++){
			if(check[i] == false){
				count++;
			}
		}
		System.out.println(count);
	}
}