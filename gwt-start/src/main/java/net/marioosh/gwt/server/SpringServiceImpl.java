package net.marioosh.gwt.server;

import org.springframework.stereotype.Service;

import net.marioosh.gwt.shared.SpringService;

@Service("springService")
public class SpringServiceImpl implements SpringService {

	public String springTest() {
		return "Spring service works";
	}

}
