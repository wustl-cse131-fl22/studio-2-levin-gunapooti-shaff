package studio2;

import java.util.Scanner;

public class GamblersRuin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Start Amount (1 or 2): ");
		double startAmount = in.nextDouble();
		System.out.print("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.print("Win Limit: ");
		double winLimit = in.nextDouble();
		
		int numRounds = 0;
		int currentSim = 1;
		int numLosses = 0;
		
		System.out.print("Total Simulations: ");
		int totalSimulations = in.nextInt();
		int finalSimulations = totalSimulations;
		boolean win = true;
		double expectedRuin = 0;
		double alpha = (1-winChance)/(winChance);
		
		if (winChance == .5)
		{
			expectedRuin = 1-(startAmount/winLimit);
		}
		else 
		{
			expectedRuin = (Math.pow(alpha, startAmount)-(Math.pow(alpha, winLimit)));
			expectedRuin /= 1-Math.pow(alpha, winLimit);
		}
		
		double ruinRounded = expectedRuin*100;
		ruinRounded = Math.round(ruinRounded);
		ruinRounded /= 100;
		
		while(totalSimulations>0)
		{
			startAmount = 2;
			numRounds = 0;
			while (startAmount > 0 && startAmount < winLimit)
			{
				numRounds++;
				double rand = Math.random();
				if(rand<winChance)
				{
					startAmount++;
				}
				else
				{
					startAmount--;
				}
				if(startAmount==0)
				{
					System.out.println("Simulation " + currentSim + ": "+ numRounds + " LOSE");
					numLosses ++;
				}
				else if(startAmount==winLimit)
				{
					System.out.println("Simulation " + currentSim + ": " + numRounds + " WIN");
				}
			}
			totalSimulations--;
			currentSim++;
		}
		System.out.println("Losses: " + numLosses + " Simulations: " + finalSimulations);
		System.out.println("Ruin Rate from Simulation: " + ruinRounded + " Expected Ruin Rate: " + expectedRuin);
		
	}

}
