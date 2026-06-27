public class Bonus_Question {	// ignore
	
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
	
}	// ignore
/*
public int[] damage(char[][] board) {
    int[] damageReport = new int[4];
    // Add logic to calculate damage for each ship type
    return damageReport;
}*/