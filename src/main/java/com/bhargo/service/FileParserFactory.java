package com.bhargo.service;

import java.util.HashMap;
import java.util.Map;

public class FileParserFactory {
	
	private static Map<String, FileParser> parserMap = new HashMap<>();
	
	public static FileParser getParser(String source) {
		return parserMap.entrySet().stream().
		filter(n -> n.getKey().equals(source)).findFirst().get().getValue();
	}
	
	public static boolean addParser(String key, FileParser fileParser) {
		 return parserMap.put(key, fileParser) == null;
	}
	
	public static void showMap() {
		parserMap.entrySet().forEach(entry -> System.out.println("Key is " + entry.getKey() + " value is " + entry.getValue()));
	}

}
