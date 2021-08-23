package com.hemebiotech.analytics;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile("./Project02Eclipse/symptoms_ouput_txt");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);
        analyticsCounter.process();
    }
}
