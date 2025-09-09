public class Player extends Unit {

	String job;

	
	public Player( String name, String job, int attack, int defense, int dexterity, int intelligence, int hp, int mana){
		super( name, attack,  defense,  dexterity,  intelligence,  hp,  mana);
		this.job = job;
	}
}
