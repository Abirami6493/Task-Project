package com.omrbranch.reports.reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
	
	public static void generatejvmreports(String jsonFile) {
	File file = new File("C:\\Users\\DELL\\eclipse-workspace\\OmrBranchAPIAutomation-Abirami\\target");	
	Configuration configuration = new Configuration(file, "OMR Project");
	configuration.addClassifications("Browser", "Chrome");
	configuration.addClassifications("BrowserVersion", "142");
	configuration.addClassifications("OS", "WIN11");
	configuration.addClassifications("Sprint", "35");
	List<String>jsonFiles = new ArrayList<String>();
	jsonFiles.add(jsonFile);
	ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		
		
	}		

}
