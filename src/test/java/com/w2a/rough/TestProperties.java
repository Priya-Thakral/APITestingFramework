package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.w2a.SetUp.BaseTest;

public class TestProperties extends BaseTest {
	
	public static void main(String[] args) throws IOException {
		
		Properties config=new Properties();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
		config.load(fis);
		
		System.out.println(config.getProperty("baseURI"));
		
	}

}
