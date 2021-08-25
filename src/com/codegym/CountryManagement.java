package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryManagement {
    public static List<Country> countries = new ArrayList<>();

    public void showAll() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void readCountryListToFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;
        while ((line = br.readLine()) != null) {
            String countryLine[] = line.split(",");
            String countryId = countryLine[0];
            String countryCode = countryLine[1];
            String countryName = countryLine[2];
            Country country = new Country(countryId, countryCode, countryName);
            countries.add(country);
        }
        br.close();
        fileReader.close();
    }

    public void writeCountryListToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bw= new BufferedWriter(fileWriter);
        for (int i = 0; i < countries.size(); i++) {
            bw.write(countries.get(i).toString());
            if (i != countries.size() - 1) {
                bw.write("\n");
            }
        }
        bw.close();
        fileWriter.close();
    }
}
