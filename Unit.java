public abstract class Unit {
	protected String name;
	protected int attack;
	protected int defense;
	protected int dexterity;
	protected int intelligence;
	protected int hp;
	protected int mana;
	
	public Unit (String name,
	int attack,
	int defense,
	int dexterity,
	int intelligence,
	int hp,
	int mana)
	{ //I KNOW IT LOOKS UGLY SYBAU
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.hp = hp;
		this.mana = mana;
	}
	public void attack(Unit target){
		int damage = this.attack - target.defense;
		if ( damage < 0) damage = 0;
		target.hp -= damage;
		System.out.println(this.name + " attacks " + target.name + " for " + damage +" damage!");
	}
}