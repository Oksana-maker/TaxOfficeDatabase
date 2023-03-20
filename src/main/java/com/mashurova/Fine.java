package com.mashurova;

import java.util.TreeSet;

public class Fine {
    private String nameFine;
    private int sum;

    public Fine(String nameFine,int sum) {
        this.nameFine = nameFine;
        this.sum = sum;
    }

    public String getNameFine() {
        return nameFine;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return " "+ nameFine + " : "+ sum+" ";
    }

}
