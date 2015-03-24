public class Main {

	public static void main(String[] args) throws Exception {
		
		Sudoku sudoku = new Sudoku(9);
		
		int[][] problem1 = new int[][]{
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
	            {5, 2, 0, 0, 0, 0, 0, 0, 0},
	            {0, 8, 7, 0, 0, 0, 0, 3, 1},
	            {0, 0, 3, 0, 1, 0, 0, 8, 0},
	            {9, 0, 0, 8, 6, 3, 0, 0, 5},
	            {0, 5, 0, 0, 9, 0, 6, 0, 0},
	            {1, 3, 0, 0, 0, 0, 2, 5, 0},
	            {0, 0, 0, 0, 0, 0, 0, 7, 4},
	            {0, 0, 5, 2, 0, 6, 3, 0, 0}
		};
		
		sudoku.insertFull(problem1);
		//sudoku.display();
		
		try {
			sudoku.solve(0, 0);
		}
		catch(Exception e)
		{
		}
		
		sudoku.display();

		
	}

}
