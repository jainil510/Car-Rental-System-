# Car Rental System

This is a simple command-line car rental system built with Java.

**Author:** Jainil Ulhas Patil
**GitHub:** [github.com/jainil510](https://github.com/jainil510)

## Project Structure

The project is organized into the following packages:

- `com`: The root package.
- `com.data`: Contains the `DatabaseManager` class for handling data persistence.
- `com.exceptions`: Contains custom exception classes.
- `com.logic`: Contains the core business logic of the application in the `CarRentalSystem` class.
- `com.ui`: Contains the `ConsoleUI` class for handling user interactions.
- `com.utils`: Contains the `Config` class for storing configuration constants.

## How to Compile and Run

1.  **Compile the code:**

    Open a terminal and navigate to the `Car Rental System/src` directory. Then, run the following command:

    ```bash
    javac -d . Main.java com/data/DatabaseManager.java com/utils/Config.java com/logic/CarRentalSystem.java com/exceptions/CarNotAvailableException.java com/exceptions/InvalidInputException.java com/ui/ConsoleUI.java
    ```

2.  **Run the application:**

    From the `Car Rental System/src` directory, run the following command:

    ```bash
    java Main
    ```

## How to Add Initial Data

The application uses CSV files to store data for cars, customers, and rentals. These files are located in the `data` directory, which will be created automatically when you first run the application.

-   `data/cars.csv`: Stores car information in the format: `carId,brand,model,basePricePerDay`
-   `data/customers.csv`: Stores customer information in the format: `customerId,name,mobileNumber,email`
-   `data/rentals.csv`: Stores rental information in the format: `rentalId,carId,customerId,rentalDate,returnDate,totalCost`

You can manually add data to these files to populate the system with initial data. For example, to add a car, you could add the following line to the `data/cars.csv` file:

```csv
car1,Toyota,Camry,50.0
```
