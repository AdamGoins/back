package RPG; /**Warrior Class:
The disciplined Warrior looks at all his potential targets and attacks 
the one with the most health. They deal between 10 to 16 slashing damage 
with a HP value of 20 to 40 points of damage. A warrior has 1/4 chance to
dodge an attack with the types slashing and smashing.
*/
import java.util.ArrayList;
import java.util.Random;

public class Warrior extends Gladiator
{
  private int identifier;
  public Warrior(int id)
  {
    this.hitPoints = getRandom(20, 40);
    this.speed = getRandom(5, 10);
    this.isDead = false;
    this.damageType = "Slashing";
    this.gladiatorName = "A disciplined Warrior";
	this.identifier = id;
  }

  public void setHP(int hp)
  {
    this.hitPoints = hp;
    if(hitPoints <= 0)
	{
      this.hitPoints = 0;
      this.isDead = true;
      this.gladiatorName = "A Slain Warrior";
	}
  }
  
  public int getID()
  {
	  return this.identifier;
  }
  public boolean isDead()
  {
	  return this.hitPoints <= 0;
  }

  public int getHP()
  {
    return this.hitPoints;
  }
  
  public int getSpeed()
  {
	  return this.speed;
  }

  public int getDamage()
  {
	return getRandom(10,16);
  }

  public void attack(Gladiator target) 
  {
    int damage, amount;
    String printTarget, type, attacker;
    damage = this.getDamage();
    type = this.getDamageType();
    attacker = this.toString();
    printTarget = target.toString();

    amount = target.takeDamage(damage, type, this);
    System.out.print(printTarget + " takes " + amount + " " + type + " damage from " + attacker);
    System.out.println();
  }

  @Override
  public void attack() 
  {
	  attack(getTarget());
  }
  
 public String getDamageType()
  {
	  return this.damageType;
  }

public int takeDamage(int damage, String type, Gladiator target)
{
  int die;
  die = getRandom(1, 4);
  if(!(die == 1 && (type == "Slashing" || type == "Smashing")))
  {
    setHP(this.hitPoints - damage);
    return damage;
  }
  System.out.println("The Warrior dodges!");
  return 0;
}

public Gladiator getTarget()
{
  Gladiator gladiator = null;
    for(Gladiator glad : Arena.gladiators)
    {
      if(gladiator == this) continue;
      if(gladiator == null) gladiator = glad;
      if(gladiator.getHP() > glad.getHP()) continue;
      gladiator = glad;
    }
    this.target = gladiator;
    return gladiator;
}

  private int getRandom(int min, int max)
  {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public String toString()
  {
    if(gladiatorName == "A Slain Warrior") {return this.gladiatorName;}
	return this.gladiatorName + " (" + this.hitPoints + ")";
  }
}
