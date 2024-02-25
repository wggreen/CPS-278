package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.stereotype.Component;

@Component
public class MasterSword implements FightingPower {

	public String getFightingPowerDesc() {
		return "swinging the master sword";
	}

}
