package com.realstate.RS.exception;

public class ExceptionDemo {

    public static void main(String[] args) {

        try {

            int[] prices = {10000, 20000, 30000};

            System.out.println("Property Price: " + prices[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Exception handled: Property index does not exist."
            );
        }

        try {

            int result = 100 / 0;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Exception handled: Cannot divide by zero."
            );
        }

        System.out.println("Program continued successfully.");
    }
}