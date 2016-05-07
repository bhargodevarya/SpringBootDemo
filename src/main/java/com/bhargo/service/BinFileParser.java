package com.bhargo.service;

import javax.annotation.PostConstruct;

public class BinFileParser implements FileParser {
	
	private String type = "";

	@Override
	public boolean parse() {
		// TODO Auto-generated method stub
		System.out.println("bin parser");
		return false;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
		
	}
	
	@PostConstruct
	public void postConstruct() {
		register("bin");
		FileParserFactory.addParser(type, this);
	}
	
	

}
