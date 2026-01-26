package io.github.Kostaflo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

  @FXML private TextField display;

  CalculatorService service = new CalculatorService();

  private double num1 = 0;
  private String operator = "";
  private boolean start = true;

  @FXML
  private void handleDigit(ActionEvent event) {
    String digit = ((Button) event.getSource()).getText();
    if (start) {
      display.setText(digit);
      start = false;
    } else {
      if (digit.equals(".") && display.getText().contains(".")) {
        return; // Prevent multiple decimals
      }
      display.setText(display.getText() + digit);
    }
  }

  @FXML
  private void handleOperator(ActionEvent event) {
    String newOperator = ((Button) event.getSource()).getText();
    if (start) {
      operator = newOperator;
      return;
    }
    double currentNum = Double.parseDouble(display.getText());
    if (!operator.isEmpty()) {
      try {
        double result = service.calculate(num1, currentNum, operator);
        display.setText(String.valueOf(result));
        num1 = result;
      } catch (ArithmeticException | IllegalArgumentException e) {
        display.setText("ERROR");
        start = true;
        return;
      }
    } else {
      num1 = currentNum;
    }
    operator = newOperator;
    start = true;
  }

  @FXML
  private void handleEquals(ActionEvent event) {
    if (operator.isEmpty() || start) {
      return;
    }
    double currentNum = Double.parseDouble(display.getText());
    try {
      double result = service.calculate(num1, currentNum, operator);
      display.setText(String.valueOf(result));
      operator = "";
      num1 = result;
      start = true;
    } catch (ArithmeticException | IllegalArgumentException e) {
      display.setText("ERROR");
      start = true;
    }
  }

  @FXML
  private void handleClear(ActionEvent event) {
    display.setText("0");
    num1 = 0;
    operator = "";
    start = true;
  }
}
