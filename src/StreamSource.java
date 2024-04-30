import java.math.BigInteger;
import java.util.stream.*;

/**
 * Static class that provides static methods to generate various infinite streams of BigIntegers.
 */
public class StreamSource {
    public static String stream_name = "";

    /**
     * Generates a stream of positive integers.
     * Updates the stream_name field to indicate that the generated stream contains positive integers.
     * @return Stream of positive integers
     */
    public  static Stream<BigInteger> positiveIntegers() {
        stream_name = "Positive Integers";

        return Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
    }

    /**
     * Generates a stream of Fibonacci numbers.
     * Updates the stream_name variable to indicate that the generated stream contains Fibonacci numbers.
     * @return Stream of Fibonacci numbers
     */
    public static Stream<BigInteger> fibonacciNumbers() {
        stream_name = "Fibonacci Numbers";

        return Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                        pair -> new BigInteger[]{pair[1], pair[0].add(pair[1])})
                .map(pair -> pair[0]);
    }

    /**
     * Generates a stream of triangular numbers.
     * Updates the stream_name variable to indicate that the generated stream contains triangular numbers.
     * @return Stream of triangular numbers
     */
    public static Stream<BigInteger> triangularNumbers() {
        stream_name = "Triangular Numbers";

        return Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE},
                        pair -> new BigInteger[]{pair[0].add(BigInteger.ONE), pair[1].add(pair[0].add(BigInteger.ONE))})
                .map(pair -> pair[1]);
    }
}


