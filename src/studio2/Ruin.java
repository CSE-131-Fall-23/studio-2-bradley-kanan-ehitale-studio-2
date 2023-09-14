package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the start amount: ");
		int startAmount = in.nextInt();
		int amount= startAmount;
		System.out.println("Enter the win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter the win limit: ");
		int winLimit = in.nextInt();
		int totalSimulations = 500;
		double loss= 0.0;

		double gameValue = 0;
		double alpha = 0.0;
		
		double expectedRuin = 0.0;
		if(winChance ==0.5 ) {
			expectedRuin = 1- ((double) startAmount/winLimit);
		}else {
			alpha = (1- winChance)/winChance;
			expectedRuin =(Math.pow(alpha,startAmount) - Math.pow(alpha,winLimit))/ (1-Math.pow(alpha, winLimit));
		}

		for(int i=0; i<= totalSimulations; i++) {
			int numOfGames = 0;
			amount = startAmount;
			
			while (amount != 0 && amount != winLimit) {
				gameValue = Math.random();
				if (gameValue < winChance) 
				{
					amount++;
				} else {
					amount--;
				}
			numOfGames++;
			
			}
			if (amount == winLimit) 
			{
				System.out.println("Simulutation " + i + ": " + numOfGames + " WIN");
			} else if(amount == 0 ){
				System.out.println("Simulutation " + i + ": " + numOfGames + " LOSE");
				loss++;
			}
	
		}
		System.out.println("Losses: " + loss + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + (loss/totalSimulations) + " Expected Ruin Rate: "+ expectedRuin);
	}

}
