/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com;

/**
 * Represents a car in the car rental system.
 */
public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    /**
     * Constructs a new Car object.
     *
     * @param carId           The unique ID of the car.
     * @param brand           The brand of the car.
     * @param model           The model of the car.
     * @param basePricePerDay The base price per day for renting the car.
     */
    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    /**
     * Calculates the total price for renting the car for a given number of days.
     *
     * @param rentalDays The number of days to rent the car.
     * @return The total rental price.
     */
    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    /**
     * Marks the car as rented.
     */
    public void rent() {
        isAvailable = false;
    }

    /**
     * Marks the car as returned and available.
     */
    public void returnCar() {
        isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", basePricePerDay=" + basePricePerDay +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
