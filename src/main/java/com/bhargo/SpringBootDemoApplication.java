package com.bhargo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.bhargo.config.AppConfig;
import com.bhargo.config.StorageDetails;
import com.bhargo.service.BinFileParser;
import com.bhargo.service.CptFileParser;
import com.bhargo.service.FileParserContext;
import com.bhargo.service.FileParserFactory;
import com.bhargo.service.FileReaderService;
import com.bhargo.service.generated.Bins;
import com.bhargo.service.generated.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{
	
	@Autowired
	private StorageDetails storageDetails;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Bean
	public Person person() {
		return new Person();
	}
	
	@Bean
	public FileReaderService fileReaderService() {
		return new FileReaderService();
	}
	
	@Bean
	public BinFileParser binFileParser() {
		return new BinFileParser();
	}
	
	@Bean
	public CptFileParser cptFileParser() {
		return new CptFileParser();
	}
	
	@Bean
	public FileParserContext fileParserContext() {
		return new FileParserContext();
	}
	
	@Bean
	public AppConfig appConfig() {
		return new AppConfig();
	}
	
	@Bean
	public FileParserFactory fileParserFactory() {
		return new FileParserFactory();
	}
	
	@Bean
	public StorageDetails storageDetails() {
		return new StorageDetails();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//parser factory, see FileParserFactory.java and CptFileParser.java for more details
		//FileParserFactory.showMap();
		System.out.println("parser from the factory for cpt is " + FileParserFactory.getParser("cpt"));
		System.out.println("parser from the factory for bin is " + FileParserFactory.getParser("bin"));
		
		for(int i =0;i<=4; i++)
			System.out.println();
		
		//BinXML parsing logic
		JAXBContext con = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = con.createUnmarshaller();
		
		//This class can be edited to include only those tags that are needed
		//for now number is commented.
		Bins bins = (Bins) unmarshaller.
				//this stream will be changed, we dont need to create it this way
				unmarshal(new FileInputStream(
						new File("/home/hadoop/Documents/stsworkspace/SpringBootDemo/src/main/resources/bins.xml")));
		
		System.out.println("start > Bin file contains the folowing data >>>>>");
		System.out.println();
		//this can be filtered as per our criteria, since I dont have any matching data in my dummy XML, it doesnot return anything
		bins.getBin().stream().filter(bin -> bin.getBrand().equals("American Express")).forEach(System.out::println);	
		System.out.println();
		System.out.println("end > Bin file contains the folowing data >>>>>");
		for(int i =0;i<=4; i++)
			System.out.println();
		
		//yml storage details demo
		storageDetails.getStage().entrySet().forEach(entry -> System.out.println("key is " + entry.getKey() + " value is " + entry.getValue()));
		storageDetails.getSource().entrySet().forEach(entry -> System.out.println("key is " + entry.getKey() + " value is " + entry.getValue()));
	}
}
