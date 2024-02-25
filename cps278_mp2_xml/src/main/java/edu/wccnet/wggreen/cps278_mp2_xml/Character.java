package edu.wccnet.wggreen.cps278_mp2_xml;

public class Character {
	private String name;
	private double health;
	private double strength;

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public FightingPower getFightingPower() {
		return fightingPower;
	}

	public void setFightingPower(FightingPower fightingPower) {
		this.fightingPower = fightingPower;
	}

	public void setName(String name) {
		this.name = name;
	}

	private FightingPower fightingPower;

	public String getName() {
		return name;
	}

	public void useFightingPower() {
		System.out.println(name + " is " + fightingPower.getFightingPowerDesc());
	}
}
