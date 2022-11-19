package Others;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Entity.Enemy;
import Entity.Inventory;
import Entity.Player;
import Event.Combat;
import Event.Plot;

public class GameFunction {
	//Attributes
	public static int playerCurrentHP;
	public static int enemyHP;
	public static int playerAttack;
	public static int enemyAttack;
	public static int playerDefend;
	public static int expGained;
	public static int totalExp = 0;
	public static int playerChoice;
	
	//Object from classes
	Player player = new Player();
	Enemy enemy = new Enemy(player);
	
	Combat attribute = new Combat(player, enemy);
	Combat combat = new Combat(player, enemy);
	Function function = new Function();
	
	
	//EVENT STARTS HERE
	public void gameOpening() {
		System.out.println("Welcome to my small game...");
		player.startGame(); //Ask player to enter game and continue
		Misc.printSeperator(80);
		System.out.println("You are a knight on your path to defeat 3 demons to "
				+ "save the world from danger.");
		Misc.printSeperator(80);
		System.out.println();
		System.out.print("You walk along the forest and finally, "
				+ "you take a rest at the village.");
	}
	
	
	//---------------Events in the Song---------------
	
	public void cathiaForest() {
		System.out.println();
		Misc.printSeperator(30);
		Plot.cathiaForest();
	}
	
	public void talkToElena() {
		int phase = 0;
		if (player.getPlayerLevel() < 3) {
			phase = 1;
		} else if (player.getPlayerLevel() <= 6) {
			phase = 2;
		}
		
		//Phase
		System.out.println();
		if (phase == 1) {
			System.out.println("Elena: Hello stranger, don't mind me. I miss the old one - the village. "
					+ "It was beautiful till monsters invaded. I hope you can save the village. "
					+ "By the way, you seem hungry, here take this orange!");
			System.out.println();
			Inventory.addItem("breadfruit");
		} else if (phase == 2) {
			System.out.print("Elena: Seems like you are getting stronger, I hope you will be "
					+ "the one who can defeat the demons. WE BELIEVE IN YOU 😘");
		}
	}	
	
	public void talkToKaiiso() {
		int phase = 0;
		if (player.getPlayerLevel() < 3) {
			phase = 1;
		} else if (player.getPlayerLevel() <= 6) {
			phase = 2;
		}
		
		//Phase
		System.out.println();
		if (phase == 1) {
			System.out.println("Kaiiso: Welcome to the village, I bet you are starving. "
					+ "I used to be the best butcher in the village, but I gave up after an accident. Now I am a vegetarian, "
					+ "I'm buiding the house, I need wood. Can you "
					+ "get me some? I will give you my breadfruit.");
			System.out.println();
			Inventory.checkForWood();
			if(Inventory.haveWood == true) {
				Inventory.removeItem("wood");
				System.out.println();
				Inventory.addItem("breadfruit");			
			} else {
				System.out.print("< You have no woods >");
			}
		}
		
		if (phase == 2) {
			System.out.println("Kaiiso: I have finished building my house thanks to your huge support. "
					+ "I will give you this small potion.");
			System.out.println();
			Inventory.addItem("small potion");
		}
	}
	
	public void talkToOmorph() {
		int phase = 0;
		if (player.getPlayerLevel() < 3) {
			phase = 1;
		} else if (player.getPlayerLevel() <= 6) {
			phase = 2;
		}
		
		//Phase 
		System.out.println();
		if (phase == 1) {
		System.out.print("Omorph: Hello Mr." + player.getPlayerName() + 
				", My name is Omorph. I'm the major of this village. It was peacful back then. I hope"
				+ " one day, it will be like it in the past. Hope you can defeat the monsters.");
		
		} else if (phase == 2) {
			System.out.print("Omorph: I believe you are the rigth person that can save us from the demon. Here take this map, "
					+ "it will lead you to another village which you can find a blacksmith.");
			Inventory.addItem("map");
		}
	}
	
	
	//---------------Events in the Cathia---------------
	
	public void breadfruitChance() {
		System.out.println();
		function.setItemChance(function.getItemChance());
		if (function.getItemChance() == 1) {
			Inventory.addItem("breadfruit");
		}
	}
	
	public void woodChance() {
		System.out.println();
		function.setItemChance(function.getItemChance());
		if (function.getItemChance() == 1) {
			Inventory.addItem("wood");
		}
	}
	
	
	//---------------Events in the Thanisma---------------
	
