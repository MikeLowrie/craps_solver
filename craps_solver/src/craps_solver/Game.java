package craps_solver;

import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		int bankroll = 100;
		int tablemin = 10;
		double odds = 3.45;
		ArrayList<Bet> allbets = Bet.createBets(odds, tablemin);
		ArrayList<Bet> currentbets = new ArrayList<Bet>();
	}

}
