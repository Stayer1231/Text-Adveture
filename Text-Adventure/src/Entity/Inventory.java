package Entity;

import java.util.ArrayList;
import java.util.HashMap;

import Others.GameFunction;

public class Inventory {
	static int slotNumber = 0;
	static ArrayList<String> playerItem = new ArrayList<>();
	static int[] quantity = new int[5];
	public static boolean haveWood;
	static int min = 0, max = 2;
	static int itemGetChance = 0;
	Player player;
	
	
	//Constructor
	public Inventory(Player player) {
		this.player = player;
	}
	
	
	//ADDING
	public static void addItem(String nameOfItem) {
		if (playerItem.indexOf(nameOfItem) < 0 && playerItem.size() < 5) {
			playerItem.add(nameOfItem);
		}
		
		if (playerItem.indexOf(nameOfItem) >= 0) {
			if (quantity[playerItem.indexOf(nameOfItem)] > 4) {
				System.out.println("< Cannot get more >");
			} else {
				quantity[playerItem.indexOf(nameOfItem)] ++;
				System.out.println("+ " + nameOfItem);
			}
			
		}
	}
	
	
	//REMOVING
	public static void removeItem(String nameOfItem) {
		if (playerItem.indexOf(nameOfItem) >= 0 && playerItem.size() < 5) {
			playerItem.remove(nameOfItem);
			System.out.println("< Remove " + nameOfItem + " >");
			
		} else {
			System.out.println("< Nothing to remove >");
		}
		
	}
	
	
	//USING ITEM
	public static void useItem(String nameOfItem) {
		if (playerItem.indexOf(nameOfItem) < 0 && playerItem.size() <= 0) {
			System.out.println("< Nothing to use >");
		}
		
		if (playerItem.indexOf(nameOfItem) >= 0 && playerItem.size() < 5) {
			quantity[playerItem.indexOf(nameOfItem)] --;
			System.out.println("< Use " + nameOfItem + " >");
			itemSpec(nameOfItem);
			if (quantity[playerItem.indexOf(nameOfItem)] == 0) {
				playerItem.remove(nameOfItem);
			}
		}

	}
	
	
	//ITEM USED
	public static void itemSpec(String nameOfItem) {
		if (nameOfItem.equals("breadfruit")) {
			GameFunction.playerCurrentHP += 15;
			System.out.println("Heal 15 HP");
		}
	}
	
	
	//VIEW INVENTORY
	public static void viewInventory() {
		for (short i = 0; i < 5; i++) {
			if (i < playerItem.size() && playerItem.get(i) != null && playerItem.indexOf(playerItem) < 0) {
				System.out.println(playerItem.get(i) + " x" + quantity[i]);
			} else {
				System.out.println("< Empty >");
			}
		}
	}
	
	//OTHERS
	public static void checkForWood() {
		if (playerItem.indexOf("wood") < 0 && playerItem.size() < 5) {
			haveWood = false;
			
		} else {
			haveWood = true;
		}
	}
}

