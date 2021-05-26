/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityassosiation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dell
 */
public class CountryCityAssosiation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountryDAO countryDAO = new CountryDAO();
        ArrayList<Country> countriesDataList = countryDAO.getCountriesData();
        countriesDataList.forEach(country -> {
            String country_code = country.getCountry_code();
            String country_name = country.getCountry_name();
            ArrayList<City> city_list = country.getCity_list();
            System.out.println(String.format("country_code : %1$s, country_name : %2$s", country_code, country_name));
            city_list.forEach(city -> {
                System.out.println(String.format("city_code : %1$s, city_name : %2$s", city.getCode(), city.getName()));
            });
            System.out.println("----------------------------------------------------------------------");
        });
        
        ArrayList<City> countryCitiesOrdered = countryDAO.getCountryCitiesOrdered("50010");
        countryCitiesOrdered.forEach(city->{
            System.out.println(city.getName()+" , "+city.getPopulation());
        });
    }

}
