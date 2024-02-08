package com.example;

public class Card {
  private Integer attack;
  private Integer defense;
  private Integer skill;

  public Card(Integer attack, Integer defense, Integer skill) {
    this.attack = attack;
    this.defense = defense;
    this.skill = skill;
  }

  public static Card fromLine(String line) {
    final String[] cardInput = line.split(" ");
    return new Card(
        Integer.parseInt(cardInput[0]),
        Integer.parseInt(cardInput[1]),
        Integer.parseInt(cardInput[2]));
  }

  public Integer getAttack() {
    return attack;
  }

  public Integer getDefense() {
    return defense;
  }

  public Integer getSkill() {
    return skill;
  }

  @Override
  public String toString() {
    return this.attack + " " + this.defense + " " + this.skill;
  }
}
