package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.stereotype.Component;

@Component
public class Fireball implements FightingPower {

	public String getFightingPowerDesc() {
        return "throwing fireballs";
	}

}
