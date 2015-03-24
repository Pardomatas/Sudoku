public class Sudoku {
	
	public int[][] boardarray;	//Sudoku board
	public int SIZE;
	
	//----------------------------------------------------------------------------------
	
	public Sudoku(int SIZE) {	//Constructor 
		boardarray = new int[SIZE][SIZE];
		this.SIZE = SIZE;
	}
	
	//-------------------------------------------------------------------------------------
	
	public int insert(int row, int col, int value) {   //insert one cell
		boardarray[row][col] = value;
		return value;	
	}
	
	//-------------------------------------------------------------------------------------
	
	public void insertFull(int[][] array) {	//insert full array
		boardarray = array;
	}
	
	//--------------------------------------------------------------------------------------
	
	public int singledisplay(int row, int col) {	//returns single number
		return boardarray[row][col];
	}
	
	//--------------------------------------------------------------------------------------
	
	public void display() {		//displays board 
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if((j%3) == 0)
					System.out.print("|");
				System.out.print(" " + boardarray[i][j] + " ");
			}
			System.out.print("|\n");
			if((i+1)%3 == 0)
				System.out.print("-------------------------------\n");
		}
	}
	
	//-------------------------------------------------------------------------------------
	
	public boolean rowCheck(int row, int num)	//checks row
	{
	    for (int col = 0; col < SIZE; col++)
	        if (boardarray[row][col] == num)
	            return false;
	    return true;
	}
	
	//--------------------------------------------------------------------------------------
	
	public boolean colCheck(int col, int num)	//checks column 
	{
	    for (int row = 0; row < SIZE; row++)
	        if (boardarray[row][col] == num)
	            return false;
	    return true;
	}
	
	//-----------------------------------------------------------------------------------------
	
	public boolean blockCheck(int startRow, int startCol, int num)	//checks block
	{
		startRow = (startRow / 3) * 3;
		startCol = (startCol / 3) * 3;
		
	    for (int row = 0; row < 3; row++)
	        for (int col = 0; col < 3; col++)
	            if (boardarray[startRow+row][startCol+col] == num)
	                return false;
	    return true;
	}
	
	//--------------------------------------------------------------------------------------
	public void next(int row, int col) throws Exception {
		if(col < SIZE-1)
			solve(row, col+1);
		else
			solve(row+1, 0);
	}
	
	//---------------------------------------------------------------------------------------
	
	public void solve(int row, int col) throws Exception {
		if(row > SIZE-1)
			throw new Exception("Solution found");
		
		if(boardarray[row][col] != 0)
			next(row, col);
		else {
			for(int num = 1; num < SIZE+1; num++)
			{
				if(rowCheck(row, num) && colCheck(col, num) && blockCheck(row, col, num))
				{
					boardarray[row][col] = num;
					next(row, col);
				}
			}
			boardarray[row][col] = 0;
		}
	}
	
	//---------------------------------------------------------------------------------------
	
	
}
