import java.math.BigInteger;
import java.util.stream.Stream;
import java.util.function.Supplier;

/** Class which provides static methods to process streams of BigIntegers,
 * mainly summing elements, even numbers, prime numbers, or the squares of numbers divisible by three.
 */
public class IntStreamProcessor {
    /**
     * Calculates the sum of the first 'stop' elements in the stream provided by the supplier.
     * Uses a supplier to obtain a new stream each time the method is called.
     * @param streamSupplier A supplier providing a stream of BigIntegers
     * @param stop The number of elements to sum
     * @return The sum of the first 'stop' elements in the stream
     */
    public static BigInteger sumStream(Supplier<Stream<BigInteger>> streamSupplier, int stop) {
        return streamSupplier.get().limit(stop)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    /**
     * Calculates the sum of even numbers among the first 'stop' elements in the stream provided by the supplier.
     * Uses a supplier to obtain a new stream each time the method is called.
     * @param streamSupplier A supplier providing a stream of BigIntegers
     * @param stop The number of elements to consider
     * @return The sum of even numbers among the first 'stop' elements in the stream
     */
    public static BigInteger sumEvens(Supplier<Stream<BigInteger>> streamSupplier, int stop) {
        return streamSupplier.get().filter(num -> (num.mod(BigInteger.TWO)).equals(BigInteger.ZERO))
                .limit(stop)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    /**
     * Calculates the sum of prime numbers among the first 'stop' elements in the stream provided by the supplier.
     * Uses a supplier to obtain a new stream each time the method is called.
     * @param streamSupplier A supplier providing a stream of BigIntegers
     * @param stop The number of elements to consider
     * @return The sum of prime numbers among the first 'stop' elements in the stream
     */
    public static BigInteger sumPrimes(Supplier<Stream<BigInteger>> streamSupplier, int stop) {

        return streamSupplier.get().filter(IntStreamProcessor::isPrime)
                .limit(stop)
                .reduce(BigInteger.ZERO, BigInteger::add);

    }

    /**
     * Calculates the sum of squares of numbers divisible by three among the first 'stop' elements
     * in the stream provided by the supplier.
     * Uses a supplier to obtain a new stream each time the method is called.
     * @param streamSupplier A supplier providing a stream of BigIntegers
     * @param stop The number of elements to consider
     * @return The sum of squares of numbers divisible by three among the first 'stop' elements in the stream
     */
    public static BigInteger sumEveryThirdSquare(Supplier<Stream<BigInteger>> streamSupplier, int stop) {
        return streamSupplier.get().filter(IntStreamProcessor::isDivisibleBy3)
                .limit(stop)
                .map(num -> num.multiply(num))
                .reduce(BigInteger.ZERO, BigInteger::add);

        //num -> (num.mod(BigInteger.valueOf(3))).equals(BigInteger.ZERO)
    }

    /**
     * Checks if a given number is prime.
     * @param n The BigInteger number to check for primality
     * @return True if the number is prime, otherwise false
     */
    private static boolean isPrime(BigInteger n){


        if (n.compareTo(BigInteger.TWO) < 0) return false;
        for (BigInteger i = BigInteger.valueOf(2); i.multiply(i).compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO)) return false;
        }
        return true;


    }

    /**
     * Checks if a given number is divisible by 3.
     * @param n The BigInteger number to check for divisibility
     * @return True if the number is divisible, otherwise false
     */
    private static boolean isDivisibleBy3(BigInteger n){

        if(n.compareTo(BigInteger.valueOf(3)) < 0)
            return false;

        return n.mod(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) == 0;
    }


}