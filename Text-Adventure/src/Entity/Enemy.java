package Entity;

public class Enemy {
	
	//Enemy attributes
	private String enemyName;
	private int enemyHP;
	private int enemyAT;
	private int[] updateHP = {25, 40, 50};
	private int[] updateAT = {10, 15, 30};
	
	Player player;
	
	//Constructor
	public Enemy(Player player) {
		this.player = player;
	}

	
	//----------Name----------
	public void setEnemyName() {
		String[] names = {"Harpy", "Minotaur", "Siren", "Lamia"};
		int i = (int) (Math.random() * 4);
		enemyName = names[i];
	}
	
	public String getEnemyName() {
		return enemyName;
	}
	
	
	//----------HP----------
	public void setEHP() {
		int[] hp = {80, 90, 100, 140}; //80, 90, 100, 140
		int i = (int) (Math.random() * 4);
		enemyHP = hp[i];
	}
	
	public int getEHP() {
		return enemyHP;
	}
	
	public void updateEnemyAttributes() {
		if (player.getPlayerLevel() > 3 && player.getPlayerLevel() <= 6) {
			enemyHP += updateHP[0];
			enemyAT += updateAT[0];
		}
	}
	
	
	//----------Attack----------
	public void setEnemyAT() {
		int[] attack = {10, 12, 15, 18};
		int i = (int) (Math.random() * 4);
		enemyAT = attack[i];
	}
	
	public int getEnemyAT() {
		return enemyAT;
	}

}
