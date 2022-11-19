package Others;

public class Misc {
	static final int LENGTH = 50;	
	
	//----------MENU----------
	public static void removeItemMenu() {
		System.out.println("1/ Remove normal potion");
		System.out.println("2/ Remove holy potion");
		System.out.println("3/ Remove breadfruit");
		System.out.println("4/ Remove pomegranate");
		System.out.println("5/ Remove elightania");	
		System.out.println("6/ Remove wood");
		System.out.println("7/ View inventory");
		System.out.println("8/ Back");
		System.out.print(": ");
	}
	
	public static void combatMenu() {
		System.out.println("1/ Attack");
		System.out.println("2/ Defend");
		System.out.println("3/ Escape");
		System.out.println("4/ Use item");
		System.out.print(": ");
	}
	
	public static void useItemMenu() {
		System.out.println("1/ Use normal potion");
		System.out.println("2/ Use holy potion");
		System.out.println("3/ Use breadfruit");
		System.out.println("4/ Use pomegranate");
		System.out.println("5/ Use elightania");
		System.out.println("6/ Back");
		System.out.print(": ");
	}
	
	//----------OTHERS----------
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println();		
		}
	}
	
	public static void printSeperator(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	//EXIT GAMES
	public static void exitGame() throws InterruptedException {
		String thanks = "THANKS FOR PLAYING ❤️";
		char[] chars = thanks.toCharArray();
		for(char letter : chars) {
			System.out.print(letter);
			Thread.sleep(50);
		}
	}
}
 