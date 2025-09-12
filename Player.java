public class Player extends Unit {

	String job;

	
	public Player( String name, String job, int attack, int defense, int dexterity, int intelligence, int hp, int mana, boolean isDefending){
		super( name, attack,  defense,  dexterity,  intelligence,  hp,  mana, isDefending);
		this.job = job;
	}
}
