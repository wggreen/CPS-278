package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class MP2BeanConfig {

	@Bean
	public Character character1() {
		Character character = new Character();
		character.setName("TomNook");
		character.setFightingPower(fireball());
		return character;
	}
	
	@Bean
	public Character character2() {
		Character character = new Character();
		character.setName("TomNook");
		character.setFightingPower(massterSword());
		return character;
	}
	
	@Bean
	public FightingPower fireball() {
		return new Fireball();
	}
	
	@Bean
	public FightingPower massterSword() {
		return new MasterSword();
	}
	
	@Bean
	@Qualifier("EndorBattleGround")
	public BattleGround nabooBattleGround() {
		return new NabooBattleGround();
	}
	
	@Bean
	public BattleGround endorBattleGround() {
		return new EndorBattleGround();
	}
	
	@Bean
	public Battle battle() {
		Battle battle = new Battle();
		battle.setBattleground(nabooBattleGround());
		battle.setCharacter1(character1());
		battle.setCharacter2(character2());
		return battle;
	}
	
}
	
	
	
	