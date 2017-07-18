package craps_solver;

import java.util.ArrayList;

public class Game {
	Player p;
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		System.out.println("Hello world!");
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
		/*
		ArrayList<Bet> betcombo = new ArrayList<Bet>();
		betcombo.add(p.findBet("PassLine"));
		betcombo.add(p.findBet("DontPassLine"));
		betcombo.add(p.findBet("Come4"));
		betcombo.add(p.findBet("Come5"));
		betcombo.add(p.findBet("Come6"));
		betcombo.add(p.findBet("Come8"));
		betcombo.add(p.findBet("Come9"));
		betcombo.add(p.findBet("Come10"));
		betcombo.add(p.findBet("DontCome4"));
		betcombo.add(p.findBet("DontCome5"));
		betcombo.add(p.findBet("DontCome6"));
		betcombo.add(p.findBet("DontCome8"));
		betcombo.add(p.findBet("DontCome9"));
		betcombo.add(p.findBet("DontCome10"));
		testBetCombination(betcombo, new ArrayList<Bet>(), 0); 
		*/
		
		ArrayList<Bet> currentbets = new ArrayList<Bet>();
		ArrayList<Bet> bestbets = new ArrayList<Bet>();
		ArrayList<Bet> placeablebets = new ArrayList<Bet>();
		currentbets.add(p.findBet("Come5"));
		currentbets.add(p.findBet("Come8"));
		placeablebets.add(p.findBet("PassLine"));
		placeablebets.add(p.findBet("DontPassLine"));
		bestbets = Bet.findBestBet(currentbets, bestbets, placeablebets, 100, 0);
		double differential = Bet.evaluateBets(bestbets);
		String betcombination = Bet.printBets(bestbets);
		System.out.println("Best combination is " + betcombination + " with differential of " + differential);
	}
	
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
