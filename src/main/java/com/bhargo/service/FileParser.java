package com.bhargo.service;

public interface FileParser {
	
	boolean parse();
	
	void setType(String type);
	
	default void register(String type) {
		setType(type);
	}

}
