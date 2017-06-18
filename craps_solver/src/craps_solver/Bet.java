package craps_solver;

import java.util.ArrayList;

// @TODO: Finish writing createBets

/**
 * 
 * @author MikeLowrie
 *
 */
public class Bet {

	private int investment;
	private int[][] payout;
	private String name;

	/**
	 * Default constructor. Used to eliminate compilation errors.
	 */
	public Bet() {
		this.investment = 0;
		this.name = "NULL";
		this.payout = new int[6][6];
	}

	/**
	 * Expected constructor. Builds a bet with specific pay out, investment, and name.
	 * @param investment Money currently invested in this bet.
	 * @param payout Conditions for wins and losses.
	 * @param name Name of bet.
	 */
	public Bet(int investment, int[][] payout, String name) {
		this.investment = investment;
		this.payout = payout;
		this.name = name;
	}
	
	
	/**
	 * Creates a list of all bets a player can make in craps.
	 * @param odds Table odds. If 3-4-5 odds, value is 3.45.
	 * @param tableminimum Minimum bet available to be made on the table.
	 * @return List with every bet available
	 */
	public static ArrayList<Bet> createBets(double odds, int tableminimum) {
		ArrayList<Bet> bets = new ArrayList<Bet>();
		int betinvestment;
		String betname;
		int[][] betpayout;
		
		// Pass Line (Come Bar is handled the same)
		betname = "PassLine";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{-1, -1,  0,  0,  0,  1},
			{-1,  0,  0,  0,  1,  0},
			{ 0,  0,  0,  1,  0,  0},
			{ 0,  0,  1,  0,  0,  0},
			{ 0,  1,  0,  0,  0,  1},
			{ 1,  0,  0,  0,  1, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Pass Line (Don't Come Bar is handled the same)
		betname = "DontPassLine";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 1,  1,  0,  0,  0, -1},
			{ 1,  0,  0,  0, -1,  0},
			{ 0,  0,  0, -1,  0,  0},
			{ 0,  0, -1,  0,  0,  0},
			{ 0, -1,  0,  0,  0, -1},
			{-1,  0,  0,  0, -1,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 4
		betname = "Come4";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  1,  0,  0, -1},
			{ 0,  1,  0,  0, -1,  0},
			{ 1,  0,  0, -1,  0,  0},
			{ 0,  0, -1,  0,  0,  0},
			{ 0, -1,  0,  0,  0,  0},
			{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 5
		betname = "Come5";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  1,  0, -1},
			{ 0,  0,  1,  0, -1,  0},
			{ 0,  1,  0, -1,  0,  0},
			{ 1,  0, -1,  0,  0,  0},
			{ 0, -1,  0,  0,  0,  0},
			{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 6
		betname = "Come6";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  1, -1},
			{ 0,  0,  0,  1, -1,  0},
			{ 0,  0,  1, -1,  0,  0},
			{ 0,  1, -1,  0,  0,  0},
			{ 1, -1,  0,  0,  0,  0},
			{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 8
		betname = "Come8";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0, -1},
			{ 0,  0,  0,  0, -1,  1},
			{ 0,  0,  0, -1,  1,  0},
			{ 0,  0, -1,  1,  0,  0},
			{ 0, -1,  1,  0,  0,  0},
			{-1,  1,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 9
		betname = "Come9";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0, -1},
			{ 0,  0,  0,  0, -1,  0},
			{ 0,  0,  0, -1,  0,  1},
			{ 0,  0, -1,  0,  1,  0},
			{ 0, -1,  0,  1,  0,  0},
			{-1,  0,  1,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Come 10
		betname = "Come10";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0, -1},
			{ 0,  0,  0,  0, -1,  0},
			{ 0,  0,  0, -1,  0,  0},
			{ 0,  0, -1,  0,  0,  1},
			{ 0, -1,  0,  0,  1,  0},
			{-1,  0,  0,  1,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 4
		betname = "DontCome4";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0, -1,  0,  0,  1},
			{ 0, -1,  0,  0,  1,  0},
			{-1,  0,  0,  1,  0,  0},
			{ 0,  0,  1,  0,  0,  0},
			{ 0,  1,  0,  0,  0,  0},
			{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 5
		betname = "DontCome5";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0, -1,  0,  1},
			{ 0,  0, -1,  0,  1,  0},
			{ 0, -1,  0,  1,  0,  0},
			{-1,  0,  1,  0,  0,  0},
			{ 0,  1,  0,  0,  0,  0},
			{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 6
		betname = "DontCome6";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0, -1,  1},
			{ 0,  0,  0, -1,  1,  0},
			{ 0,  0, -1,  1,  0,  0},
			{ 0, -1,  1,  0,  0,  0},
			{-1,  1,  0,  0,  0,  0},
			{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 8
		betname = "DontCome8";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0,  1},
			{ 0,  0,  0,  0,  1, -1},
			{ 0,  0,  0,  1, -1,  0},
			{ 0,  0,  1, -1,  0,  0},
			{ 0,  1, -1,  0,  0,  0},
			{ 1, -1,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 9
		betname = "DontCome9";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0,  1},
			{ 0,  0,  0,  0,  1,  0},
			{ 0,  0,  0,  1,  0, -1},
			{ 0,  0,  1,  0, -1,  0},
			{ 0,  1,  0, -1,  0,  0},
			{ 1,  0, -1,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		// Don't Come 10
		betname = "DontCome10";
		betinvestment = tableminimum;
		betpayout = new int[][] {
			{ 0,  0,  0,  0,  0,  1},
			{ 0,  0,  0,  0,  1,  0},
			{ 0,  0,  0,  1,  0,  0},
			{ 0,  0,  1,  0,  0, -1},
			{ 0,  1,  0,  0, -1,  0},
			{ 1,  0,  0, -1,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname));
		
		
		return bets;
	}
	
	public static ArrayList<Bet> findBestBet(ArrayList<Bet> currentbets, int bankroll) {
		ArrayList<Bet> bestbets = new ArrayList<Bet>();
		
		return bestbets;
	}
	
	/**
	 * Gets the investment on this bet.
	 * @return investment value
	 */
	public int getInvestment() {
		return this.investment;
	}
	
	/**
	 * Gets the pay out matrix.
	 * @return 2-d array of pay out
	 */
	public int[][] getPayout() {
		return this.payout;
	}
	
	/**
	 * Gets the name of this bet.
	 * @return Name of bet
	 */
	public String getName() {
		return this.name;
	}
}
