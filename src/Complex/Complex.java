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
    
    //public static Complex parser(String str) {
    //    return new Complex(Double.parseDouble(str), 0.0);
    //}

    @Overrides
    public String toString() {
        if(Double.toString(img).contains("-"))
            return "" + real + img + "j";
        else
            return "" + real + "+" +img + "j";
    }
}