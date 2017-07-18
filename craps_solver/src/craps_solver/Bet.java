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
	 * @return List with every bet available
	 */
	public static ArrayList<Bet> createBets(double odds, int tableminimum) {
		ArrayList<Bet> bets = new ArrayList<Bet>();
		int betinvestment;
		String betname;
		int[][] betpayout;
		boolean betcanplace;

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


		return bets;
	}

	public static ArrayList<Bet> findBestBet(ArrayList<Bet> currentbets, ArrayList<Bet> bestbets, ArrayList<Bet> placeablebets, int bankroll, int index) {
		for(int i = index; i < placeablebets.size(); i++) {
			Bet b = placeablebets.get(i);
			if(b.getInvestment() <= bankroll) {
				// @TODO: Make ArrayList<Bet> a new internal class for safer cloning
				ArrayList<Bet> potentialbets = (ArrayList<Bet>) currentbets.clone();
				potentialbets.add(b);
				double currentcomparison = Bet.evaluateBets(currentbets);
				String currentbetstring = Bet.printBets(currentbets);
				double potentialcomparison = Bet.evaluateBets(potentialbets);
				String potentialbetstring = Bet.printBets(potentialbets);
				double bestcomparison = Bet.evaluateBets(bestbets);
				System.out.println("Comparing " + currentbetstring + "||AGAINST||" + potentialbetstring);
				System.out.println("    Differential of " + currentcomparison + " on first");
				System.out.println("    Differential of " + potentialcomparison + " on second");
				System.out.println("    Currently, best differential is " + bestcomparison);
				if(currentcomparison < potentialcomparison) {
					System.out.println("    Second chosen..." + (bestcomparison < potentialcomparison));
					if(bestcomparison < potentialcomparison)
						bestbets = potentialbets;
				} else {
					System.out.println("    First chosen..." + (bestcomparison < currentcomparison));
					if(bestcomparison < currentcomparison)
						bestbets = currentbets;
				}
				potentialbets.remove(potentialbets.size() - 1);
			}
		}

		/* testBetCombination(betcombo, new ArrayList<Bet>(), 0);
		 *
		 * public void testBetCombination(ArrayList<Bet> inbet, ArrayList<Bet> outbet, int index) {
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
		 */


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
