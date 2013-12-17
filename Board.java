public class Board
{
	int boardSize;	
	int boxSize;
	int[][] grid = new int[9][9];
	int blank;
	
	public Board(int boardSize, int boxSize, String[][] inputGrid)
	{
		this.boardSize = boardSize;
		this.boxSize = boxSize;
		this.blank = 123;
		for(int i = 0; i < boardSize; i ++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				if(inputGrid[i][j].equals("B"))
				{
					this.grid[i][j] = blank;
				}
				else
				{
					this.grid[i][j] = Integer.parseInt(inputGrid[i][j]);	
				}
			}
		}
		
	}

	public int getBoardSize()
	{
		return boardSize;
	}

	public int getBoxSize()
	{
		return boxSize;
	}

	public int getBlank()
	{
		return blank;
	}

	public boolean isSolved()
	{
		for(int i = 0; i < boardSize; i ++)
		{
			for(int j = 0; j < boardSize; j ++)
			{
				if(grid[i][j] == blank)
				{
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValidBoard()
	{
		return (isValidRows() && isValidCols() && isValidBoxes());
	}

	public boolean isValidRows()
	{
		for(int i = 0; i < boardSize; i ++)
		{
			boolean[] found = new boolean[boardSize];
			for(int j = 0; j < boardSize; j ++)
			{
				if(grid[i][j] == blank) 
					continue;
				int index = grid[i][j] - 1;
				if(found[index] == true)
				{
					return false;	
				}
				else
				{
					found[index] = true;
				}
			}

		}

		return true;
	}

	public boolean isValidCols()
	{
		for(int i = 0; i < boardSize; i ++)
		{
			boolean[] found = new boolean[boardSize];
			for(int j = 0; j < boardSize; j ++)
			{
				if(grid[j][i] == blank) 
					continue;
				int index = grid[j][i] - 1;
				if(found[index] == true)
				{
					return false;	
				}
				else
				{
					found[index] = true;
				}
			}
		}

		return true;
	}

	public boolean isValidBoxes()
	{
		for(int i = 0; i < (3 * boxSize); i = i + boxSize)
		{
			for(int j = 0; j < (3 * boxSize); j = j + boxSize)
			{
				boolean[] found = new boolean[boardSize];
				for(int k = i; k < (i + 3); k ++)
				{
					for(int l = j; l < (j + 3); l ++)
					{
						if(grid[k][l] == blank) 
							continue;
						int index = grid[k][l] - 1;
						if(found[index] == true)
						{
							return false;	
						}
						else
						{
							found[index] = true;
						}
					}
				}
			}
		}
		return true;
		
	}

	public int findFirstBlank() throws Exception
	{
		for(int i = 0; i < boardSize; i ++)
		{	
			for(int j = 0; j < boardSize; j ++)
			{
				if(grid[i][j] == blank)
				{
					return (i * boardSize) + j;
				}
			}
		}

		throw new Exception("Board contains no blank squares");			
	}

	public void fillSquare(int value, int row, int col) throws Exception
	{
		if(checkValue(value) && checkLimits(row, col))
		{
			grid[row][col] = value;
		}

		else
		{
			throw new Exception("Value, row and col values should be between 1-9");
		}
	}

	public void blankSquare(int row, int col) throws Exception
	{
		if(checkLimits(row, col))
		{
			grid[row][col] = blank;
		}
		
		else
		{
			throw new Exception("Row and col values should be between 1-9");
		}
	}

	public boolean checkValue(int value)
	{
		return (value > 0 && value <= boardSize);
	}

	public boolean checkLimits(int row, int col)
	{
		return (row >= 0 && row < boardSize && col >= 0 && col < boardSize);
	}

	
	public void printBoard()
	{
		System.out.println();
		for(int i = 0; i < boardSize; i ++)
		{
			for(int j = 0; j < boardSize; j ++)
			{
				if(grid[i][j] == blank)
					System.out.print("B");
				else
					System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
