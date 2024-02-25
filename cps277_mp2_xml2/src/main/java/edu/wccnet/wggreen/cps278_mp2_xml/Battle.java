package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EndorBattleGround")
public class Battle {
	
	@Autowired
	private Character character1;
	@Autowired
	private Character character2;
	@Autowired
    @Qualifier("EndorBattleGround")
	private BattleGround battleground;

	public Character getCharacter1() {
		return character1;
	}

	public Character getCharacter2() {
		return character2;
	}
	
	public Battle() {
		
	}

	public Battle(Character character1, Character character2, BattleGround battleground) {
		this.character1 = character1;
		this.character2 = character2;
		this.battleground = battleground;
	}

	public void fight() {
		System.out.println("On " + battleground.getBattleGroundDesc() + ", " + getCharacter1().getName() + " and "
				+ getCharacter2().getName() + " are fighting.");
		character1.useFightingPower();
		character2.useFightingPower();
	}

	public BattleGround getBattleground() {
		return battleground;
	}

	public void setBattleground(BattleGround battleground) {
		this.battleground = battleground;
	}

	public void setCharacter1(Character character1) {
		this.character1 = character1;
	}

	public void setCharacter2(Character character2) {
		this.character2 = character2;
	}
}
