package com.bhargo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class Config implements IConfig {
	
	@Autowired
	private ConfigService configService;
	
	@PostConstruct
	public void addToConfig() {
		configService.addConfig(this);
		System.out.println("added to the config");
	}

}
