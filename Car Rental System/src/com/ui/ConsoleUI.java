/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com.ui;

import com.Car;
import com.Customer;
import com.Rental;
import com.exceptions.CarNotAvailableException;
import com.exceptions.InvalidInputException;
import com.logic.CarRentalSystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * The console user interface for the car rental system.
 */
public class ConsoleUI {
    private CarRentalSystem rentalSystem;
    private Scanner scanner;

    /**
     * Initializes the console UI.
     */
    public ConsoleUI() {
        rentalSystem = new CarRentalSystem();
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the main menu loop.
     */
    public void start() {
        while (true) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        rentCar();
                        break;
                    case 2:
                        returnCar();
                        break;
                    case 3:
                        addCar();
                        break;
                    case 4:
                        addCustomer();
                        break;
                    case 5:
                        listAvailableCars();
                        break;
                    case 6:
                        listCustomers();
                        break;
                    case 7:
                        listRentals();
                        break;
                    case 8:
                        System.out.println("Thank you for using the Car Rental System!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Car Rental System =====");
        System.out.println("1. Rent a Car");
        System.out.println("2. Return a Car");
        System.out.println("3. Add a New Car");
        System.out.println("4. Add a New Customer");
        System.out.println("5. List Available Cars");
        System.out.println("6. List Customers");
        System.out.println("7. List Rentals");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void rentCar() {
        try {
            listAvailableCars();
            System.out.print("Enter the car ID to rent: ");
            String carId = scanner.nextLine();

            listCustomers();
            System.out.print("Enter the customer ID: ");
            String customerId = scanner.nextLine();

            System.out.print("Enter the number of days for rental: ");
            int rentalDays = scanner.nextInt();
            scanner.nextLine();

            Rental rental = rentalSystem.rentCar(carId, customerId, rentalDays);
            System.out.println("Car rented successfully!");
            System.out.println("Rental Details: " + rental);

        } catch (CarNotAvailableException | InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input for rental days.");
            scanner.nextLine();
        }
    }

    private void returnCar() {
        try {
            System.out.print("Enter the car ID to return: ");
            String carId = scanner.nextLine();

            rentalSystem.returnCar(carId);
            System.out.println("Car returned successfully!");

        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void addCar() {
        try {
            System.out.print("Enter car brand: ");
            String brand = scanner.nextLine();

            System.out.print("Enter car model: ");
            String model = scanner.nextLine();

            System.out.print("Enter base price per day: ");
            double basePricePerDay = scanner.nextDouble();
            scanner.nextLine();

            String carId = UUID.randomUUID().toString();

            Car car = new Car(carId, brand, model, basePricePerDay);
            rentalSystem.addCar(car);
            System.out.println("Car added successfully!");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input for base price.");
            scanner.nextLine();
        }
    }

    private void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        String customerId = UUID.randomUUID().toString();

        Customer customer = new Customer(customerId, name, mobileNumber, email);
        rentalSystem.addCustomer(customer);
        System.out.println("Customer added successfully!");
    }

    private void listAvailableCars() {
        List<Car> availableCars = rentalSystem.getAvailableCars();
        System.out.println("\n--- Available Cars ---");
        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent.");
        } else {
            for (Car car : availableCars) {
                System.out.println(car);
            }
        }
    }

    private void listCustomers() {
        List<Customer> customers = rentalSystem.getAllCustomers();
        System.out.println("\n--- Customers ---");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private void listRentals() {
        List<Rental> rentals = rentalSystem.getAllRentals();
        System.out.println("\n--- Rentals ---");
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental);
            }
        }
    }
}
