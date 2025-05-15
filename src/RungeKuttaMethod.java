public class RungeKuttaMethod {
    public static void main(String[] args) {
        // Initial conditions
        double x0 = 0.0;
        double y0 = 1.0;
        double xn = 1.0;
        double h = 0.2;
        int n = (int) ((xn - x0) / h); // Number of steps

        // Print table header
        System.out.println("x\t\ty");
        System.out.println("-------------------");
        System.out.printf("%.1f\t\t%.4f%n", x0, y0); // Initial row

        double currentX = x0;
        double currentY = y0;

        // Perform RK4 iterations
        for (int i = 0; i < n; i++) {
            double k1 = h * f(currentX, currentY);
            double k2 = h * f(currentX + h/2, currentY + k1/2);
            double k3 = h * f(currentX + h/2, currentY + k2/2);
            double k4 = h * f(currentX + h, currentY + k3);

            double weightedK = (k1 + 2*k2 + 2*k3 + k4) / 6;
            double nextY = currentY + weightedK;

            currentX += h; // Update x
            currentY = nextY; // Update y

            // Print current x and y (formatted to 4 decimal places)
            System.out.printf("%.1f\t\t%.4f%n", currentX, currentY);
        }
    }

    // Define the differential equation dy/dx = x + y²
    public static double f(double x, double y) {
        return x + Math.pow(y, 2);
    }
}