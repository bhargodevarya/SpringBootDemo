package com.bhargo.service;

import org.springframework.beans.factory.annotation.Autowired;

public class FileParserContext {
	
	FileParser fileParser;	
	
	public FileParser getFileParser() {
		return fileParser;
	}

	public void setFileParser(FileParser fileParser) {
		this.fileParser = fileParser;
	}

	public void parseFile() {
		fileParser.parse();
	}

}
