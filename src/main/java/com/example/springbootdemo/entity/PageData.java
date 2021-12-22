package com.example.springbootdemo.entity;

public class PageData {
    private int SumloginNumbers;
    private int Sumconsumption;

    public PageData(int sumloginNumbers, int sumconsumption) {
        SumloginNumbers = sumloginNumbers;
        Sumconsumption = sumconsumption;
    }

    public PageData() {
    }

    public int getSumloginNumbers() {
        return SumloginNumbers;
    }

    public void setSumloginNumbers(int sumloginNumbers) {
        SumloginNumbers = sumloginNumbers;
    }

    public int getSumconsumption() {
        return Sumconsumption;
    }

    public void setSumconsumption(int sumconsumption) {
        Sumconsumption = sumconsumption;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "SumloginNumbers=" + SumloginNumbers +
                ", Sumconsumption=" + Sumconsumption +
                '}';
    }
}
