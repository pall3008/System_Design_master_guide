class Calculator {
    // Two ints
    int add(int a, int b) {
        return a + b;
    }

    // Two doubles
    double add(double a, double b) {
        return a + b;
    }

    // Three ints
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class polymorphism_compile_time {
     public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));        // Calls add(int, int) -> 5
        System.out.println(calc.add(2.5, 3.5));    // Calls add(double, double) -> 6.0
        System.out.println(calc.add(1, 2, 3));     // Calls add(int, int, int) -> 6
    }
}
