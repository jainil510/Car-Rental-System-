/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com.exceptions;

/**
 * Custom exception for invalid user input.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
