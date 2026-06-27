//import java.util.Arrays;
public class Battleship {

	public static void main(String[] args)
	{
		char [][] board = {
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','S','S','.','.','.','.','.','.'},
				{'.','.','*','*','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','S','S','S','.','S','*'},
				{'.','.','.','.','.','.','.','.','.','.'},
		};
		System.out.println(boardSquare('*'));
		//System.out.println(validBoardSquare('S'));
		System.out.println(validBoard(board));
		System.out.println(numberSunk(board));
		System.out.println(getHit(1,'D',board));
		System.out.println(countShip(board,"Battleship","damaged"));
		System.out.println(calculateDamage(board));
	}
	
	public static Boolean boardSquare(char valid) {
		if (valid != '.' && valid != 'S' && valid != '*'){
            return false;
        }
        else {
            return true;
        }
	}
	
	// METHOD 2 (Boolean, return char)
	public static Boolean validBoardSquare(char valid) {
		return valid == '.' || valid == 'S' || valid == '*';
	}
	/*
	public boolean boardSquare(char valid) {
		return valid == '.' || valid == 'S' || valid == '*';
	}*/
		
	public static int validBoard(char[][] board) {
	    if (board == null)
	        return -1; // board is null
	    if (board.length != 10 || board[0].length != 10)
	        return -2; // wrong size
	    for (char[] row : board) {
	        for (char valid : row) {
	             if (!boardSquare(valid))
	                 return -3; // invalid square
	            }
	        }
	        return 1; // valid board
	    }
	
	/*
	public boolean boardSquare(char valid) {
    	return valid == '.' || valid == 'S' || valid == '*';
	} // 1.1. Valid Board Method (Boolean)
	public int validBoard(char[][] board) {
    	if (board == null) {
        	return -1; // null board
    	}
    	if (board.length != 10 || board[0].length != 10) {
        	return -2; // wrong size
    	}
    	for (int row = 0; row < 10; row++) {
        	for (int column = 0; column < 10; column++) {
            	if (!boardSquare(board[row][column])) {
                	return -3; // invalid square
            	}
        	}
    	}
    	return 0; // valid board
	}*/
	

	public static int numberSunk(char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char square : row) {
                if (square == '*')
                    count++;
            }
        }
        return count;
    }

	/*
	public int numberSunk(char[][] board) {
    	int count = 0;
    	for (int row = 0; row < 10; row++) {
        	for (int column = 0; column < 10; column++) {
            	if (board[row][column] == '*') {
                	count++;
            	}
        	}
    	}
    	return count;
	}
	*/
	
	
	public static int getHit(int row, char column, char[][] board) {
        if (row < 0 || row >= 10)
            return -1; // invalid row number
        if (column < 'A' || column > 'J')
            return -2; // invalid column
        if (board[row][column - 'A'] == 'S')
            return 1; // hit
        if (board[row][column - 'A'] == '.')
            return 2; // miss
        if (board[row][column - 'A'] == '*')
            return 3; // repeated hit
        return -3; // unknown condition
    }
	
	/*
	public int getHit(int row, char column, char[][] board) {
    	if (row < 1 || row > 10) {
        	return -1; // invalid row
    	}
    	if (column < 'A' || column > 'J') {
        	return -2; // invalid column
    	}
    	char valid = board[row - 1][column - 'A'];
    	if (valid == 'S') {
        	return 1; // hit
    	} else if (valid == '.') {
        	return 2; // miss
    	} else {
        	return 3; // repeated hit
    	}
	}*/
	
	public static int countShip(char[][] board, String shipType, String damageType) {
        int count = 0;
        char shipChar = getShipChar(shipType);
        if (shipChar == '\0')
            return -1; // invalid ship type
        for (char[] row : board) {
            for (char square : row) {
                if (square == shipChar || (damageType.equals("damaged") && square == '*')) {
                    count++;
                } else if (damageType.equals("sunk") && square == '*') {
                    return -3; // error: ship cannot be sunk if not present
                }
            }
        }
        return count;
    }
	// Helper method to get ship character based on ID or class
	private static char getShipChar(String shipType) {
        switch (shipType) {
            case "Carrier":
            case "1":
                return '1';
            case "Battleship":
            case "2":
                return '2';
            case "Cruiser":
            case "3":
                return '3';
            case "Destroyer":
            case "4":
                return '4';
            default:
                return '\0'; // Invalid ship type
        }
    }

	/*
	public int countShip(char[][] board, String shipType, String damageType) {
    	int count = 0;
    	for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 10; j++) {
            	if (board[i][j] == 'S' || board[i][j] == '*') {
                	count++;
            	}
        	}
    	}
    	// Add logic to check shipType and damageType
    	return count;
	}*/
	
	public static double[] calculateDamage(char[][] board) {
        double[] damageReport = new double[4];
        int[] shipCount = new int[4];
        // Initialises damage report and ship counts
        for (int i = 0; i < 4; i++) {
            damageReport[i] = -1.0; // Error value for ships not found
            shipCount[i] = 0;
        }
        // Counts ships and damage
        for (char[] row : board) {
            for (char square : row) {
                switch (square) {
                    case 'S':
                        shipCount[0]++;
                        break;
                    case '*':
                        shipCount[1]++;
                        break;
                    case '1':
                        shipCount[2]++;
                        break;
                    case '2':
                        shipCount[3]++;
                        break;
                }
            }
        }
        // Calculates damage percentages
        for (int i = 0; i < 4; i++) {
            if (shipCount[i] > 0) {
                damageReport[i] = (double) shipCount[i] / (double) (i + 1);
            }
        }
        return damageReport;
    }

	/*
	public int[] damage(char[][] board) {
    	int[] damageReport = new int[4];
    	// Add logic to calculate damage for each ship type
    	return damageReport;
	}*/
}