package Event;

import java.util.Scanner;
import javax.security.auth.login.FailedLoginException;

import Entity.Enemy;
import Entity.Inventory;
import Entity.Player;
import Others.Function;
import Others.GameFunction;
import Others.Misc;

public class Combat {
	
	static boolean run;
	int choice;
	Scanner sc = new Scanner(System.in);
	Function function = new Function();
	Player player;
	Enemy enemy;
	GameFunction inventory;
	

	//Constructor
	public Combat(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}

	public Combat() {
		
	}
	
	
	//----------Combat attribures----------
	public void combatAttribute() {
		
		//Player
		player.setPCHP();
		player.setPlayerDF();
		
		//Enemy
		enemy.setEHP();
		enemy.updateEnemyAttributes();
		enemy.setEnemyAT(); //Fixed damage
		
		GameFunction.playerCurrentHP = player.getPCHP();
		GameFunction.playerDefend = player.getPlayerDF();
		GameFunction.enemyAttack = enemy.getEnemyAT();
		GameFunction.enemyHP = enemy.getEHP(); 
	}
	
	
	//----------Encounter Harpy----------
	public void harpyFight() {
		inventory = new GameFunction();
		run = true;
		do {
			System.out.println();
			System.out.println("Player HP: " + GameFunction.playerCurrentHP);
			System.out.println("Enemy HP: " + GameFunction.enemyHP);
			Misc.printSeperator(30);
			Misc.combatMenu();
			GameFunction.playerChoice = GameFunction.getPlayerChoice(1, 4);
			switch (GameFunction.playerChoice) {
			case 1:
				System.out.println();
				playerAttack();
				break;
				
			case 2:
				System.out.println();
				playerDefend();
				break;
				
			case 3:
				System.out.println();
				playerEscape();
				break;
				
			case 4:
				System.out.println();
				inventory.useItem();

			}
		} while (run == true && GameFunction.enemyHP > 0 &&
				GameFunction.playerCurrentHP > 0);
		
	}
	
	//----------Encounter Minotaur----------
	public void minotaurFight() {
		inventory = new GameFunction();
		run = true;
		do {
			System.out.println();
			System.out.println("Player HP: " + GameFunction.playerCurrentHP);
			System.out.println("Enemy HP: " + GameFunction.enemyHP);
			Misc.printSeperator(30);
			Misc.combatMenu();
			GameFunction.playerChoice = GameFunction.getPlayerChoice(1, 4);
			switch (GameFunction.playerChoice) {
			case 1:
				System.out.println();
				playerAttack();
				break;
				
			case 2:
				System.out.println();
				playerDefend();
				break;
				
			case 3:
				System.out.println();
				playerEscape();
				break;
				
			case 4:
				System.out.println();
				inventory.useItem();
			
			}
		} while (run == true && GameFunction.enemyHP > 0 &&
				GameFunction.playerCurrentHP > 0);
	}
	
	//----------Encounter Siren----------
	public void sirenFight() {
		inventory = new GameFunction();
		run = true;
		do {
			System.out.println();
			System.out.println("Player HP: " + GameFunction.playerCurrentHP);
			System.out.println("Enemy HP: " + GameFunction.enemyHP);
			Misc.printSeperator(30);
			Misc.combatMenu();
			GameFunction.playerChoice = GameFunction.getPlayerChoice(1, 4);
			switch (GameFunction.playerChoice) {
			case 1:
				System.out.println();
				playerAttack();
				break;
				
			case 2:
				System.out.println();
				playerDefend();
				break;
				
			case 3:
				System.out.println();
				playerEscape();
				break;
			
			case 4:
				System.out.println();
				inventory.useItem();

			}
		} while (run == true && GameFunction.enemyHP > 0 &&
				GameFunction.playerCurrentHP > 0);
	}
	
	//----------Encounter Lamia----------
	public void lamiaFight() {
		inventory = new GameFunction();
		run = true;
		do {
			System.out.println();
			System.out.println("Player HP: " + GameFunction.playerCurrentHP);
			System.out.println("Enemy HP: " + GameFunction.enemyHP);
			Misc.printSeperator(30);
			Misc.combatMenu();
			GameFunction.playerChoice = GameFunction.getPlayerChoice(1, 4);
			switch (GameFunction.playerChoice) {
			case 1:
				System.out.println();
				playerAttack();
				break;
				
			case 2:
				System.out.println();
				playerDefend();
				break;
				
			case 3:
				System.out.println();
				playerEscape();
				break;
				
			case 4:
				System.out.println();
				inventory.useItem();
				
			}
		} while (run == true && GameFunction.enemyHP > 0 &&
				GameFunction.playerCurrentHP > 0);
	}
	
	//--------Player choice--------
	//Player choose attack
	public void playerAttack() {
		player.setPlayerAT();
		GameFunction.enemyHP -= player.getPlayerAT();
		if (GameFunction.enemyHP <= 0) {
			GameFunction.enemyHP = 0;
			System.out.println("Victory");
			
			//Get player exp 
			player.setExpGained();
			System.out.println("You get " + player.getExpGained() + " exp");
			player.setTotalExp(player.getTotalExp() + player.getExpGained());
			player.setPlayerLevel();
			if (GameFunction.enemyHP == 0) return;
		}
		
		GameFunction.playerCurrentHP -= GameFunction.enemyAttack;
		if (GameFunction.playerCurrentHP <= 0) {
			GameFunction.playerCurrentHP = 0;
			Misc.clearConsole();
			System.out.println("You are not strong enough");
			System.out.println("==LOOSE==");
			System.exit(0);
		}
		
	}
	
	
	//----------Player choose defend----------
	public void playerDefend() {
		GameFunction.playerCurrentHP = (GameFunction.playerCurrentHP 
				+ GameFunction.playerDefend) - GameFunction.enemyAttack;
		
		if(GameFunction.playerCurrentHP <= 0) {
			GameFunction.playerCurrentHP = 0;
			System.out.println("You are not strong enough");
			System.out.println("==LOOSE==");
			System.exit(0);
		}
	}
	
	
	//----------Player choose escape----------
	public void playerEscape() {
		if (function.escapeChance() == 3) {
			System.out.println("You escaped the battle");
			run = false;
			
		} else {
			System.out.println("Failed to escape");
			GameFunction.playerCurrentHP = GameFunction.playerCurrentHP - GameFunction.enemyAttack;
			run = true;
			if(GameFunction.playerCurrentHP <= 0) {
				GameFunction.playerCurrentHP = 0;
				Misc.clearConsole();
				System.out.println("You are not strong enough");
				System.out.println("==LOOSE==");
				System.exit(0);
			}
		}
	}
	
}	
