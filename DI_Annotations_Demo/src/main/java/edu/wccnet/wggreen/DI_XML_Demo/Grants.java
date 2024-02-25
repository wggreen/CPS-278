package edu.wccnet.wggreen.DI_XML_Demo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinAidService {

	public String getFinAidType() {
		return "Grants";
	}

}
