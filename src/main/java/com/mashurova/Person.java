package com.mashurova;

import java.util.ArrayList;
import java.util.TreeSet;

public class Person extends City {
    private String surname;
    private String firstName;
    private String identCode;

    public Person(String identCode,String surname, String firstName,String cityName ) {
        super(cityName);
        this.surname = surname;
        this.firstName = firstName;
        this.identCode = identCode;

    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getIdentCode() {
        return identCode;
    }


    @Override
    public String toString() {
        return getCityName() +" "+ identCode + ' ' + firstName + ' ' +surname + ' ';
    }
}
