/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com.data;

import com.Car;
import com.Customer;
import com.Rental;
import com.utils.Config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages data persistence for the car rental system using flat files.
 */
public class DatabaseManager {

    /**
     * Loads all cars from the data file.
     *
     * @return A list of all cars.
     */
    public List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.CARS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                cars.add(new Car(data[0], data[1], data[2], Double.parseDouble(data[3])));
            }
        } catch (IOException e) {
            // File might not exist on first run, which is okay.
        }
        return cars;
    }

    /**
     * Saves the list of cars to the data file.
     *
     * @param cars The list of cars to save.
     */
    public void saveCars(List<Car> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Config.CARS_FILE_PATH))) {
            for (Car car : cars) {
                writer.println(String.format("%s,%s,%s,%.2f",
                        car.getCarId(), car.getBrand(), car.getModel(), car.getBasePricePerDay()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all customers from the data file.
     *
     * @return A list of all customers.
     */
    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.CUSTOMERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                customers.add(new Customer(data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            // File might not exist on first run, which is okay.
        }
        return customers;
    }

    /**
     * Saves the list of customers to the data file.
     *
     * @param customers The list of customers to save.
     */
    public void saveCustomers(List<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Config.CUSTOMERS_FILE_PATH))) {
            for (Customer customer : customers) {
                writer.println(String.format("%s,%s,%s,%s",
                        customer.getCustomerId(), customer.getName(), customer.getMobileNumber(), customer.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all rental records from the data file.
     *
     * @return A list of all rental records.
     */
    public List<Rental> loadRentals() {
        List<Rental> rentals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Config.RENTALS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                rentals.add(new Rental(data[0], data[1], data[2], LocalDate.parse(data[3]), LocalDate.parse(data[4]), Double.parseDouble(data[5])));
            }
        } catch (IOException e) {
            // File might not exist on first run, which is okay.
        }
        return rentals;
    }

    /**
     * Saves the list of rental records to the data file.
     *
     * @param rentals The list of rental records to save.
     */
    public void saveRentals(List<Rental> rentals) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Config.RENTALS_FILE_PATH))) {
            for (Rental rental : rentals) {
                writer.println(String.format("%s,%s,%s,%s,%s,%.2f",
                        rental.getRentalId(), rental.getCarId(), rental.getCustomerId(),
                        rental.getRentalDate(), rental.getReturnDate(), rental.getTotalCost()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
