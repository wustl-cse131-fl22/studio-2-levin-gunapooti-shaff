package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int simulations = 500000;
		int finalSim = simulations;
		int howManyIn = 0;

		while(simulations>0)
		{
			double randX = Math.random();
			double randY = Math.random();
			
			
			double d = Math.sqrt(Math.pow(Math.abs(.5-randX), 2) + Math.pow(Math.abs(.5-randY), 2));
			if(d<=.5)
			{
				howManyIn++;
			}
			simulations--;
		}

		double percentageIn = (double) howManyIn/finalSim;
		double pi = percentageIn*4;
		
		System.out.println("Pi is " + pi);

	}

}
