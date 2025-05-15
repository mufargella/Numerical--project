public class DifferentialEquationSolver {

    // Exact solution: y = ln|x^2 - 4x - 4|
    public static double yExact(double x) {
        return Math.log(Math.abs(x * x - 4 * x - 4));
    }

    // Derivative of y (dy/dx) from exact solution
    public static double f(double x, double y) {
        return (2 * x - 4) / (x * x - 4 * x - 4);
    }

    public static void main(String[] args) {
        double x0 = 5.0;
        double y0 = 0.0;
        double xn = 6.0;
        double h = 0.2;
        int n = (int)((xn - x0) / h);

        double xEuler = x0;
        double yEuler = y0;

        double xRK = x0;
        double yRK = y0;

        System.out.printf("%5s %12s %12s %12s%n", "x", "y_exact", "y_euler", "y_RK4");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i <= n; i++) {
            double x = x0 + i * h;
            double yEx = yExact(x);

            System.out.printf("%5.2f %12.6f %12.6f %12.6f%n", x, yEx, yEuler, yRK);

            if (i < n) {
                // Euler method
                yEuler = yEuler + h * f(xEuler, yEuler);
                xEuler += h;

                // RK4 method
                double k1 = h * f(xRK, yRK);
                double k2 = h * f(xRK + h / 2, yRK + k1 / 2);
                double k3 = h * f(xRK + h / 2, yRK + k2 / 2);
                double k4 = h * f(xRK + h, yRK + k3);
                double k = (k1 + 2 * k2 + 2 * k3 + k4) / 6;
                yRK += k;
                xRK += h;
            }
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("At x = 6.0, y_exact = %.6f, y_euler = %.6f, y_RK4 = %.6f%n",
                yExact(6.0), yEuler, yRK);
    }
}
