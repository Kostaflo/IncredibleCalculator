package io.github.Kostaflo;

public class CalculatorService {

  public double calculate(double a, double b, String operator) {

    return switch (operator) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "*" -> a * b;
      case "/" -> {
        if (b == 0) {
          throw new ArithmeticException("Division by zero is not allowed.");
        }
        yield a / b;
      }
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
  }
}