	public void thanismaRiver() {
		do {
			int chance = 0;
			chance = setPomegranateChance(getPomegranateChance());
			//Pomegranate: True
			if (chance == 3) {
				do {
					pomegranateAppear();
					playerChoice = GameFunction.getPlayerChoice(0, 8);
					switch (playerChoice) {
					case 0:
						showPlayerInfo();
						break;
						
					case 1:
						pathInThanisma();
						break;
						
					case 2:
						pathInThanisma();
						break;
						
					case 3:
						pathInThanisma();
						break;
						
					case 4:
						pathInThanisma();
						break;
						
					case 5:
						pomegranateChance();
						break;
						
					case 6:
						showInventory();
						break;
						
					case 7:
						removeItem();
						break;
						
					}
				} while (playerChoice < 1);
				
			} else {
				do {
					pomegranateNotAppear();
					playerChoice = GameFunction.getPlayerChoice(0, 7);
					switch (playerChoice) {
					case 0:
						showPlayerInfo();
						break;
					
					case 1:
						pathInThanisma();
						break;
						
					case 2:
						pathInThanisma();
						break;
						
					case 3:
						pathInThanisma();
						break;
						
					case 4:
						pathInThanisma();
						break;
						
					case 5:
						showInventory();
						break;
						
					case 6:
						removeItem();
						break;
					}
					
				} while (playerChoice < 1);
			}
			
		} while (playerChoice != 7 && playerChoice != 8);
	}
	
	public void pathInThanisma() {
		System.out.println();
		attribute.combatAttribute();
		if (function.monsterChance() == 1) {
			enemy.setEnemyName();
			if (enemy.getEnemyName() == "Harpy") {
				System.out.println("A Harpy approached");
				combat.harpyFight();
				
			} else if (enemy.getEnemyName() == "Minotaur") {
				System.out.println("A Minotaur approached");
				combat.minotaurFight();
				
			} else if (enemy.getEnemyName() == "Siren") {
				System.out.println("A Siren approached");
				combat.sirenFight();
				
			} else if (enemy.getEnemyName() == "Lamia") {
				System.out.println("A Lamia approached");
				combat.lamiaFight();
			}
			
		}
	}
	
	public void pomegranateChance() {
		System.out.println();
		function.setItemChance(function.getItemChance());
		if (function.getItemChance() == 1) {
			Inventory.addItem("pomegranate");
		}
	}
	
	public void pomegranateAppear() {
		System.out.println();
		Misc.printSeperator(30);
		Plot.pomegranateAppear();
	} 
	
	public void pomegranateNotAppear() {
		System.out.println();
		Misc.printSeperator(30);
		Plot.pomegranateNotAppear();
	}
	
	
	//-----------------Function method------------------
	
	public void showInventory() {
		System.out.println();
		Inventory.viewInventory();
	}
	
	public void removeItem() {
		do {
			System.out.println();
			Misc.printSeperator(30);
			Misc.removeItemMenu();
			playerChoice = getPlayerChoice(0, 8);
			switch(playerChoice) {
			case 0:
				System.out.println();
				player.playerStatus();
				break;
					
			case 1:
				System.out.println();
				Inventory.removeItem("normal potion");
				break;
					
			case 2:
				System.out.println();
				Inventory.removeItem("holy potion");
				break;
					
			case 3:
				System.out.println();
				Inventory.removeItem("breadfruit");
				break;
					
			case 4:
				System.out.println();
				Inventory.removeItem("pomegranate");
				break;
					
			case 5:
				System.out.println();
				Inventory.removeItem("elightania");
				break;
					
			case 6:
				System.out.println();
				Inventory.removeItem("wood");
				break;
			case 7:
				System.out.println();
				Inventory.viewInventory();
			}
		} while(playerChoice != 8);
	}
	
	public void showPlayerInfo() {
		System.out.println();
		player.playerStatus();
	}
	
	public static int getPlayerChoice(int first, int last) {
		int choice = 0;
		boolean run = true;
		Scanner input = new Scanner(System.in);
		do {
			try {
				choice = Integer.parseInt(input.nextLine());
				run = false;
				if(choice < first || choice > last) {
					throw new UnknownError();
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e);
				System.out.print("Enter again: ");
			} catch (UnknownError e) {
				System.out.println();
				System.out.println("Please choose the following options!");
			}
		} while (run);
		
		return choice;
	}

	public void useItem() {
		do {
			System.out.println();
			Inventory.viewInventory();
			Misc.printSeperator(30);
			Misc.useItemMenu();
			playerChoice = getPlayerChoice(0, 6);
			switch(playerChoice) {
			case 0:
				System.out.println();
				player.playerStatus();
				break;
					
			case 1:
				System.out.println();
				Inventory.useItem("normal potion");
				break;
					
			case 2:
				System.out.println();
				Inventory.useItem("holy potion");
				break;
					
			case 3:
				System.out.println();
				Inventory.useItem("breadfruit");
				break;
					
			case 4:
				System.out.println();
				Inventory.useItem("pomegranate");
				break;
					
			case 5:
				System.out.println();
				Inventory.useItem("elightania");
				break;
					
			}
		} while(playerChoice != 6);
	}
	
	
	//-----------------MISC-----------------
	static int pomegranateChance;
	public static int getPomegranateChance() {
		return pomegranateChance;
	}

	public static int setPomegranateChance(int pomegranateChance) {
		int min = 0, max = 4;
		return pomegranateChance = ThreadLocalRandom.current().nextInt(min, max);
	}
}
