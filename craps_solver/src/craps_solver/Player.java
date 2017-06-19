package craps_solver;

import java.util.ArrayList;

public class Player {

	private ArrayList<Bet> currentbets;
	private ArrayList<Bet> allbets;
	private int bankroll;
	
	public Player(int bankroll, double odds, int tableminimum) {
		this.bankroll = bankroll;
		this.currentbets = new ArrayList<Bet>();
		this.allbets = Bet.createBets(odds, tableminimum);
	}
	
	/**
	 * Adds a bet to the player's control.
	 * @param b Bet to be added
	 * @return True if the player had money to place the bet, false otherwise.
	 */
	public boolean addBet(Bet b) {
		int investment = b.getInvestment();
		
		if(this.bankroll >= investment) {
			currentbets.add(b);
			bankroll -= investment;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pulls a bet from the table. This is done when a bet does not resolve in a win or loss,
	 * and the player no longer wants the bet on the table.
	 * @param b Bet to be pulled
	 * @return True if the bet was successfully pulled, false otherwise.
	 */
	public boolean pullBet(Bet b) {
		boolean removed = currentbets.remove(b);
		if(removed)
			bankroll += b.getInvestment();
		return removed;
	}
	
	/**
	 * Checks the bet for a win or loss condition, and pays out accordingly.
	 * @param b Bet to be checked
	 * @param firstdie Value of first die's roll
	 * @param seconddie Value of second die's roll
	 * @return True if the bet resulted in a win or loss, false otherwise.
	 */
	public boolean payBet(Bet b, int firstdie, int seconddie) {
		int payment = 0;
		if(b.getName().equals("PassLine") || b.getName().equals("DontPassLine")) {
			this.assignLinePoint(b, firstdie, seconddie);
		} else {
			payment = b.getPayout()[firstdie][seconddie];
		}
		if(payment != 0) {
			int bankrollchange = payment * b.getInvestment();
			bankroll += bankrollchange;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * When a line bet turns into a point, this method pulls the line bet and turns
	 * it into an appropriate Come or Don't Come bet.
	 * @param b Bet to be changed
	 * @param firstdie Value of first die
	 * @param seconddie Value of second die
	 */
	private void assignLinePoint(Bet b, int firstdie, int seconddie) {
		int roll = firstdie + seconddie;
		boolean comebet = b.getName().equals("PassLine");
		Bet newbet = new Bet();
		switch (roll) {
			case 4:
				if(comebet) {
					newbet = this.findBet("Come4");
				} else {
					newbet = this.findBet("DontCome4");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			case 5:
				if(comebet) {
					newbet = this.findBet("Come5");
				} else {
					newbet = this.findBet("DontCome5");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			case 6:
				if(comebet) {
					newbet = this.findBet("Come6");
				} else {
					newbet = this.findBet("DontCome6");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			case 8:
				if(comebet) {
					newbet = this.findBet("Come8");
				} else {
					newbet = this.findBet("DontCome8");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			case 9:
				if(comebet) {
					newbet = this.findBet("Come9");
				} else {
					newbet = this.findBet("DontCome9");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			case 10:
				if(comebet) {
					newbet = this.findBet("Come10");
				} else {
					newbet = this.findBet("DontCome10");
				}
				this.pullBet(b);
				this.addBet(newbet);
				break;
			default:
				System.err.println("Dice value of " + roll + " cannot be turned into a point.");
				break;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Bet findBet(String name) {
		Bet b = new Bet();
		for(Bet bet : allbets) {
			if(bet.getName().equals(name)) {
				b = bet;
				break;
			}
		}
		return b;
	}

	/**
	 * Gets the catalog of bets available in craps.
	 * @return List containing every bet available in craps
	 */
	public ArrayList<Bet> getFullBetList() {
		return allbets;
	}
}
