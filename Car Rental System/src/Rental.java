/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com;

import java.time.LocalDate;

/**
 * Represents a rental transaction in the car rental system.
 */
public class Rental {
    private String rentalId;
    private String carId;
    private String customerId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;

    /**
     * Constructs a new Rental object.
     *
     * @param rentalId    The unique ID of the rental transaction.
     * @param carId       The ID of the rented car.
     * @param customerId  The ID of the customer renting the car.
     * @param rentalDate  The date the car was rented.
     * @param returnDate  The date the car is due to be returned.
     * @param totalCost   The total cost of the rental.
     */
    public Rental(String rentalId, String carId, String customerId, LocalDate rentalDate, LocalDate returnDate, double totalCost) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerId = customerId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId='" + rentalId + '\'' +
                ", carId='" + carId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", totalCost=" + totalCost +
                '}';
    }
}
