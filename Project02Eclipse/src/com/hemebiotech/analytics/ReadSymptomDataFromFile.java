package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() throws IOException {
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {

			Scanner scanner = new Scanner(reader);
			List<String> symptoms = new ArrayList<>();

			while (scanner.hasNext())
				symptoms.add(scanner.nextLine());

			return symptoms;
		}
	}
}
