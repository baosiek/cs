package ca.baosiek.chapter1;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * <h1>Fibonacci Sequence</h1>
 *
 * Goal: Print the Fibonacci sequente up to n
 *
 * Here we use the iterative method with Java Stream API
 *
 *
 * @author  Bruno Adam Osiek
 * @version 0.2
 */
public class FibonacciSequence {

    private long fib_1 = 0, fib_2 = 1;

    public LongStream stream(){

        return LongStream.generate(() -> {
             long fib = fib_1 + fib_2;
             fib_1 = fib_2;
             fib_2 = fib;
             return fib;
        });
    }

    public static void main(String[] args) {

        int n = 35;
        FibonacciSequence fib = new FibonacciSequence();

        // Printing rest of the sequence up to n-2 because 0 and 1 were already printed
        if (n<3){
            System.out.println("Here a Fibonacci sequence should have at least three numbers. Exiting...");
            System.exit(0);
        }

        //Printing base cases
        System.out.println(0);
        System.out.println(1);


        fib.stream().limit(n-2).forEachOrdered(System.out::println);
    }


}
