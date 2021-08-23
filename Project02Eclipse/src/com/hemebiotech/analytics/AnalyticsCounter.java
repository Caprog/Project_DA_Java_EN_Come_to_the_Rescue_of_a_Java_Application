package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	public void process() throws IOException {

		List<String> symptoms = this.symptomReader.getSymptoms();

		Map<String, Integer> symptomsOccurences = computeOccurences(symptoms);

		this.symptomWriter.write(symptomsOccurences);
	}

	private Map<String, Integer> computeOccurences(List<String> symptoms) {
		Map<String, Integer> symptomsOccurences = new TreeMap<String, Integer>();
		for (String symptom: symptoms) {
			Integer symptomOccurences = symptomsOccurences.get(symptom);
			if(symptomOccurences == null)
				symptomsOccurences.put(symptom, 1);
			else
				symptomsOccurences.put(symptom, ++symptomOccurences);
		}
		return symptomsOccurences;
	}
}
