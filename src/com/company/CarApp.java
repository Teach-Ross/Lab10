package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {
    static Scanner scnr = new Scanner(System.in);

    /*Displays numbered list of cars.
      Accepts ArrayList as a parameter. This allows user to narrrow or expand list using methods from CarLot Class.
      Calls displayCarsHeader method to display column headers
      Calls to allow user to select and purchase cars.
     */

    public static void displayCars(ArrayList<Car> cars) {
        if (!cars.isEmpty()) {
            displayCarsHeader();
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("Option #%d:  ", i + 1);
                System.out.println(cars.get(i).toString());
            }
            selectRemoveCar(cars);
        } else {
            System.out.println("Sorry there are no cars available");
        }
    }
    public static void displayCarsHeader(){
        System.out.printf("%-12s%-12s%-12s%-8s%-13s%-10s\n", " ", "Make", "Model", "Year", "Price", "Mileage");
    }

    /*Accepts an arrayList as parameter.
      Allows user to select one of these vehicles and then displays this vehicle specs
      Removes this car from the arrayList if user chooses to purchase this car.
     */

    public static void selectRemoveCar(ArrayList<Car> cars) {
        int select;
        String decision;
        String prompt = String.format("Which car would you like to select (1-%d): ", cars.size());
        select = Validate.validateInt(prompt, 1, cars.size());
        System.out.println(cars.get(select - 1).toString());
        decision = Validate.validateYesOrNo("Would you like to buy this car (Y/N)?");
        if (decision.equalsIgnoreCase("y")) {
            cars.remove(select - 1);
            System.out.println("Great! Our finance department will be in touch shortly.");
        }
    }


    public static void main(String[] args) {
        String userString;
        int userNum;
        boolean continueLoop = true;
        CarLot carLot = new CarLot();

        System.out.println("Welcome to Detroit Car Lot");
        /* Main menu allows user to navigate features of CarApp
           Uses CarLot methods to determine which ArrayLists should be passed into displayCars method
         */
        while (continueLoop) {
            System.out.println("1: To view entire car inventory");
            System.out.println("2: To view car inventory by year");
            System.out.println("3: To view car inventory by make");
            System.out.println("4: To add car to inventory");
            System.out.println("5: To exit");
            userNum = Validate.validateInt("Please select (1-5): ", 1, 5);
            if (userNum == 1) {
                displayCars(carLot.getInventory());
            } else if (userNum == 2) {
                userNum = Validate.validateInt("Enter car year: ");
                displayCars(carLot.getInventory(userNum));
            } else if (userNum == 3) {
                userString = Validate.getString("Enter car make: ");
                displayCars(carLot.getInventory(userString));
            } else if (userNum == 4) {
                carLot.addCarInfo();
            } else {
                continueLoop = false;
                System.out.println("Goodbye!");
                System.exit(0);
            }
            userString = Validate.validateYesOrNo("Would you like to return to main menu? (Y/N)");
            if (userString.equalsIgnoreCase("n")) {
                continueLoop = false;
            }
        }
        System.out.println("Goodbye!");
    }
}



