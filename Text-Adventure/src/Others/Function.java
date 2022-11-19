	package Others;

public class Function {
	private int monsterChance;
	private int itemChance;
	private int escapeChance;
	
	//Monster appearance chance
	public int getMonsterChance() {
		return monsterChance;
	}
	
	public void setMonsterChance(int monsterChance) {
		this.monsterChance = monsterChance;
	}

	public int monsterChance() {
		setMonsterChance((int) (Math.random() * 2));
		return monsterChance;
	}
	
	//Item getting chance
	public int getItemChance() {
		return itemChance;
	}
	
	public void setItemChance(int itemChance) {
		itemChance = ((int) (Math.random() * 2));
		this.itemChance = itemChance;
	}
	
	//Escaping chance
	public int getEscapeChance() {
		return escapeChance;
	}
		
	public void setEscapeChance(int escapeChance) {
		this.escapeChance = escapeChance;
	}

	public int escapeChance() {
		setEscapeChance((int) (Math.random() * 4)); //Wide range make escape difficult
		return escapeChance;
	}
	
}
