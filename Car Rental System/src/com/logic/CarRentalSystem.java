/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com.logic;

import com.Car;
import com.Customer;
import com.Rental;
import com.data.DatabaseManager;
import com.exceptions.CarNotAvailableException;
import com.exceptions.InvalidInputException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The core logic for the car rental system.
 */
public class CarRentalSystem {
    private DatabaseManager dbManager;
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    /**
     * Initializes the car rental system, loading data from the database.
     */
    public CarRentalSystem() {
        dbManager = new DatabaseManager();
        cars = dbManager.loadCars();
        customers = dbManager.loadCustomers();
        rentals = dbManager.loadRentals();
    }

    /**
     * Rents a car to a customer.
     *
     * @param carId      The ID of the car to rent.
     * @param customerId The ID of the customer.
     * @param rentalDays The number of days to rent the car.
     * @return The new Rental object.
     * @throws CarNotAvailableException If the car is not available.
     * @throws InvalidInputException    If the car or customer ID is invalid.
     */
    public Rental rentCar(String carId, String customerId, int rentalDays) throws CarNotAvailableException, InvalidInputException {
        Car car = findCarById(carId).orElseThrow(() -> new InvalidInputException("Car not found."));
        Customer customer = findCustomerById(customerId).orElseThrow(() -> new InvalidInputException("Customer not found."));

        if (!car.isAvailable()) {
            throw new CarNotAvailableException("Car is already rented.");
        }

        car.rent();
        LocalDate rentalDate = LocalDate.now();
        LocalDate returnDate = rentalDate.plusDays(rentalDays);
        double totalCost = car.calculatePrice(rentalDays);

        String rentalId = UUID.randomUUID().toString();
        Rental newRental = new Rental(rentalId, car.getCarId(), customer.getCustomerId(), rentalDate, returnDate, totalCost);
        rentals.add(newRental);

        dbManager.saveCars(cars);
        dbManager.saveRentals(rentals);

        return newRental;
    }

    /**
     * Returns a rented car.
     *
     * @param carId The ID of the car to return.
     * @throws InvalidInputException If the car ID is invalid or the car was not rented.
     */
    public void returnCar(String carId) throws InvalidInputException {
        Car car = findCarById(carId).orElseThrow(() -> new InvalidInputException("Car not found."));

        if (car.isAvailable()) {
            throw new InvalidInputException("Car was not rented.");
        }

        car.returnCar();
        dbManager.saveCars(cars);
    }

    /**
     * Adds a new car to the system.
     *
     * @param car The car to add.
     */
    public void addCar(Car car) {
        cars.add(car);
        dbManager.saveCars(cars);
    }

    /**
     * Adds a new customer to the system.
     *
     * @param customer The customer to add.
     * @return The newly added customer.
     */
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        dbManager.saveCustomers(customers);
        return customer;
    }


    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).collect(Collectors.toList());
    }

    public Optional<Car> findCarById(String carId) {
        return cars.stream().filter(c -> c.getCarId().equalsIgnoreCase(carId)).findFirst();
    }

    public Optional<Customer> findCustomerById(String customerId) {
        return customers.stream().filter(c -> c.getCustomerId().equalsIgnoreCase(customerId)).findFirst();
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }
}
