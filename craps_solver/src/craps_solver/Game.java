package craps_solver;

import java.util.ArrayList;

public class Game {
	Player p;
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		int bankroll = 100;
		int tablemin = 10;
		int propmin = 1;
		double odds = 3.45;
		
		p = new Player(bankroll, odds, tablemin, propmin);
		test();
	}
	
	/**
	 * Method for testing out code.
	 */
	public void test() {
	
		ArrayList<Bet> currentbets = new ArrayList<Bet>();
		ArrayList<Bet> bestbets = new ArrayList<Bet>();
		ArrayList<Bet> placeablebets = new ArrayList<Bet>();
		currentbets.add(p.findBet("Come5"));
		currentbets.add(p.findBet("Come8"));
		placeablebets.add(p.findBet("PassLine"));
		placeablebets.add(p.findBet("DontPassLine"));
		bestbets = Bet.findBestBet(currentbets, bestbets, placeablebets, 100);
		double differential = Bet.evaluateBets(bestbets);
		String betcombination = Bet.printBets(bestbets);
		System.out.println("Best combination is " + betcombination + " with differential of " + differential);
	}
	// @TODO: Check for possible odds bets depending on current come/DC bets
	
	public void testBetCombination(ArrayList<Bet> inbet, ArrayList<Bet> outbet, int index) {
	    for (int i = index; i < inbet.size(); i++)
	    {
	        outbet.add(inbet.get(i));
	        String betcombination = "";
	        for(Bet b : outbet) {
	        	betcombination = betcombination + ", " + b.getName();
	        }
	        double differential = Bet.evaluateBets(outbet);
	        System.out.println(differential + "..." + betcombination.substring(2));
	        testBetCombination(inbet, outbet, i + 1);
	        outbet.remove(outbet.size() - 1);
	    }
	}
}
