package com.bhargo.config;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "details")
public class StorageDetails extends Config{

	private Map<String, Folder> stage;
	private Map<String, locations> source;    
    

	public Map<String, Folder> getStage() {
		return stage;
	}

	public void setStage(Map<String, Folder> stage) {
		this.stage = stage;
	}

	public Map<String, locations> getSource() {
		return source;
	}

	public void setSource(Map<String, locations> source) {
		this.source = source;
	}
	
	public static class Folder {
		
		private String inputfolder;
		private String outputfolder;
		public String getInputfolder() {
			return inputfolder;
		}
		public void setInputfolder(String inputfolder) {
			this.inputfolder = inputfolder;
		}
		public String getOutputfolder() {
			return outputfolder;
		}
		public void setOutputfolder(String outputfolder) {
			this.outputfolder = outputfolder;
		}
		@Override
		public String toString() {
			return "Folder [inputfolder=" + inputfolder + ", outputfolder=" + outputfolder + "]";
		}
	}

	public static class locations {
		private List<String> inputfile;
		private String outputfile;

		public List<String> getInputfile() {
			return inputfile;
		}

		public void setInputfile(List<String> inputfile) {
			this.inputfile = inputfile;
		}

		public String getOutputfile() {
			return outputfile;
		}

		public void setOutputfile(String outputfile) {
			this.outputfile = outputfile;
		}

		@Override
		public String toString() {
			return "locations [inputfile=" + inputfile + ", outputfile=" + outputfile + "]";
		}		
	}

	@Override
	public String toString() {
		return "StorageDetails [stage=" + stage + ", source=" + source + "]";
	}

	
}
