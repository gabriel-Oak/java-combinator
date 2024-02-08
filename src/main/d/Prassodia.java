package com.example;

public class Prassodia extends Card {

  private int attackAccumulator = 0;
  private int defenseAccumulator = 0;
  private int skillAccumulator = 0;

  public Prassodia(Integer attack, Integer defense, Integer skill) {
    super(attack, defense, skill);
  }

  public void reset() {
    attackAccumulator = 0;
    defenseAccumulator = 0;
    skillAccumulator = 0;
  }

  public void addCard(Card card) {
    attackAccumulator += card.getAttack();
    defenseAccumulator += card.getDefense();
    skillAccumulator += card.getSkill();
  }

  public CalculationResult calculate() {
    if (attackAccumulator > getAttack() || defenseAccumulator > getDefense() || skillAccumulator > getSkill())
      return CalculationResult.surpass;

    if (attackAccumulator < getAttack() || defenseAccumulator < getDefense() || skillAccumulator < getSkill())
      return CalculationResult.remains;

    return CalculationResult.equals;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString() + " " + attackAccumulator + " " + defenseAccumulator + " " + skillAccumulator;
  }
}
