import Event.Plot;
import Others.GameFunction;
import Others.Misc;

public class Game {
	public static void main(String[] args) throws InterruptedException {
		int playerChoice;
		GameFunction events = new GameFunction();
		
		//OPENING
		
		events.gameOpening();
		do {
			System.out.println();
			Misc.printSeperator(30);
			Plot.songVillage();
			playerChoice =  GameFunction.getPlayerChoice(0, 9);
			switch (playerChoice) {
			case 0: 
				events.showPlayerInfo();
				break;
			case 1:
				do {
					events.cathiaForest();
					playerChoice = GameFunction.getPlayerChoice(0, 7);
					switch (playerChoice) {
					case 0: 
						events.showPlayerInfo();
						break;
					
					case 1:
						events.breadfruitChance();
						break;
						
					case 2:
						events.woodChance();
						break;
						
					case 3:
						events.thanismaRiver();
						break;
					
					case 4:
						events.showInventory();
						break;
						
					case 5:
						events.useItem();
						break;
					
					case 6:
						events.removeItem();
						break;
						
					}
					
				} while (playerChoice != 7);
				break;
				
			case 2:
				events.talkToElena();
				break;
			
			case 3:
				events.talkToKaiiso();
				break;
			
			case 4:
				events.talkToOmorph();
				break;
			
			case 5:
				events.showInventory();
				break;
			
			case 6:
				events.useItem();
				break;
				
			case 7:
				events.removeItem();
				break;
				
			}
			
		} while (playerChoice != 9);
		
		
		//Quit game
		
		Misc.clearConsole();
		Misc.exitGame();
		
	}
	
}
