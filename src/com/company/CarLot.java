package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CarLot {
    private ArrayList<Car> inventory;

    public CarLot(){
        this.inventory = new ArrayList<Car>();
        stockLot();
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }

    /*returns ArrayList populated with Car objects
    where .getYear matches the specified int year parameter.
     */

    public ArrayList<Car> getInventory(int year) {
        ArrayList<Car> carsByYear = new ArrayList<Car>();

        for (Car car : this.inventory){
            if(car.getYear() == year){
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }
    /*returns ArrayList populated with Car objects
    where .getMake matches the specified String make parameter
     */


    public ArrayList<Car> getInventory(String make) {
        ArrayList<Car> carsByMake = new ArrayList<Car>();

        for (Car car : this.inventory) {
            if (car.getMake().equalsIgnoreCase(make)) {
                carsByMake.add(car);
            }
        }
        return carsByMake;
    }


    public void addCar(Car car){
        this.inventory.add(car);
    }

    public void addCar(UsedCar car){
        this.inventory.add(car);
    }

    /*Prompts user to input car specifications.
      calls addCar method to add car with these specifications into CarLot object
     */


    public void addCarInfo(){
        String make = Validate.getString("Enter make: ");
        String model = Validate.getString("Enter model: ");
        int year = Validate.validateInt("Enter year: ");
        double price = Validate.validateDouble("Enter price; ");
        double mileage = Validate.validateDouble("Enter mileage: \n(Enter 0 for new car)");
        if (mileage==0){
            this.addCar(new Car(make,model,year,price));
        }else {
            this.addCar(new UsedCar(make, model,year,price, mileage));
        }
    }


    private void stockLot(){
        this.inventory.add(new Car("Ford", "Prizm", 2017, 15000));
        this.inventory.add(new Car("Ford", "Explorer", 2016, 25000));
        this.inventory.add(new Car("Acura", "TLX", 2017, 32480.5));
        this.inventory.add(new Car("Honda", "Accord", 2017, 26750.9));
        this.inventory.add(new UsedCar("Ford", "Explorer", 2010, 12795.50, 30106));
        this.inventory.add(new UsedCar("Chevrolet", "Prizm", 2000, 1090.3, 104400));
        this.inventory.add(new UsedCar("Ford", "Fusion", 2014, 16751, 11540));
    }

}
