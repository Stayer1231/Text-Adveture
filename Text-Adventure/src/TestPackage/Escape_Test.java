package TestPackage;

import Others.Function;

public class Escape_Test {
	public static void main(String[] args) {
		Function func = new Function();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(func.escapeChance());
		}
		
	}
}
