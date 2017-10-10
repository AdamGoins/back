package RPG;

import java.util.ArrayList;
import java.util.*;

public class Arena {

	public static ArrayList <Gladiator> gladiators = new ArrayList <Gladiator> ();
	public static ArrayList<Integer> speedArray = new ArrayList<Integer>();
	/**
	 * The updateArena() method is designed to loop through the current Gladiators in the arena and remove any Gladiators
	 * That are dead.
     */
	public static void updateArena() {
		// We can't remove from an ArrayList while we're looping through it, so we create a new ArrayList that mimics the
		// Gladiators arraylist and make modifications to that.
		ArrayList < Gladiator > glads = new ArrayList < > (gladiators);

		// For each Gladiator in the arena
		for (Gladiator gladiator: gladiators) {
			// If that gladiator is dead, we remove it.
			if (gladiator.isDead()) {
				glads.remove(gladiator);
			}
		}
		// Set out gladiators arraylist to the modified glads Arraylist that contains only living Gladiators.
		gladiators = glads;

		// If there's only one man standing, we end the program by calling displayAndExit()
		if (gladiators.size() <= 1) displayAndExit();
	}

	public static void main(String[] args) {
		// Creates two of each type of Gladiator subclass and stores them in variables
		Warrior warrior1 = new Warrior(1);
		Warrior warrior2 = new Warrior(2);
		Berserker berserker1 = new Berserker();
		Berserker berserker2 = new Berserker();
		Mage mage1 = new Mage();
		Mage mage2 = new Mage();
		
		speedArray.add(berserker1.getSpeed());
		speedArray.add(berserker2.getSpeed());
		speedArray.add(warrior1.getSpeed());
		speedArray.add(warrior2.getSpeed());
		speedArray.add(mage1.getSpeed());
		speedArray.add(mage2.getSpeed());
		Collections.sort(speedArray, Collections.reverseOrder());
		// Add our six Gladiator types to the Gladiator Arraylist
		int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0; 
		for(int element: speedArray)
		{
			
			if(warrior1.getSpeed() == element) 
			{
				cnt1++;
				if (cnt1 > 1) continue;
				gladiators.add(warrior1);
			}
			if(warrior2.getSpeed() == element) 
			{
				cnt2++;
				if (cnt2 > 1) continue;
				gladiators.add(warrior2);
			}
			if(berserker1.getSpeed() == element) 
			{
				cnt3++;
				if (cnt3 > 1) continue;
				gladiators.add(berserker1);
			}
			if(berserker2.getSpeed() == element) 
			{
				cnt4++;
				if (cnt4 > 1) continue;
				gladiators.add(berserker2);
			}
			if(mage1.getSpeed() == element) 
			{
				cnt5++;
				if (cnt5 > 1) continue;
				gladiators.add(mage1);
			}
			if(mage2.getSpeed() == element) 
			{
				cnt6++;
				if (cnt6 > 1) continue;
				gladiators.add(mage2);
			}
		}
		// Starting turn is turn 1
		int turn = 1;

		// while there's more than one man standing.
		while (gladiators.size() > 1) {
			System.out.println("Turn " + turn);
			//Print the gladiators
			System.out.println(berserker1.toString());
			System.out.println(berserker2.toString());
			System.out.println(warrior1.toString());
			System.out.println(warrior2.toString());
			System.out.println(mage1.toString());
			System.out.println(mage2.toString());
			System.out.println();

			// Starts an attack round for each gladiator in the arena.
			for (Gladiator contestant: gladiators) {
				// If the gladiator is dead it can't attack, therefore we continue.
				if (contestant.isDead()) continue;
				// Contestant attacks for its attack round.
				contestant.attack();
				// Updates the arena
				updateArena();
			}
			System.out.println();
			// Increments the turn count variable because this is the end of a turn.
			turn++;
		}
	}

	/**
	 * This method is called when the Arena is down to one person.
	 * It displays the last (wo)man standing and then terminates the program.
	 */
	public static void displayAndExit() {
		System.out.println("Winner: " + gladiators.get(0));
		System.exit(0);
	}
}