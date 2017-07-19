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
	private boolean canplace;

	/**
	 * Default constructor. Used to eliminate compilation errors.
	 */
	public Bet() {
		this.investment = 0;
		this.name = "NULL";
		this.payout = new int[6][6];
		this.canplace = false;
	}

	/**
	 * Expected constructor. Builds a bet with specific pay out, investment, and name.
	 * @param investment Money currently invested in this bet.
	 * @param payout Conditions for wins and losses.
	 * @param name Name of bet.
	 */
	public Bet(int investment, int[][] payout, String name, boolean canplace) {
		this.investment = investment;
		this.payout = payout;
		this.name = name;
		this.canplace = canplace;
	}


	/**
	 * Creates a list of all bets a player can make in craps.
	 * @param odds Table odds. If 3-4-5 odds, value is 3.45.
	 * @param tableminimum Minimum bet available to be made on the table.
	 * @param propminimum Minimum bet for a propositional bet 
	 * @return List with every bet available
	 */
	public static ArrayList<Bet> createBets(double odds, int tableminimum, int propminimum) {
		ArrayList<Bet> bets = new ArrayList<Bet>();
		int betinvestment;
		String betname;
		int[][] betpayout;
		boolean betcanplace;
		// https://en.wikipedia.org/wiki/Craps#Bet_odds_and_summary
		// Using above link for checking that every bet has been entered
		
		
		// Pass Line (Come Bar is handled the same)
		betname = "PassLine";
		betinvestment = tableminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{-1, -1,  0,  0,  0,  1},
				{-1,  0,  0,  0,  1,  0},
				{ 0,  0,  0,  1,  0,  0},
				{ 0,  0,  1,  0,  0,  0},
				{ 0,  1,  0,  0,  0,  1},
				{ 1,  0,  0,  0,  1, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Pass Line (Don't Come Bar is handled the same)
		betname = "DontPassLine";
		betinvestment = tableminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{ 1,  1,  0,  0,  0, -1},
				{ 1,  0,  0,  0, -1,  0},
				{ 0,  0,  0, -1,  0,  0},
				{ 0,  0, -1,  0,  0,  0},
				{ 0, -1,  0,  0,  0, -1},
				{-1,  0,  0,  0, -1,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 4
		betname = "Come4";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  1,  0,  0, -1},
				{ 0,  1,  0,  0, -1,  0},
				{ 1,  0,  0, -1,  0,  0},
				{ 0,  0, -1,  0,  0,  0},
				{ 0, -1,  0,  0,  0,  0},
				{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 5
		betname = "Come5";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  1,  0, -1},
				{ 0,  0,  1,  0, -1,  0},
				{ 0,  1,  0, -1,  0,  0},
				{ 1,  0, -1,  0,  0,  0},
				{ 0, -1,  0,  0,  0,  0},
				{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 6
		betname = "Come6";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  1, -1},
				{ 0,  0,  0,  1, -1,  0},
				{ 0,  0,  1, -1,  0,  0},
				{ 0,  1, -1,  0,  0,  0},
				{ 1, -1,  0,  0,  0,  0},
				{-1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 8
		betname = "Come8";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0, -1},
				{ 0,  0,  0,  0, -1,  1},
				{ 0,  0,  0, -1,  1,  0},
				{ 0,  0, -1,  1,  0,  0},
				{ 0, -1,  1,  0,  0,  0},
				{-1,  1,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 9
		betname = "Come9";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0, -1},
				{ 0,  0,  0,  0, -1,  0},
				{ 0,  0,  0, -1,  0,  1},
				{ 0,  0, -1,  0,  1,  0},
				{ 0, -1,  0,  1,  0,  0},
				{-1,  0,  1,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Come 10
		betname = "Come10";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0, -1},
				{ 0,  0,  0,  0, -1,  0},
				{ 0,  0,  0, -1,  0,  0},
				{ 0,  0, -1,  0,  0,  1},
				{ 0, -1,  0,  0,  1,  0},
				{-1,  0,  0,  1,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 4
		betname = "DontCome4";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0, -1,  0,  0,  1},
				{ 0, -1,  0,  0,  1,  0},
				{-1,  0,  0,  1,  0,  0},
				{ 0,  0,  1,  0,  0,  0},
				{ 0,  1,  0,  0,  0,  0},
				{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 5
		betname = "DontCome5";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0, -1,  0,  1},
				{ 0,  0, -1,  0,  1,  0},
				{ 0, -1,  0,  1,  0,  0},
				{-1,  0,  1,  0,  0,  0},
				{ 0,  1,  0,  0,  0,  0},
				{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 6
		betname = "DontCome6";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0, -1,  1},
				{ 0,  0,  0, -1,  1,  0},
				{ 0,  0, -1,  1,  0,  0},
				{ 0, -1,  1,  0,  0,  0},
				{-1,  1,  0,  0,  0,  0},
				{ 1,  0,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 8
		betname = "DontCome8";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0,  1},
				{ 0,  0,  0,  0,  1, -1},
				{ 0,  0,  0,  1, -1,  0},
				{ 0,  0,  1, -1,  0,  0},
				{ 0,  1, -1,  0,  0,  0},
				{ 1, -1,  0,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 9
		betname = "DontCome9";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0,  1},
				{ 0,  0,  0,  0,  1,  0},
				{ 0,  0,  0,  1,  0, -1},
				{ 0,  0,  1,  0, -1,  0},
				{ 0,  1,  0, -1,  0,  0},
				{ 1,  0, -1,  0,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));

		// Don't Come 10
		betname = "DontCome10";
		betinvestment = tableminimum;
		betcanplace = false;
		betpayout = new int[][] {
				{ 0,  0,  0,  0,  0,  1},
				{ 0,  0,  0,  0,  1,  0},
				{ 0,  0,  0,  1,  0,  0},
				{ 0,  0,  1,  0,  0, -1},
				{ 0,  1,  0,  0, -1,  0},
				{ 1,  0,  0, -1,  0,  0},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Come 4 Odds
		
		// Come 5 Odds

		// Come 6 Odds

		// Come 8 Odds

		// Come 9 Odds

		// Come 10 Odds

		// Don't Come 4 Odds

		// Don't Come 5 Odds

		// Don't Come 6 Odds

		// Don't Come 8 Odds

		// Don't Come 9 Odds

		// Don't Come 10 Odds
		
		// Two Hop
		betname = "Hop2";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{30, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Three Hop
		betname = "Hop3";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{-1, 15, -1, -1, -1, -1},
				{15, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Yo Hop
		betname = "Hop11";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, 15},
				{-1, -1, -1, -1, 15, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Boxcars Hop
		betname = "Hop12";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, 30},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Hi-Lo
		betname = "HiLo";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{15, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, 15},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Craps
		betname = "Craps";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{ 7,  7, -1, -1, -1, -1},
				{ 7, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1,  7},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// C & E
		betname = "CnE";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{ 3,  3, -1, -1, -1, -1},
				{ 3, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1,  7},
				{-1, -1, -1, -1,  7,  3},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Any Seven
		betname = "Seven";
		betinvestment = propminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{-1, -1, -1, -1, -1,  4},
				{-1, -1, -1, -1,  4, -1},
				{-1, -1, -1,  4, -1, -1},
				{-1, -1,  4, -1, -1, -1},
				{-1,  4, -1, -1, -1, -1},
				{ 4, -1, -1, -1, -1, -1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Field
		// @TODO: Implement table variations on field payout
		betname = "Field";
		betinvestment = tableminimum;
		betcanplace = true;
		betpayout = new int[][] {
				{ 1,  1,  1, -1, -1, -1},
				{ 1,  1, -1, -1, -1, -1},
				{ 1, -1, -1, -1, -1,  1},
				{-1, -1, -1, -1,  1,  1},
				{-1, -1, -1,  1,  1,  1},
				{-1, -1,  1,  1,  1,  1},
		};
		bets.add(new Bet(betinvestment, betpayout, betname, betcanplace));
		
		// Horn
		// @TODO: Change betpayout to be a double[][] instead of int[][]
		
		// Whirl or World
		
		// Hard 4
		
		// Hard 6
		
		// Hard 8
		
		// Hard 10
		
		// Big 6 and Big 8 are garbage, and are ignored for this program.
		
		// Place 4
		
		// Place 5
		
		// Place 6
		
		// Place 8
		
		// Place 9
		
		// Place 10
		
		// Buy 4
		
		// Buy 5
		
		// Buy 6
		
		// Buy 8
		
		// Buy 9
		
		// Buy 10
		
		// Lay 4
		
		// Lay 5
		
		// Lay 6
		
		// Lay 8
		
		// Lay 9
		
		// Lay 10

		return bets;
	}

	/**
	 * Method that looks through the current bets on the table, then looks for the best bets that can be placed
	 * that the player can afford to place.
	 * @param currentbets Current bets on the table placed by player
	 * @param bestbets Returned parameter that holds a collection of bets determined to be "best"
	 * @param placeablebets Collection of bets the player can place right now
	 * @param bankroll Amount of money available for player to use
	 * @return Collection of bets which have the highest chance of achieving a win condition
	 */
	public static ArrayList<Bet> findBestBet(ArrayList<Bet> currentbets, ArrayList<Bet> bestbets, ArrayList<Bet> placeablebets, int bankroll) {
		// @TODO: Integrate bank roll into algorithm
		for(int i = 0; i < placeablebets.size(); i++) {
			Bet b = placeablebets.get(i);
			if(b.getInvestment() <= bankroll) {
				// @TODO: Make ArrayList<Bet> a new internal class for safer cloning
				ArrayList<Bet> potentialbets = (ArrayList<Bet>) currentbets.clone();
				potentialbets.add(b);
				double currentcomparison = Bet.evaluateBets(currentbets);
				double potentialcomparison = Bet.evaluateBets(potentialbets);
				double bestcomparison = Bet.evaluateBets(bestbets); 
				
				if(currentcomparison < potentialcomparison) {
					if(bestcomparison < potentialcomparison)
						bestbets = (ArrayList<Bet>) potentialbets.clone();
				} else {				
					if(bestcomparison < currentcomparison)
						bestbets = (ArrayList<Bet>) currentbets.clone();
				}
				potentialbets.remove(potentialbets.size() - 1);
			}
		}
		return bestbets;
	}

	/**
	 * Calculates the win-loss differential of the combination of bets provided.
	 * If the number is higher than zero, the player is expected to win.
	 * If the number is lower than zero, the player is expected to lose.
	 * @param currentbets
	 * @return
	 */
	public static double evaluateBets(ArrayList<Bet> currentbets) {
		double differential = -99999.0;
		if(currentbets.size() > 0)
		{
			differential = 0.0;
			for(Bet b : currentbets) {
				int[][] payout = b.getPayout();
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 6; j++) {
						differential += payout[i][j];
					}
				}
			}
			differential /= 36;
		}
		return differential;
	}

	/**
	 * Places the listed bets into a readable String, made for system output.
	 * @param bets Combination of bets currently active
	 * @return String representing combination of bets
	 */
	public static String printBets(ArrayList<Bet> bets) {
		String output = "";
		if(bets.size() > 0)
		{
			for(Bet b : bets)
				output = output + ", " + b.getName();
			output = output.substring(2);
		}
		return output;
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

	/**
	 * Determines if the user can place this bet themselves, or is the result of another bet.
	 * Point bets always return false.
	 * @return Boolean representing if this bet can place
	 */
	public boolean getCanPlace() {
		return canplace;
	}
}
