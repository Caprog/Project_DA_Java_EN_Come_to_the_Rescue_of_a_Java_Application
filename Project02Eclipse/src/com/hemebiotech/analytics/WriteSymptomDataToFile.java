package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void write(Map<String, Integer> symptomsOccurences) throws IOException {

        try(BufferedWriter writer = new BufferedWriter (new FileWriter(this.filepath))){
            for (Map.Entry<String, Integer> entrySymptomsOccurences : symptomsOccurences.entrySet()){
                String symptom = entrySymptomsOccurences.getKey();
                Integer occurences = entrySymptomsOccurences.getValue();
                String message = String.format("%s=%s\n", symptom, occurences);
                writer.write(message);
            }
        }
    }
}
