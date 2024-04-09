import org.apache.commons.math3.complex.Complex;

public class Main {

    public static void main(String[] args) {
        // Coefficients of the transfer function: H(s) = (b0*s^2 + b1*s + b2) / (a0*s^2 + a1*s + a2)
        double b0 = 1.0;
        double b1 = 2.0;
        double b2 = 3.0;
        double a0 = 1.0;
        double a1 = 0.5;
        double a2 = 0.25;

        // Calculate poles and zeros using the coefficients
        Complex[] zeros = calculateZeros(b0, b1, b2);
        Complex[] poles = calculatePoles(a0, a1, a2);

        // Print the results
        System.out.println("Zeros:");
        for (Complex zero : zeros) {
            System.out.println(zero);
        }

        System.out.println("Poles:");
        for (Complex pole : poles) {
            System.out.println(pole);
        }
    }

    // Calculate zeros using coefficients
    public static Complex[] calculateZeros(double b0, double b1, double b2) {
        Complex[] zeros = new Complex[2];
        zeros[0] = new Complex(-b1 / (2 * b0), 0);
        zeros[1] = zeros[0].conjugate();
        return zeros;
    }

    // Calculate poles using coefficients
    public static Complex[] calculatePoles(double a0, double a1, double a2) {
        Complex[] poles = new Complex[2];
        poles[0] = new Complex(-a1 / (2 * a0), Math.sqrt(4 * a0 * a2 - a1 * a1) / (2 * a0));
        poles[1] = poles[0].conjugate();
        return poles;
    }
}

