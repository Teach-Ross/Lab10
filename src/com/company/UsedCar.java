package com.company;

public class UsedCar extends Car {
    private double mileage;

    public UsedCar(String make, String model, int year, double price, double mileage) {
        super(make, model, year, price);
        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString(){
        String output = super.toString();
        output += String.format("%9.0f (USED)", mileage);
        return output;
    }
}
