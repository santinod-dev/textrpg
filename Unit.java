public abstract class Unit {
	protected String name;
	protected int attack;
	protected int defense;
	protected int dexterity;
	protected int intelligence;
	protected int hp;
	protected int mana;
	protected boolean isDefending;
	public Unit (String name,
	int attack,
	int defense,
	int dexterity,
	int intelligence,
	int hp,
	int mana,
	boolean isDefending)
	{ //I KNOW IT LOOKS UGLY SYBAU
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.hp = hp;
		this.mana = mana;
		this.isDefending = isDefending;
	}
	public void attack(Unit target){
		int damage = this.attack - target.defense;
		if(target.isDefending){
			if ( damage/2 < 0) damage = 0;
			target.hp -= damage;
			System.out.println(this.name + " attacks " + target.name + " for " + damage +" damage!");
			target.isDefending = false;
		}
		else{
			if ( damage < 0) damage = 0;
			target.hp -= damage;
			System.out.println(this.name + " attacks " + target.name + " for " + damage +" damage!");
		}
	}
}