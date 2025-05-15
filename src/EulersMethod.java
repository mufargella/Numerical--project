public class EulersMethod {
    public static void main(String[] args) {
        // Initial conditions
        double x0 = 0.0;
        double y0 = 1.0;
        double xn = 1.0;
        double h = 0.2;

        // Calculate number of steps
        int n = (int)((xn - x0) / h);

        // Print header
        System.out.println("x\t\ty");
        System.out.println("-------------------");

        // Print initial values
        System.out.printf("%.1f\t\t%.4f%n", x0, y0);

        double currentX = x0;
        double currentY = y0;

        for (int i = 0; i < n; i++) {
            // Calculate next y using Euler's formula
            double nextY = currentY + h * f(currentX, currentY);
            // Update x and y for the next iteration
            currentX += h;
            currentY = nextY;

            // Print current x and y (formatted to match the table)
            System.out.printf("%.1f\t\t%.4f%n", currentX, currentY);
        }
    }

    // Define the differential equation dy/dx = x + y
    public static double f(double x, double y) {
        return x + y;
    }
}