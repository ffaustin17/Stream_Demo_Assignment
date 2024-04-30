import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**Class contains that tests the functionalities of the StreamSource and IntStreamProcessor classes,
 * effectively generating and displaying various streams of BigIntegers, and performing operations on these streams.
 */
public class StreamTester {

    /**main testing method of the StreamTester class*/
    public static void test() {

        // Test StreamSource
        System.out.println("StreamSource Test:");
        System.out.println();
        testStreamSource(StreamSource.positiveIntegers(), 5);
        testStreamSource(StreamSource.fibonacciNumbers(), 10);
        testStreamSource(StreamSource.triangularNumbers(), 7);


        System.out.println();

        // Test IntStreamProcessor
        System.out.println("IntStreamProcessor Test:");

        System.out.println();


        // Create a supplier for positive integers stream
        Supplier<Stream<BigInteger>> positiveIntegersSupplier = StreamSource::positiveIntegers;
        String stream_name = "Positive Integers";
        System.out.println("1) For the " + stream_name + " stream: ");
        System.out.println();
        testIntStreamProcessor(positiveIntegersSupplier, 5);
        System.out.println("Sum of the first " + 5 + " prime  elements = " + IntStreamProcessor.sumPrimes(positiveIntegersSupplier, 5));

        System.out.println();

        // Create a supplier for fibonacci numbers stream
        Supplier<Stream<BigInteger>> fibonacciNumbersSupplier = StreamSource::fibonacciNumbers;
        stream_name = "Fibonacci Numbers";
        System.out.println("2) For the " + stream_name + " stream: ");
        System.out.println();
        testIntStreamProcessor(fibonacciNumbersSupplier, 10);
        System.out.println("Sum of the first " + 10 + " prime  elements = " + IntStreamProcessor.sumPrimes(fibonacciNumbersSupplier, 10));

        System.out.println();

        // Create a supplier for  triangular numbers stream
        Supplier<Stream<BigInteger>> triangularNumbersSupplier = StreamSource::triangularNumbers;
        stream_name = "Triangular Numbers";
        System.out.println("3) For the " + stream_name + " stream: ");
        System.out.println();
        testIntStreamProcessor(triangularNumbersSupplier, 73);
        // interestingly, there seems to be no other prime numbers in the set of triangular numbers aside from 3. So we refrain from using the Sum of primes for this one,
        // As we will encounter an infinite loop from the IntStreamProcessor trying to find the stop number of elements that are prime. It probably never will.
        // if you really have nothing else to do, you can try it out too.
        // System.out.println("Sum of the first " + stop + " prime elements = " + IntStreamProcessor.sumPrimes(triangularNumberSupplier, 7));

    }

    /**
     * Displays the first 'limit' elements of the provided stream.
     * @param stream The stream to display
     * @param limit The number of elements to display
     */
    private static void testStreamSource(Stream<BigInteger> stream, int limit) {
        String correct_element_spelling = "element";

        if(limit > 0)
            correct_element_spelling = "elements";

        System.out.println("Displaying the first " + limit + " " + correct_element_spelling + " of the " + StreamSource.stream_name + " stream:");
        stream.limit(limit).forEach(System.out::println);
        System.out.println();

    }

    /**
     * Displays the results of IntStreamProcessor methods for the provided stream.
     * @param stream A supplier providing a stream of BigIntegers
     * @param stop The number of elements to consider
     */
    private static void testIntStreamProcessor(Supplier<Stream<BigInteger>> stream, int stop) {
        String correct_element_spelling = "element";

        if(stop > 0)
            correct_element_spelling = "elements";

        System.out.println("Sum of the first " + stop + " " + correct_element_spelling + " = " + IntStreamProcessor.sumStream(stream, stop));

        System.out.println("Sum of the first " + stop + " even " + correct_element_spelling + " = " + IntStreamProcessor.sumEvens(stream, stop));

        System.out.println("Sum of the square of the first " + stop + " " + correct_element_spelling + " divisible by 3 = " + IntStreamProcessor.sumEveryThirdSquare(stream, stop));

    }
}