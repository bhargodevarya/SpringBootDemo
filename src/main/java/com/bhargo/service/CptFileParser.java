package com.bhargo.service;

import javax.annotation.PostConstruct;

public class CptFileParser implements FileParser {
	
	private String type = "";

	@Override
	public boolean parse() {
		// TODO Auto-generated method stub
		System.out.println("cpt parser");
		return true;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}
	
	@PostConstruct
	public void postConstruct() {
		register("cpt");
		FileParserFactory.addParser(type, this);
	}

}
