import java.util.*;

public class CombatManager {
    public static void startBattle(List<Player> party, List<Enemy> enemies) {
		List<Integer> unitspeed = new ArrayList();
			
        for (Player p : party) {
			unitspeed.add(1000 /p.dexterity);
			Collections.sort(unitspeed);
			
        }
        for (Enemy e : enemies) {
            unitspeed.add(1000 /e.dexterity);
			Collections.sort(unitspeed);
			
        }
		System.out.println(unitspeed);
    }
}
