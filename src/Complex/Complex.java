package Complex;

/**
 * Implementation of a complex number in Java.
 */
public class Complex {
    private final double real;
    private final double img;
    
    /**
     * Constructor for the Complex class
     * @param real double of the real part
     * @param img double of the imaginary part
     */
    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }
    
    /**
     * Method used to take the value of the real component of the complex number
     * @return the value of the real part of the complex number
    */
    public double getReal() {
        return real;
    }

    /**
     * Method used to take the value of the imaginary component of the complex number
     * @return the value of the imaginary part of the complex number
    */
    public double getImg() {
        return img;
    }
    
    /**
     * Method to provide a hash code of the object
     * @return integer representing the hash code
    */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.img) ^ (Double.doubleToLongBits(this.img) >>> 32));
        return hash;
    }

    /**
     * Method used to perform equal comparison between two objects
     * @param obj object to compare
     * @return boolean representing the result of comparing two objects
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complex other = (Complex) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        return Double.doubleToLongBits(this.img) == Double.doubleToLongBits(other.img);
    }
    
    /**
     * Method to get the string associated with the complex number.
     * Ex. (real=10, img=-10) -> 10-10j; (real=10, img=0) -> 10+0j
     * @return String representation of the complex number.
     */
    @Override
    public String toString() {
        // Set this to change decimal places
        int precision = 2;
        
        double multiplier = Math.pow(10.0, precision);
        return "" + Math.round(real*multiplier)/multiplier + ((img >= 0.0) ? "+": "") + Math.round(img*multiplier)/multiplier + "j";
    }
}