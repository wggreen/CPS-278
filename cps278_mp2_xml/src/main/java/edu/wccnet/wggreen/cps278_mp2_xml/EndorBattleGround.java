package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.stereotype.Component;

@Component
public class EndorBattleGround implements BattleGround {

	public String getBattleGroundDesc() {
		return "Endor";
	}

}
