/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com.exceptions;

/**
 * Custom exception for when a car is not available for rent.
 */
public class CarNotAvailableException extends Exception {
    public CarNotAvailableException(String message) {
        super(message);
    }
}
