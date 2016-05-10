package com.bhargo.config;

import java.util.HashSet;
import java.util.Set;

public class ConfigService {
	
	private Set<IConfig> configSet;

	public void addConfig(IConfig config) {
		configSet.add(config);
	}
	
	public Set<IConfig> getConfigSet() {
		return configSet;
	}

	//developers have to create methods in this class to access their configs, like the following
	
	public void showLocations(String stage) {
		System.out.println(configSet.stream().filter(n -> n instanceof StorageDetails).
		map(n -> (StorageDetails)n).map(n -> n.getStage()).findFirst().get().get(stage));
	}

    public void init() {
    	if(configSet == null) {
    		configSet = new HashSet<>();
    	}
    }
	
	
}
