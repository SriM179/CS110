import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Comparator;


class ClimateZone{

    private ArrayList<City> cityList = new ArrayList<City>();

    public ClimateZone(){
        cityList = new ArrayList<City>();
    }

    public ClimateZone(String f) throws IOException{
        cityList = new ArrayList<City>();
        FileInputStream myFile = new FileInputStream(f);
        Scanner myFileReader = new Scanner(myFile);
        while (myFileReader.hasNext()) {
            City city = new City(myFileReader.next(), myFileReader.next(), myFileReader.nextDouble(), myFileReader.nextDouble());   
            cityList.add(city);
        }
    }

    public void addCity(String c, String s, double h, double l){
        City city = new City(c, s, h, l);   
        cityList.add(city);
    }

    public int getCityCount(){
        if (cityList != null) {
            return cityList.size();
        } else {
            return 0; 
        }
    }

    public City getCityByName(String c, String s){
        if (cityList != null) {
            int i;
            for(i=0; i< cityList.size(); i++){
                if(((cityList.get(i).getName()).equals(c))&&((cityList.get(i).getState()).equals(s))){
                    return cityList.get(i);
                }
            }
            return null;
        } else {
            return null; 
        }
    }

    public void printHottestCities(){
        cityList.sort(Comparator.comparingDouble(City::getHighTemp).reversed());

    if (cityList.size() >= 2) {
        cityList.get(0).printInfo();
        cityList.get(1).printInfo();
    } else if (cityList.size() == 1) {
        cityList.get(0).printInfo();
    } 
    }

    public void printColdestCities(){
        cityList.sort(Comparator.comparingDouble(City::getLowTemp));

    if (cityList.size() >= 2) {
        cityList.get(0).printInfo();
        cityList.get(1).printInfo();
    } else if (cityList.size() == 1) {
        cityList.get(0).printInfo();
    } 
    }

    public void printAllCities(){
        int i;
        for(i=0; i< cityList.size(); i++){
            cityList.get(i).printInfo();
        }
    }


}