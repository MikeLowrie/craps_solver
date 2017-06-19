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
		double odds = 3.45;
		
		p = new Player(bankroll, odds, tablemin);
		test();
	}
	
	/**
	 * Method for testing out code.
	 */
	public void test() {
		ArrayList<Bet> betcombo = new ArrayList<Bet>();
		betcombo.add(p.findBet("PassLine"));
		betcombo.add(p.findBet("DontCome4"));
		betcombo.add(p.findBet("Come6"));
		testBetCombination(betcombo, new ArrayList<Bet>(), 0);
	}
	
	public void testBetCombination(ArrayList<Bet> inbet, ArrayList<Bet> outbet, int index) {
	    for (int i = index; i < inbet.size(); i++)
	    {
	        outbet.add(inbet.get(i));
	        String betcombination = "";
	        for(Bet b : outbet) {
	        	betcombination = betcombination + ", " + b.getName();
	        }
	        System.out.println(betcombination.substring(2));
	        testBetCombination(inbet, outbet, i + 1);
	        outbet.remove(outbet.size() - 1);
	    }
	}
}
