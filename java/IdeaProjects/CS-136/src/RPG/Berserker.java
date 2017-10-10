package RPG; /**
Berserker:
The raging Berserk attacks a random target in the arena and deals 20 smashing
damage. They have a chance of hitting themselves. They can take 35 points
of damage before dying. They take half damage from fire, and double from 
slashing damage.
*/
import RPG.Gladiator;

import java.util.ArrayList;
import java.util.Random;

public class Berserker extends Gladiator
{
  private int identifier;
  public Berserker()
  {
    this.hitPoints = 35;
    this.speed = getRandom(1, 10);
    this.isDead = false;
	identifier = 0;
    this.damageType = "Smashing";
    this.gladiatorName = "A raging Barbarian";
  }
    public void setHP(int hp)
  {
    this.hitPoints = hp;
    if(hitPoints <= 0)
	{
      this.hitPoints = 0;
      this.isDead = true;
      this.gladiatorName = "A Slain Barbarian";
	}
  }
  
  public boolean isDead()
  {
	  return this.hitPoints <= 0;
  }

   public int getID()
  {
	  return this.identifier;
  }
  
  public int getHP(){
    return this.hitPoints;
  }
  
  public int getSpeed()
  {
	  return this.speed;
  }

  public int getDamage()
  {
	return 20;
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
    if(target == this){
        System.out.println(attacker + " attacks itself for " + amount + " points of damage.");
    }
    else{
        System.out.print(printTarget + " takes " + amount + " " + type + " damage from " + attacker);
    }

    System.out.println();
  }

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
	if(type == "Fire") 
	{
		setHP(this.hitPoints - damage/2);
		return damage/2;
	}
	if(type == "Slashing") 
	{
		setHP(this.hitPoints - damage*2);
		return damage*2;
	}
	else 
	{
		setHP(this.hitPoints - damage);
		return damage;
	}
  }
  
  public Gladiator getTarget()
  {
    int rnd = new Random().nextInt(Arena.gladiators.size());
    return Arena.gladiators.get(rnd);
  }
  
  private int getRandom(int min, int max)
  {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }
  
  public String toString()
  {
    if(gladiatorName == "A Slain Barbarian") return this.gladiatorName;
	return this.gladiatorName + " (" + this.hitPoints + ")";
  }
}