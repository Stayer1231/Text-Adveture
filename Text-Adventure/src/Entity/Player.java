package Entity;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import Others.Misc;

public class Player {
	
	String input;
	boolean cont = true;
	Scanner sc = new Scanner(System.in);
	
	//Min and max for attributes
	int minExp = 10, maxExp = 20;
	int minAT = 10, maxAT = 15;
	int minDF = 8, maxDF = 12;
		
	//Character attributes
	private String playerName;
	private int currentHP;
	private int playerHP = 100;
	private int playerAT;
	private int playerDF;
	private int totalExp;
	private int expGained;
	private int playerLevel = 1;
	
	//Player level
	private int levelRequired = 50;
	private int levelUpLimit = 40;
	private int levelInc = 10; //Level up need + 40, 50, 60, 70, n + 10;
	
	//Update player attributes
	private int hpUpdate = 10;
	private int hpUpdateIncrease = 3;
	
	private int dmgUpdate = 5;
	private int defendUpdate = 5;
	

	//Constructor

	public Player() {
		
	}

	public Player(String playerName, int currentHP, int playerHP, int playerAT, 
		int playerDF, int totalExp, int expGained) {
		super();
		this.playerName = playerName;
		this.currentHP = currentHP;
		this.playerHP = playerHP;
		this.playerAT = playerAT;
		this.playerDF = playerDF;
		this.totalExp = totalExp;
		this.expGained = expGained;
	}
		
	
	//Attributes
	//----------Attack----------
	
	public void setPlayerAT() {
		playerAT = ThreadLocalRandom.current().nextInt(minAT, maxAT + 1);
	}
	
	public int getPlayerAT() {
		return playerAT;
	}
	
	public void updateAT() {
		if (totalExp >= levelUpLimit) {
			minAT += dmgUpdate;
			maxAT += dmgUpdate;
		}
	}
	
	
	//----------Name----------
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	//----------HP----------
	
	public void updateHP() {
		if (totalExp >= levelUpLimit)
		playerHP += hpUpdate;
		hpUpdate += hpUpdateIncrease;
	}
	
	public void setPCHP() {
		currentHP = playerHP;
	}
	
	public int getPCHP() {
		return currentHP;
	}
	
	//----------Defend----------
	
	public void updateDF() {
		if (totalExp >= levelUpLimit) {
			minDF += defendUpdate;
			maxDF += defendUpdate;
		}
		
	}
	
	public int getPlayerDF() {
		return playerDF;
	}
	
	public void setPlayerDF() {
		playerDF = ThreadLocalRandom.current().nextInt(minDF, maxDF + 1);
	}
	
	//----------Level----------
	
	public void setPlayerLevel() {
		if (totalExp >= levelUpLimit) {
			updateHP();
			updateAT();
			updateDF();
			if (playerLevel <= 1) {
				levelUpLimit += levelRequired;
				playerLevel ++;
			} else {
				levelRequired += levelInc;
				levelUpLimit += levelRequired;
				playerLevel ++;
			}
		}	
			
		if (playerLevel > 10) {
			playerLevel = 10;
		}
		
	}
	
	public int getPlayerLevel() {
		return playerLevel;
	}
	
	
	//----------Exp----------
	
	public void setExpGained() {
		expGained = ThreadLocalRandom.current().nextInt(minExp, maxExp + 1);
	}

	public int getExpGained() {
		return expGained;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	
	public int getTotalExp() {
		return totalExp;
	}
	
	public int getLevelUpLimit() {
		return levelUpLimit;
	}
	
	
	//--------OTHERS--------
	
	//Player status
	public void playerStatus() {
		getTotalExp();
		System.out.println("===Player status===");
		System.out.println("player name: " + playerName);
		System.out.println("player hp: " + playerHP);
		System.out.println("player attack: " + minAT + " - " + maxAT);
		System.out.println("player defend: " + minDF + " - " + maxDF);
		System.out.println("player exp: " + totalExp);
		System.out.println("< need " + levelUpLimit + " exp to level up >");
		System.out.println("player level: " + playerLevel);		
	}
		
	//Get player name and start the game
	public void startGame() {
		boolean cont = true;
		do {
			System.out.print("Enter your name: ");
			setPlayerName(sc.nextLine());
			Misc.printSeperator(30);
			System.out.println("Your name is: " + getPlayerName());
			System.out.print("Confirm?(y/n): ");
			//-----------------------------------
			do {
				try {
					input = sc.nextLine();
					cont = false;
					if(input.isEmpty() || (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"))) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("Empty or wrong");
					System.out.print("Confirm?(y/n): ");
				} 
			} while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));
			//-----------------------------------
			if(input.equalsIgnoreCase("y")) {
				cont = false;
				System.out.println();
			} else if(input.equalsIgnoreCase("n")) {
				Misc.clearConsole();
				cont = true;
			}
		} while(cont);
	}
	
}
