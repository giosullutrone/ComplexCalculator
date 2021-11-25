package Complex;

import AlertMessage.AlertMessage;

/**
 * Implementation of a complex number in Java.
 */
public class Complex {
    private double real;
    private double img;
    
    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }
    

    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.img) ^ (Double.doubleToLongBits(this.img) >>> 32));
        return hash;
    }
    
    public Complex conj() {
        return new Complex(real,-img);
    }

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
        if (Double.doubleToLongBits(this.img) != Double.doubleToLongBits(other.img)) {
            return false;
        }
        return true;
    }
    
    // TODO: precision string
    /**
     * Method to get the string associated with the complex number.
     * Ex. (real=10, img=-10) -> 10-10j; (real=10, img=0) -> 10+0j
     * @return String representation of the complex number.
     */
    @Override
    public String toString() {
        return "" + real + ((img >= 0.0) ? "+": "") + img + "j";
    }
}