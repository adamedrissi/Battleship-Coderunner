public class Count_Ship {	// ignore
	
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
	
}	// ignore
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