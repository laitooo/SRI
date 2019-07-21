package zxc.laitooo.sri.data;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 14/06/2019.
 */

public class InfoLists {

    public ArrayList<String> countryList;
    public ArrayList<String> degreeList;
    public ArrayList<String> languageList;
    public ArrayList<String> fieldList;


    public InfoLists() {
        countryList = new ArrayList<>();
        countryList.add(0,"Select your country");
        countryList.add("Afghanistan");
        countryList.add("Argentina");
        countryList.add("Canada");
        countryList.add("egypt");
        countryList.add("France");
        countryList.add("Germany");
        countryList.add("Holand");
        countryList.add("India");
        countryList.add("Japan");
        countryList.add("Libya");
        countryList.add("Northland");
        countryList.add("Oman");
        countryList.add("Qatar");
        countryList.add("Rwanda");
        countryList.add("Sudan");
        countryList.add("Syria");
        countryList.add("United kingdom");
        countryList.add("United states of america");
        countryList.add("Yemen");

        degreeList = new ArrayList<>();
        degreeList.add(0,"Select your highest degree");
        degreeList.add("Secondary school");
        degreeList.add("High school");
        degreeList.add("Diploma degree");
        degreeList.add("Bichloras degree");
        degreeList.add("Master degree");
        degreeList.add("Phd degree");

        languageList = new ArrayList<>();
        languageList.add("Arabic");
        languageList.add("Chinese");
        languageList.add("English");
        languageList.add("French");
        languageList.add("German");
        languageList.add("Indian");
        languageList.add("Italy");
        languageList.add("Spanish");
        languageList.add("Japanese");
        languageList.add("Turkey");

        fieldList = new ArrayList<>();
        fieldList.add("Architecture");
        fieldList.add("Civil Engineering");
        fieldList.add("Electrical Engineering");
        fieldList.add("Electronic Engineering");
        fieldList.add("Mechanical Engineering");
        fieldList.add("Medical");
        fieldList.add("Artificial intelligence");
        fieldList.add("Software Engineering");
        fieldList.add("Statistics");
        fieldList.add("Solar energy");
        fieldList.add("Psychology");
        fieldList.add("Chemistry");
        fieldList.add("Physics");
        fieldList.add("Languages");
    }
}
