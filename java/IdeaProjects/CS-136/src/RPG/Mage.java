package RPG;


import java.util.Random;
/**
 * The Mage class extends the Gladiator class and is designed to meet program requirements.
 *
 * "Wild mages deal fire damage to everyone in the arena, themselves included.
 *  Each target takes a random amount of damage between 0 and
 *  6 fire damage (calculated per target.) A mage takes between 10 and 60
 *  points of damage to kill a mage. When they are killed they deal 5 fire
 *  damage back to whoever killed them"
 */
public class Mage extends Gladiator {

    /**
     * Zero-Argument Constructor, initializes superclass fields for the mage object
     */
    public Mage() {
        this.hitPoints = getRandom(10, 60);
        this.speed = getRandom(5, 10);
        this.isDead = false;
        this.damageType = "Fire";
        this.gladiatorName = "A wild Mage";
    }

    /**
     * Setter for the HP field
     * @param hp int: The integer to set the current HP to.
     */
    public void setHP(int hp) {
        // Sets HP
        this.hitPoints = hp;

        // If the HP is <= 0, cap it at 0 (don't want negative HP values) and then reflect the mage is dead
        if (hitPoints <= 0) {
            this.hitPoints = 0;
            this.isDead = true;
            this.gladiatorName = "A Slain Mage";
        }
    }

    /**
     * Returns if this character is dead
     * @return boolean: True if this character is dead, false otherwise
     */
    public boolean isDead() {
        return this.hitPoints <= 0;
    }

    /**
     * Getter for the HP field
     * @return int: The current HP of this character
     */
    public int getHP() {
        return this.hitPoints;
    }
	
	public int getSpeed()
    {
	   return this.speed;
    }

    /**
     * Returns the possible damage this character can do within range of 0,6
     * @return int: The damage this character does with this attack
     */
    public int getDamage() {
        return getRandom(0, 6);
    }

    /**
     * This method returns the type of damage this character does. In this case, "Fire" damage.
     * @return String: The type of damage this character does
     */
    public String getDamageType() {
        return this.damageType;
    }

    /**
     * Does damage to this character.
     * @param damage int: The amount damage being done.
     * @param type String: The type of damage being done.
     * @param attacker Gladiator: The Gladiator attacking this character
     *
     * @return int: The amount of damage done.
     */
    public int takeDamage(int damage, String type, Gladiator attacker) {
        // Sets HP to the HP deduction
        setHP(this.hitPoints - damage);
        // If the character is dead, we do 5 damage to the Gladiator that killed this mage
        if (isDead()) {
            if (attacker == this) return damage;
            System.out.println("The Mage casts Flame on death.");
            attacker.takeDamage(5, this.damageType, this);
        }
        return damage;
    }


    /**
     * Returns a random number within a range.
     * @param min int: Threshold minimum of random number.
     * @param max int: Threshold maximum of random number.
     *
     * @return int: Random integer within range of min/max.
     */
    private int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * This method attacks all Gladiators in the Arena
     */
    public void attack() {

        String attacker = this.toString();
        // For each gladiator in arena.
        for (Gladiator gladiator: Arena.gladiators) {
            // Do damage and display output.
            System.out.print(gladiator + " takes " +
                    gladiator.takeDamage(getDamage(), getDamageType(), this) +
                    " " + getDamageType() + " damage from " +
                    attacker);
            System.out.println();

        }
    }

    /**
     * This method returns this mage at the target
     * @return Gladiator: Current instance of this class.
     */
    public Gladiator getTarget() {
        return this;
    }

    /**
     * Overrides the toString() method from the Object class to display the character data as shown in example output.
     *
     * @return String: Formatted data about the current instance of this class.
     */
    public String toString()
    {
       if(gladiatorName == "A Slain Mage") {return this.gladiatorName;}
	   return this.gladiatorName + " (" + this.hitPoints + ")";
    }
}