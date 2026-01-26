package io.github.Kostaflo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

  // Instantiation του Service
  private final CalculatorService service = new CalculatorService();

  @Test
  void testAddition() {
    assertEquals(5.0, service.calculate(2, 3, "+"));
  }

  @Test
  void testDivision() {
    // Ελέγχουμε δεκαδικά
    double result = service.calculate(10, 4, "/");
    assertEquals(2.5, result);
  }

  @Test
  void testDivisionByZero() {
    // Ελέγχουμε αν πετάει το σωστό error
    assertThrows(
        ArithmeticException.class,
        () -> {
          service.calculate(5, 0, "/");
        });
  }

  @Test
  void testInvalidOperator() {
    // Ελέγχουμε αν πετάει το σωστό error για άγνωστο τελεστή
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          service.calculate(5, 3, "%");
        });
  }
}
