package edu.wccnet.wggreen.DIDemo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinAidService {

	public String getFinAidType() {
		return "Grants";
	}

}
