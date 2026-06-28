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
		System.out.println(boardSquare('S')); // 1.1 - VALID_BOARD_SQUARE
		System.out.println(validBoard(board)); // 1.2 - VALID_BOARD
		System.out.println(numberSunk(board)); // 1.3 - NUMBER_SUNK
		System.out.println(getHit(1,'D',board)); // 1.4 - HIT
		System.out.println(countShip(board,"Battleship","damaged")); // 1.5 - COUNT_SHIP
		System.out.println(java.util.Arrays.toString(calculateDamage(board))); // BONUS - BONUS_QUESTION 
	}
	
	// 1.1 - VALID_BOARD_SQUARE
	public static boolean boardSquare(char valid) {
		return valid == '.' || valid == 'S' || valid == '*';
	}
	
	// 1.2 - VALID_BOARD
	public static int validBoard(char[][] board) {
	    if (board == null) {
	        return -1; // Board is null
	    }
	    if (board.length != 10) {
	        return -2; // Wrong number of rows
	    }
	    for (int row = 0; row < 10; row++) {
	        if (board[row] == null || board[row].length != 10) {
	            return -2; // Wrong number of columns
	        }
	        for (int column = 0; column < 10; column++) {
	            if (!boardSquare(board[row][column])) {
	                return -3; // Invalid square
	            }
	        }
	    }
	    return 1; // Valid board
	}
	
	// 1.3 - NUMBER_SUNK
	public static int numberSunk(char[][] board) {
	    int count = 0;
	    for (int row = 0; row < 10; row++) {
	        int column = 0;
	        while (column < 10) {
	            if (board[row][column] == 'S' || board[row][column] == '*') {
	                int length = 0;
	                int hitSquares = 0;
	                while (column < 10 &&
	                      (board[row][column] == 'S' || board[row][column] == '*')) {
	                    if (board[row][column] == '*') {
	                        hitSquares++;
	                    }
	                    length++;
	                    column++;
	                }
	                if (hitSquares == length) {
	                    count++;
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    return count;
	}
	
	// 1.4 - HIT
	public static int getHit(int row, char column, char[][] board) {
	    if (row < 1 || row > 10) {
	        return -1; // Invalid row
	    }
	    if (column < 'A' || column > 'J') {
	        return -2; // Invalid column
	    }
	    char square = board[row - 1][column - 'A'];
	    if (square == 'S') {
	        return 1; // Hit
	    } else if (square == '.') {
	        return 2; // Miss
	    } else {
	        return 3; // Repeated hit
	    }
	}
	
	// 1.5 - COUNT_SHIP
	public static int countShip(char[][] board, String shipType, String damageType) {
	    int targetLength = getShipLength(shipType);
	    if (targetLength == -1) {
	        return -1; // Invalid ship type
	    }
	    if (!validDamageType(damageType)) {
	        return -2; // Invalid damage type
	    }
	    int count = 0;
	    for (int row = 0; row < 10; row++) {
	        int column = 0;
	        while (column < 10) {
	            if (board[row][column] == 'S' || board[row][column] == '*') {
	                int length = 0;
	                int hitSquares = 0;
	                while (column < 10 &&
	                      (board[row][column] == 'S' || board[row][column] == '*')) {
	                    if (board[row][column] == '*') {
	                        hitSquares++;
	                    }
	                    length++;
	                    column++;
	                }
	                if (length == targetLength) {
	                    String actualDamageType;
	                    if (hitSquares == 0) {
	                        actualDamageType = "undamaged";
	                    } else if (hitSquares == length) {
	                        actualDamageType = "sunk";
	                    } else {
	                        actualDamageType = "damaged";
	                    }
	                    if (damageType.equals("all") || damageType.equals(actualDamageType)) {
	                        count++;
	                    }
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    return count;
	}

	public static int getShipLength(String shipType) {
	    if (shipType == null) {
	        return -1;
	    }
	    if (shipType.equals("1") || shipType.equals("Carrier")) {
	        return 5;
	    } else if (shipType.equals("2") || shipType.equals("Battleship")) {
	        return 4;
	    } else if (shipType.equals("3") || shipType.equals("Cruiser")) {
	        return 3;
	    } else if (shipType.equals("4") || shipType.equals("Destroyer")) {
	        return 2;
	    } else {
	        return -1;
	    }
	}

	public static boolean validDamageType(String damageType) {
	    if (damageType == null) {
	        return false;
	    }
	    return damageType.equals("undamaged")
	        || damageType.equals("damaged")
	        || damageType.equals("sunk")
	        || damageType.equals("all");
	}
	
	// BONUS - BONUS_QUESTION
	public static double[] calculateDamage(char[][] board) {
	    double[] damageReport = new double[4];
	    double[] totalDamage = new double[4];
	    int[] shipCount = new int[4];
	    for (int i = 0; i < 4; i++) {
	        damageReport[i] = -1.0; // No ship of this type found
	        totalDamage[i] = 0.0;
	        shipCount[i] = 0;
	    }
	    if (validBoard(board) != 1) {
	        return damageReport; // Invalid board
	    }
	    for (int row = 0; row < 10; row++) {
	        int column = 0;
	        while (column < 10) {
	            if (board[row][column] == 'S' || board[row][column] == '*') {
	                int length = 0;
	                int hitSquares = 0;
	                while (column < 10 &&
	                      (board[row][column] == 'S' || board[row][column] == '*')) {
	                    if (board[row][column] == '*') {
	                        hitSquares++;
	                    }
	                    length++;
	                    column++;
	                }
	                int index = getShipIndex(length);
	                if (index != -1) {
	                    double damagePercent = ((double) hitSquares / length) * 100.0;
	                    totalDamage[index] = totalDamage[index] + damagePercent;
	                    shipCount[index]++;
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    for (int i = 0; i < 4; i++) {
	        if (shipCount[i] > 0) {
	            damageReport[i] = totalDamage[i] / shipCount[i];
	        }
	    }
	    return damageReport;
	}

	public static int getShipIndex(int length) {
	    if (length == 5) {
	        return 0; // Carrier
	    } else if (length == 4) {
	        return 1; // Battleship
	    } else if (length == 3) {
	        return 2; // Cruiser
	    } else if (length == 2) {
	        return 3; // Destroyer
	    } else {
	        return -1;
	    }
	}

}