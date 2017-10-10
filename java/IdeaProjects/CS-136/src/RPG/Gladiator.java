package RPG;

/**
Lab 6: RPG
Design a program that will simulate an arena battle between three different Gladiator types
*/
//Authors = Jesse Rodriguez && Adam Goins
public abstract class Gladiator
{
  protected int hitPoints;
  protected int attackPower;
  protected Gladiator target;
  protected boolean isDead;
  protected int speed;
  protected String gladiatorName;
  protected String damageType;

  abstract public void setHP(int hp);
  abstract public int getHP();
  abstract public boolean isDead();
  abstract public int getDamage();
  abstract public String getDamageType();
  abstract public int takeDamage(int damage, String type, Gladiator attacker);
  abstract public Gladiator getTarget();
  abstract public String toString();
  public abstract void attack();
  public abstract int getSpeed();
}
