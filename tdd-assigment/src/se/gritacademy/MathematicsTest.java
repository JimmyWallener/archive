package se.gritacademy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.DoubleStream;


import static org.junit.jupiter.api.Assertions.assertEquals;


class MathematicsTest {
    private Mathematics math;

    @BeforeEach
    void setUp(){
        math = new Mathematics();
    }
    @Test
    void testMinLong() {
        long n1 = 2000000000L;
        long n2 = 1000000000L;
        long expected = 1000000000L;
        assertEquals(expected,math.minLong(n1,n2));
    }

    @Test
    void testMinFloat() {
        float n1 = 3.212f;
        float n2 = 1.2345f;
        float expected = 1.2345f;
        assertEquals(expected,math.minFloat(n1,n2));
    }

    @Test
    void testMinInteger() {
        int n1 = 273273;
        int n2 = 123;
        int expected = 123;
        assertEquals(expected,math.minInteger(n1,n2));
    }

    @Test
    void testMinDouble() {
        double n1 = 16.02d;
        double n2 = 12.00d;
        double expected = 12.00d;
        assertEquals(expected,math.minDouble(n1,n2));
    }

    @Test
    void testPowerOff() {
        double base = 6.00d;
        double exponent = 2.00d;
        double expected = 36.00d;
        assertEquals(expected,math.powerOff(base,exponent));
    }

    @Test
    void testValueIntegerPlusOne() {
        int base = 3;
        int expected = 4;
        assertEquals(expected, math.valueIntegerPlusOne(base));
    }

    @Test
    void testValueLongPlusOne() {
        long base = 3000000000L;
        long expected = 3000000001L;
        assertEquals(expected,math.valueLongPlusOne(base));
    }
    @Test
    void testValueIntegerMinusOne() {
        int base = 3;
        int expected = 2;
        assertEquals(expected, math.valueIntegerMinusOne(base));
    }

    @Test
    void testValueLongMinusOne() {
        long base = 3000000000L;
        long expected = 2999999999L;
        assertEquals(expected,math.valueLongMinusOne(base));
    }

    @Test
    void testSquaredOf() {
        double sqr = 36.00d;
        double expected = 6.00d;
        assertEquals(expected,math.squaredOf(sqr));
    }

    @Test
    void testCubicValueOf() {
        double cubic = 120.00d;
        double expected = 4.932424148660941d;
        assertEquals(expected, math.cubicValueOf(cubic));

    }

    /*
    *  setting delta at 0.9d so that run time ends at some point
    *  set MathematicsTest.randomValue[*] in configuration for endless loop until failure
    */

    @ParameterizedTest
    @MethodSource("randomNumber")
    void randomValue(double number) {
        double expected = 0.0d;
        double delta = 0.9d;
        assertEquals(expected,number,delta);
    }
    static DoubleStream randomNumber(){
        return DoubleStream.of(Math.random());
    }

}