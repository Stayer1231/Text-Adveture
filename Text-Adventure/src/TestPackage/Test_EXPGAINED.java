package TestPackage;

import java.util.Scanner;

import Entity.Player;
import Others.GameFunction;

public class Test_EXPGAINED {
	public static void main(String[] args) {
		Player player = new Player();
		int choice;
		Scanner sc = new Scanner(System.in);
		
		GameFunction.expGained = player.getExpGained();
		do {
			System.out.print("Enter: " );
			choice = sc.nextInt();
			System.out.println("You get " + GameFunction.expGained + " ex");
			System.out.println("Total xp: " + player.getTotalExp());
		} while (choice < 3);
		
	}
	
}
