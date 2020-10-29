package ca.baosiek.chapter1;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Fibonacci sequence</h1>
 *
 * Goal: Refresh recursive programming and memoization
 *
 * The Fib1 class implements two methods to compute the Fibonacci sequence.
 * The first is fib1, where through recursion the number for each element in
 * the sequence is computed.
 * The second fib2 does the same thing, only this time,
 * with memoization which speeds up the computing time by storing already
 * computed elements in the sequence.
 *
 *
 * @author  Bruno Adam Osiek
 * @version 0.2
 */
public class Fib1 {

    // Starts memo with base case.
    static Map<Integer, Long> memo = new HashMap<>(
            Map.of(Integer.valueOf(0),Long.valueOf(0),Integer.valueOf(1),Long.valueOf(1)));


    /*
    Computes the element recursively without memoization
     */
    private static int fib1(int n){

        // base case.
        // fib1(0) = 0 and fib1(1) = 1. So...
        if(n < 2){
            return n;
        }

        // Recursively computes fib of n-1 and n-2 until base case is reached
        return fib1(n - 1) + fib1(n - 2);
    }

    /*
    Computes the element recursively with memoization
     */
    private static long fib2(int n){

        // Recursively computes fib2 of n-1 and n-2 until base case is reached.
        // This time it will be reached because the memo map was initialized with them.
        if (!memo.containsKey(n)) {
            memo.put(n, fib2(n-1)+fib2(n-2));
        }


        return memo.get(n);

    }

    // Iterative method. The most efficient
    private static long fib3(int n){

        //
        long fib = 0, fib_1 = 0, fib_2 = 1;

        for (int i = 0; i < n; i++) {

            fib = fib_1 + fib_2;
            fib_1 = fib_2;
            fib_2 = i;
        }

        return fib;
    }

    public static void main(String[] args){

        int n = 40; // where n is the element in the Fibonacci sequence being calculated

        // Instantiate and starts the stopwatch
        StopWatch sw = new StopWatch();
        sw.start();

        // Compute and print the result
        System.out.printf("fib1(%d) -> %d. ", n, fib1(n));

        // Computes and prints processing time
        sw.stop();
        System.out.printf("Computed in %s ms\n", sw.getTime());

        // Now processing the same number with fib2
        sw.reset();
        sw.start();

        // Compute and print the result
        System.out.printf("fib2(%d) -> %d. ", n, fib2(n));

        // Computes and prints processing time
        sw.stop();
        System.out.printf("Computed in %s ms\n", sw.getTime());

        // Now processing the same number with fib3
        sw.reset();
        sw.start();

        // Compute and print the result
        System.out.printf("fib3(%d) -> %d. ", n, fib2(n));

        // Computes and prints processing time
        sw.stop();
        System.out.printf("Computed in %s ms", sw.getTime());

    }
}
