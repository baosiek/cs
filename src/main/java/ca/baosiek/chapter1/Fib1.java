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

    static Map<Integer, Long> memo = new HashMap<>();


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

        // base case.
        // fib1(0) = 0 and fib1(1) = 1. So...
        if(n < 2){
            return n;
        }

        long n1 = 0, n2 = 0;

        if (memo.containsKey(n-1)) {
            n1 = memo.get(n - 1);
        } else {

            n1 = fib2(n - 1);
            memo.put(n-1, n1);
        }

        if (memo.containsKey(n-2)) {
            n2 = memo.get(n - 2);
        } else {
            n2 = fib2(n - 2);
            memo.put(n-2, n2);
        }

        // Recursively computes fib of n-1 and n-2 until base case is reached
        return n1 + n2;

    }

    public static void main(String[] args){

        int n = 20; // where n is the element in the Fibonacci sequence being calculated

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
        System.out.printf("Computed in %s ms", sw.getTime());

    }
}
