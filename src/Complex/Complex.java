package Complex;

// TODO: change parse
public class Complex {
    private final double real;
    private final double img;
    
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
    
    public static Complex parser(String str) {
        return new Complex(Double.parseDouble(str), 0.0);
    }

    @Override
    public String toString() {
        return "" + real + "+" + img;
    }
}