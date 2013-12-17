import java.util.Scanner;

public class SudokuSolver
{
	Board board;

	public SudokuSolver(Board board)
	{
		this.board = board;
	}

	public void solve()
	{
		if(board.isSolved())
		{
			board.printBoard();
			return;
		}
		else
		{
			try
			{
				int position = board.findFirstBlank();
				int row = position / (board.getBoardSize());
				int col = position % (board.getBoardSize());
				for(int i = 1; i <= board.getBoardSize(); i ++)
				{
					board.fillSquare(i, row, col);
					if(board.isValidBoard())
					{
						solve();
					}
					else
					{
						board.blankSquare(row, col);
					}
				}

				board.blankSquare(row, col);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println("SUDOKU SOLVER");
		System.out.println("Enter a 9x9 input board row-wise with cell values separated by spaces");
		System.out.println("For blank cells, enter 'B'");
		Scanner inputReader = new Scanner(System.in);
		String[][] grid = new String[9][9];
		for(int i = 0; i < 9; i ++)
		{
			for(int j = 0; j < 9; j ++)
			{		
				grid[i][j] = inputReader.next();
			}	
		}

		Board board = new Board(9, 3, grid);
		SudokuSolver ss = new SudokuSolver(board);
		ss.solve();
	}
}
				
