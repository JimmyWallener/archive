package se.gritacademy;

public class Mathematics {

    public long minLong(long n1, long n2){
        return Math.min(n1, n2);
    }
    public float minFloat(float n1, float n2){
        return Math.min(n1,n2);
    }
    public int minInteger(int n1, int n2){
        return Math.min(n1,n2);
    }
    public double minDouble(double n1, double n2){
        return Math.min(n1,n2);
    }
    public double powerOff(double base, double exponent){
        return Math.pow(base,exponent);
    }
    public int valueIntegerPlusOne(int base){
        return base + 1;
    }
    public long valueLongPlusOne(long base){
        return base + 1L;
    }
    public int valueIntegerMinusOne(int base){
        return base - 1;
    }
    public long valueLongMinusOne(long base){
        return base - 1L;
    }
    public double squaredOf(double sqr) {
        return Math.sqrt(sqr);
    }
    public double cubicValueOf(double cubic){
        return Math.cbrt(cubic);
    }




    public static void main(String[] args) {
    }
}
